package com.mygdx.proj.entity.BulletEntities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.entity.BulletEntity;

public class Bullet4Entity extends BulletEntity {
    public Bullet4Entity(float x, float y, Animation<Sprite> anim, float angle) {
        super(x, y,x+2,y+2,6,6, true, false, anim, angle);
    }
}
