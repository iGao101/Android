package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;

//TODO 将所有子元素放在左上角
public class PileLayout extends BaseVisualElement {
    //TODO Constructor
    public PileLayout(float x, float y, float w, float h){
        this.setPosition(x,y);
        this.setSize(w,h);
    }

    @Override
    public void doLayout(){
        if (!this.mChildrenList.isEmpty()){
            for (int i = 0; i < this.mChildrenList.size(); i++){
                this.mChildrenList.get(i).setPosition(0,0);
                this.mChildrenList.get(i).doLayout();
            }
        }
    }
}
