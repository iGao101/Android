package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;

//TODO 提供覆盖其整个定义区域的纯色背景的类
public class SolidBackDrop extends BaseVisualElement {
    private int mColor;  //TODO 背景颜色

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

    //TODO Constructor
    public SolidBackDrop(float x, float y, float w, float h, int color){
        this.setPosition(x,y);
        this.setSize(w,h);
        this.setmColor(color);
    }

    @Override
    public void draw(Canvas onCanvas){
        onCanvas.save();
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        Paint fillPaint = new Paint();
        fillPaint.setColor(mColor);
        onCanvas.drawRect(0,0,this.mWidth,this.mHeight,fillPaint);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }
}
