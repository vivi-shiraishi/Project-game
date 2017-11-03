package com.mygdx.proj.entity.BulletEntities;

import com.mygdx.proj.entity.BulletEntity;
import com.mygdx.proj.entity.PlayerBulletEntity;
import com.mygdx.proj.util.Textures;

public class Bullet1PlayerEntity extends PlayerBulletEntity {
    public Bullet1PlayerEntity(float x, float y, float angle) {
        super(x, y,x+1, y+1, 3, 5, Textures.bullet1PlayerAnimation, angle);
    }
}
