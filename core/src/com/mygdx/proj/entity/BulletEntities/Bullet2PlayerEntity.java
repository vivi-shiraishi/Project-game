package com.mygdx.proj.entity.BulletEntities;

import com.mygdx.proj.entity.BulletEntity;
import com.mygdx.proj.entity.PlayerBulletEntity;
import com.mygdx.proj.util.Textures;

public class Bullet2PlayerEntity extends PlayerBulletEntity {
    public Bullet2PlayerEntity(float x, float y, float angle) {
        super(x, y, x+1, y+1, 5, 3, Textures.bullet2PlayerAnimation, angle);
    }
}
