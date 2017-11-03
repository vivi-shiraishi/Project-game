package com.mygdx.proj.entity.EnemyEntities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.entity.EnemyEntity;

public class EnemyBossEntity extends EnemyEntity {
    public EnemyBossEntity(float x, float y, Animation<Sprite> animation, int behaviour) {
        super(x, y, animation, 64, 64, behaviour);
    }
}
