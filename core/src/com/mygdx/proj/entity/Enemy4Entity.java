package com.mygdx.proj.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy4Entity extends EnemyEntity{
    public Enemy4Entity(float x, float y, Animation<TextureRegion> animation) {
        super(x + 2, y + 2, animation, 16, 16);
    }
}
