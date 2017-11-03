package com.mygdx.proj.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerBulletEntity extends BulletEntity{
    public PlayerBulletEntity(float x, float y, float hx, float hy, float w, float h, Animation<Sprite> anim, float angle) {
        super(x,y,hx,hy,w,h,false,true, anim, angle);
    }
}
