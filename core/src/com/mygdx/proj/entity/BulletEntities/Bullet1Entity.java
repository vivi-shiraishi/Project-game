package com.mygdx.proj.entity.BulletEntities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.proj.entity.BulletEntity;

public class Bullet1Entity extends BulletEntity {
    public Bullet1Entity(float x, float y, Animation<Sprite> anim, float angle) {
        super(x, y,x+1 ,y+1 ,3,4, true, false, anim, angle);
    }
}
