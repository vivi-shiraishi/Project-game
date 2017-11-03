package com.mygdx.proj.entity.EnemyEntities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.entity.EnemyEntity;

public class Enemy4Entity extends EnemyEntity {
    public Enemy4Entity(float x, float y, Animation<Sprite> animation, int behaviour) {
        super(x + 2, y + 2, animation, 16, 16, behaviour);
    }
}
