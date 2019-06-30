package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;

//TODO 将其子元素放置在单个水平行中，子元素垂直居中
//TODO 如果子元素不符合row对象的范围，则将其剪切到右边缘
public class RowLayout extends BaseVisualElement {
    //TODO Constructor
    public RowLayout(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }

    @Override
    public void doLayout(){
        float runningCount = 0;

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){

                if (this.mChildrenList.get(i) == null)
                    continue;

                //TODO 设置为垂直居中
                float childHeight = this.mChildrenList.get(i).getH();
                this.mChildrenList.get(i).setY(this.mHeight/2 - childHeight/2);

                //TODO 紧贴着摆放
                this.mChildrenList.get(i).setX(runningCount);
                runningCount += this.mChildrenList.get(i).getW();

                this.mChildrenList.get(i).doLayout();
            }
        }
    }
}
