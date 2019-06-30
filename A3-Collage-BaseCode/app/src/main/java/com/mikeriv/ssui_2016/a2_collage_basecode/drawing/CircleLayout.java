package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

//TODO 将子元素放在给定的圆周上
public class CircleLayout extends BaseVisualElement {
    private float mLayoutCenterX;
    private float mLayoutCenterY;
    private float mLayoutRadius;

    //TODO Constructor
    public CircleLayout(float x, float y, float w, float h, float mlayoutCenterX,
                        float mLayoutCenterY, float mLayoutRadius){
        this.setPosition(x,y);
        this.setSize(w,h);
        this.mLayoutCenterX = mlayoutCenterX;
        this.mLayoutCenterY = mLayoutCenterY;
        this.mLayoutRadius = mLayoutRadius;
    }

    @Override
    public void doLayout(){

        if (!this.mChildrenList.isEmpty()){

            //TODO 决定角度
            int numChildren = this.mChildrenList.size();
            double degreesBetweenChildren = 2*Math.PI/numChildren;
            double newX = 0;
            double newY = 0;
            double angle = 0;

            for (int i = 0; i < this.mChildrenList.size(); i++){

                if (this.mChildrenList.get(i) == null) continue;

                // TODO 确定新的坐标
                angle = degreesBetweenChildren * i;
                newX = (int)(this.mLayoutCenterX + this.mLayoutRadius * Math.cos(angle));
                newY = (int)(this.mLayoutCenterY + this.mLayoutRadius * Math.sin(angle));

                float childHeight = this.mChildrenList.get(i).getH();
                float childWidth = this.mChildrenList.get(i).getW();
                float childCenterX = childWidth/2;
                float childCenterY = childHeight/2;

                newX = newX - childCenterX;
                newY = newY - childCenterY;

                this.mChildrenList.get(i).setX((float)newX);
                this.mChildrenList.get(i).setY((float)newY);
                this.mChildrenList.get(i).doLayout();
            }
        }
    }
}
