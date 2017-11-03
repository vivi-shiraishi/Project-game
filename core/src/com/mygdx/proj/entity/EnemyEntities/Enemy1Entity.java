package com.mygdx.proj.entity.EnemyEntities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.entity.EnemyEntity;

public class Enemy1Entity extends EnemyEntity {
    public Enemy1Entity(float x, float y, Animation<Sprite> animation, int behaviour) {
        super(x+1, y+1, animation, 3, 3, behaviour);
    }
}
