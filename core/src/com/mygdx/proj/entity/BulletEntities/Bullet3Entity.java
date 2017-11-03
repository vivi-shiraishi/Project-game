package com.mygdx.proj.entity.BulletEntities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.entity.BulletEntity;

public class Bullet3Entity extends BulletEntity {
    public Bullet3Entity(float x, float y, Animation<Sprite> anim, float angle) {
        super(x, y,x+1 ,y+1 ,4 ,4 , true, false, anim, angle);
    }
}
