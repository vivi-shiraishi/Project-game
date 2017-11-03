package com.mygdx.proj.entity;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.components.*;

public class EnemyEntity extends Entity {
    public EnemyEntity(float x, float y, Animation<Sprite> animation, float width, float height, int behaviour) {
        RenderComponent render = new RenderComponent();
        render.animation = animation;
        this.add(render);

        PositionComponent position = new PositionComponent();
        position.x = x;
        position.y = y;
        this.add(position);

        HitboxComponent hitbox = new HitboxComponent();
        hitbox.x = 0;
        hitbox.y = 0;
        hitbox.width = width;
        hitbox.height = height;
        this.add(hitbox);

        this.add(new DestructibleComponent());

        BehaviourComponent behaviourComponent = new BehaviourComponent(behaviour, true);
        this.add(behaviourComponent);
    }
}
