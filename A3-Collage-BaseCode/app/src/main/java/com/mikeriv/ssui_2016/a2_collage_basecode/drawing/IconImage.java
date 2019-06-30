package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

//TODO 显示位图图像类
public class IconImage extends BaseVisualElement {
    private Bitmap mBitmap;

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
        this.mHeight = mBitmap.getHeight();
        this.mWidth = mBitmap.getWidth();
    }

    @Override
    public boolean sizeIsIntrinsic() {
        return true;  //TODO 具有内部大小返回真
    }

    //TODO Constructor
    public IconImage(float x,float y, Bitmap image){
        this.setPosition(x,y);
        this.setmBitmap(image);
    }

    @Override
    public void draw(Canvas onCanvas){
        onCanvas.save();

        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);
        onCanvas.translate(this.mPosX,this.mPosY);

        Paint bitmapPaint = new Paint();
        if(mBitmap != null){
            onCanvas.drawBitmap(mBitmap,0,0,bitmapPaint);
        }

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }
}
