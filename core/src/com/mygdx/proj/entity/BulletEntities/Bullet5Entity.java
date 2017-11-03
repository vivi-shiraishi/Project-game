package com.mygdx.proj.entity.BulletEntities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.entity.BulletEntity;

public class Bullet5Entity extends BulletEntity {
    public Bullet5Entity(float x, float y, Animation<Sprite> anim, float angle) {
        super(x, y, x+3, y+3, 12, 12, true, false, anim, angle);
    }
}
