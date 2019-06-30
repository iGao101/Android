package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

//TODO 绘制边框矩形，单像素宽黑线
public class SimpleFrame extends BaseVisualElement {
    //TODO constructor
    public SimpleFrame(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w, h);
    }

    @Override
    public void draw(Canvas onCanvas){
        onCanvas.save();  //TODO 保存canvas状态
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.BLACK);
        rectPaint.setStyle(Paint.Style.STROKE);  //TODO 空心
        rectPaint.setStrokeWidth(1);
        onCanvas.drawRect(0,0,this.mWidth, this.mHeight,rectPaint);

        if(!this.mChildrenList.isEmpty()){
            for(int i =0; i < this.mChildrenList.size(); i++)
                this.mChildrenList.get(i).draw(onCanvas);
        }

        onCanvas.restore();  //TODO 恢复之前canvas的状态
    }
}
