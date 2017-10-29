package com.mygdx.proj.entity;


import com.badlogic.ashley.core.Entity;
import com.mygdx.proj.components.DestroyComponent;

public class BulletEntity extends Entity {
    public BulletEntity(float x, float y, float width, float height, boolean PDamaging, boolean EDamaging){
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = height;
        this.PDamaging = PDamaging;
        this.EDamaging = EDamaging;
    }

    private float x, y, width, heigth;
    private boolean PDamaging, EDamaging;
}
