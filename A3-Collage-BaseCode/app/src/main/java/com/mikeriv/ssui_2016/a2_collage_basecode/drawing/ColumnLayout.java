package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

//TODO 将其子元素放在单个垂直列中，子元素水平居中。
//TODO 如果子对象不符合列对象的范围，则将他们裁剪到底部边缘
public class ColumnLayout extends BaseVisualElement {
    //TODO Constructor
    public ColumnLayout(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }

    @Override
    public void doLayout(){
        float runningCount = 0;

        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){

                if (this.mChildrenList.get(i) == null) continue;

                //TODO 水平居中
                float childWidth = this.mChildrenList.get(i).getW();
                this.mChildrenList.get(i).setX(this.mWidth/2 - childWidth/2);

                //TODO 自上而下摆放
                this.mChildrenList.get(i).setY(runningCount);
                runningCount += this.mChildrenList.get(i).getH();

                this.mChildrenList.get(i).doLayout();
            }
        }

    }
}
