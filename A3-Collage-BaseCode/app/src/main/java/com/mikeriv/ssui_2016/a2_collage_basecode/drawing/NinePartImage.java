package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;

//TODO 显示9个图像类
public class NinePartImage extends BaseVisualElement {

    private NinePatch mNinePatch;

    public void setmNinePatch(NinePatch mNinePatch) {
        this.mNinePatch = mNinePatch;
    }

    //TODO Constructor
    public NinePartImage(float x, float y, float w, float h, NinePatch patch){
        this.setPosition(x,y);
        this.setSize(w,h);
        this.setmNinePatch(patch);
    }

    @Override
    public void draw(Canvas onCanvas){
        onCanvas.save();
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        RectF ninePatchRect = new RectF(0,0,this.mWidth, this.mHeight);
        this.mNinePatch.draw(onCanvas, ninePatchRect);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }
}
