package com.mygdx.proj.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy1Entity extends EnemyEntity{
    public Enemy1Entity(float x, float y, Animation<TextureRegion> animation) {
        super(x+1, y+1, animation, 3, 3);
    }
}
