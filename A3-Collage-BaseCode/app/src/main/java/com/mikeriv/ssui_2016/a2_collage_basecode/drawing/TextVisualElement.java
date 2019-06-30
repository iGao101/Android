package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

import java.lang.reflect.Type;

//TODO  给定内容、大小、样式和颜色显示文本字符串的类
public class TextVisualElement extends BaseVisualElement {
    String mText;      //TODO 字体
    Typeface mTypeFace; //TODO 样式
    Float mTextSize; //TODO 大小
    int color = 0;       //TODO 颜色

    public void setmText(String mText) {
        this.mText = mText;
    }

    public void setmTypeFace(Typeface mTypeFace) {
        this.mTypeFace = mTypeFace;
    }

    public void setmTextSize(Float mTextSize) {
        this.mTextSize = mTextSize;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setText(String text, Typeface type, float size){
        this.setmText(text);
        this.setmTypeFace(type);
        this.setmTextSize(size);

        //TODO 计算文本宽和高
        Paint textPaint = new Paint();
        Rect bounds = new Rect();
        textPaint.setTextSize(size);
        textPaint.getTextBounds(text,0,text.length(),bounds);
        //TODO 设置宽高
        this.mHeight = textPaint.getFontMetrics().descent - textPaint.getFontMetrics().ascent + textPaint.getFontMetrics().leading;
        this.mWidth = textPaint.measureText(text);
    }

    @Override
    public boolean sizeIsIntrinsic(){
        return true;
    }

    //TODO Constructor
    public TextVisualElement(float x, float y, String text, Typeface type, float size){
        this.setPosition(x,y);
        this.setText(text, type, size);
    }

    public TextVisualElement(float x, float y, String text, Typeface type, float size, int color){
        this.setPosition(x,y);
        this.setText(text, type, size);
        this.setColor(color);
    }

    @Override
    public void draw(Canvas onCanvas){
        onCanvas.save();
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        Paint textPaint = new Paint();
        if(color != 0)
            textPaint.setColor(color);
        textPaint.setTypeface(this.mTypeFace);
        textPaint.setTextSize(this.mTextSize);
        textPaint.setTextAlign(Paint.Align.LEFT);  //TODO 以x为起点向右延伸

        onCanvas.drawText(this.mText,0,-textPaint.getFontMetrics().ascent,textPaint);

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }
}

