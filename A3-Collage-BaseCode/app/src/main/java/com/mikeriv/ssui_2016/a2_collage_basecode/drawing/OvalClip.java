package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

//TODO 椭圆
public class OvalClip extends BaseVisualElement {
    //TODO Constructor
    public OvalClip(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }

    @Override
    public void draw(Canvas onCanvas){
        onCanvas.save();
        //TODO 使用Path类创建
        Path oval = new Path();
        RectF rectOval = new RectF(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        oval.addOval(rectOval, Path.Direction.CCW);
        onCanvas.clipPath(oval);
        onCanvas.translate(this.mPosX,this.mPosY);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }
}
