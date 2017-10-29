package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mygdx.proj.components.InputComponent;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.entity.BulletEntity;
import com.mygdx.proj.util.Mappers;

public class BulletSystem extends IteratingSystem{
    public BulletSystem() {
        super(Family.all(PositionComponent.class,
                InputComponent.class).get());
    }


    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
