package com.mygdx.proj.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnemyBossEntity extends EnemyEntity{
    public EnemyBossEntity(float x, float y, Animation<TextureRegion> animation) {
        super(x, y, animation, 64, 64);
    }
}
