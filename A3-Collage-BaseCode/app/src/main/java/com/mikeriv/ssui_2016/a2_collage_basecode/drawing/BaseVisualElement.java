package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.PointF;

import java.util.ArrayList;

//TODO 继承自PrebaseVisualElement，作为其他绘图类的父类
public class BaseVisualElement extends PrebaseVisualElement {

    float mPosX;
    float mPosY;
    float mWidth;
    float mHeight;

    VisualElement mParent;
    ArrayList<VisualElement> mChildrenList = new ArrayList<>();

    //TODO 设置位置
    @Override
    public void setPosition(PointF pos){
        if(pos != null)
            setPosition(pos.x, pos.y);
    }

    @Override
    public void setPosition(float x, float y){
        setX(x);
        setY(y);
    }

    @Override
    public void setX(float x) {
        this.mPosX = x;
    }

    @Override
    public void setY(float y) {
        this.mPosY = y;
    }

    @Override
    public PointF getPosition(){
        return new PointF(getX(), getY());
    }

    @Override
    public float getX() {
        return mPosX;
    }

    @Override
    public float getY() {
        return mPosY;
    }

    @Override
    public boolean sizeIsIntrinsic() {
        // default value -- override in subclasses that need to...
        return false;
    }

    @Override
    public void setSize(PointF size) {
        if (size != null) {
            setSize(size.x,size.y);
        }
    }

    @Override
    public void setSize(float w, float h) {
        setW(w);
        setH(h);
    }

    @Override
    public void setW(float w) {
        if (!this.sizeIsIntrinsic())
            this.mWidth = w;
    }

    @Override
    public void setH(float h) {
        if (!this.sizeIsIntrinsic())
            this.mHeight = h;
    }

    @Override
    public PointF getSize() {
        return new PointF(getW(),getH());
    }

    @Override
    public float getW() {
        return this.mWidth;
    }

    @Override
    public float getH() {
        return this.mHeight;
    }

    @Override
    public VisualElement getParent() {
        return this.mParent;
    }

    @Override
    public void setParent(VisualElement newParent) {
        this.mParent = newParent;
    }

    @Override
    public int getNumChildren() {
        return this.mChildrenList.size();
    }

    @Override
    public VisualElement getChildAt(int index) {
        if (index < 0 || index >= this.mChildrenList.size()){
            return null;
        }
        return this.mChildrenList.get(index);
    }

    @Override
    public int findChild(VisualElement child) {
        if (child == null){
            return -1;
        }
        return this.mChildrenList.indexOf(child);
    }

    @Override
    public void addChild(VisualElement child) {
        //TODO Don't add null children
        if (child != null) {

            // First remove the child from its existing parent
            if (child.getParent() != null){
                child.getParent().removeChild(child);
            }
            this.mChildrenList.add(child);
            child.setParent(this);
        }
    }

    @Override
    public void removeChildAt(int index) {
        if (index > -1 && index < this.mChildrenList.size()) {
            this.mChildrenList.get(index).setParent(null);
            this.mChildrenList.remove(index);
        }
    }

    @Override
    public void removeChild(VisualElement child) {
        if (this.mChildrenList.contains(child)) {
            child.setParent(null);
            this.mChildrenList.remove(child);
        }
    }

    @Override
    public void moveChildFirst(VisualElement child) {
        //TODO To move child to first, we can remove it and the re-insert it to front
        if(this.mChildrenList.contains(child)){
            this.mChildrenList.remove(child);
            this.mChildrenList.add(0,child);
        }
    }

    @Override
    public void moveChildLast(VisualElement child) {
        if(this.mChildrenList.contains(child)){
            this.mChildrenList.remove(child);
            this.mChildrenList.add(child);
        }
    }

    @Override
    public void moveChildEarlier(VisualElement child) {
        if (this.mChildrenList.contains(child)){
            int childStartingIndex = this.mChildrenList.indexOf(child);
            //TODO if the index of child is not 0, move it forward
            if (childStartingIndex > 0){
                this.mChildrenList.remove(child);
                this.mChildrenList.add(childStartingIndex-1,child);
            }
        }
    }

    @Override
    public void moveChildLater(VisualElement child) {
        if (this.mChildrenList.contains(child)){
            int childStartingIndex = this.mChildrenList.indexOf(child);
            int childListSize = this.mChildrenList.size();
            if (childStartingIndex < childListSize - 1){
                this.mChildrenList.remove(child);
                this.mChildrenList.add(childStartingIndex+1,child);
            }
        }
    }

    @Override
    public void doLayout() {
        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).doLayout();
            }
        }
    }

    @Override
    public void draw(Canvas onCanvas) {
        onCanvas.save();
        onCanvas.clipRect(this.mPosX,this.mPosY,this.mPosX+this.mWidth,this.mPosY+this.mHeight);  //TODO 裁剪
        onCanvas.translate(this.mPosX,this.mPosY);      //TODO 移动

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).draw(onCanvas);
            }
        }

        onCanvas.restore();
    }

    public BaseVisualElement() {
        // do default initialization at an odd size so its easy to see when
        // the size is never set up.
        this(0,0);
    }


    public BaseVisualElement(float xLoc, float yLoc) {
        // do default initialization at an odd size so its easy to see when
        // the size is never set up.
        this(xLoc,yLoc,13.7f, 17.9f);
    }

    //TODO constructor
    public BaseVisualElement(float xLoc, float yLoc, float width, float height) {
        setPosition(xLoc,yLoc);
        setSize(width,height);
    }
}
