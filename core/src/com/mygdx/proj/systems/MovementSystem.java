package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.proj.components.HitboxComponent;
import com.mygdx.proj.components.InputComponent;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.components.StaticColliderComponent;
import com.mygdx.proj.util.*;

public class MovementSystem extends IteratingSystem {


    private Family collisionFamily;
    private ImmutableArray<Entity> collisionEntities;

    public MovementSystem() {
        super(Family
                .all(PositionComponent.class,
                        InputComponent.class,
                        HitboxComponent.class)
                .get());
        collisionFamily = Family
                .all(PositionComponent.class,
                        HitboxComponent.class,
                        StaticColliderComponent.class).get();
    }


    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        collisionEntities = getEngine().getEntitiesFor(collisionFamily);
        playerPositionUpdater.collisionEntities = collisionEntities;
        bulletPositionUpdater.collisionEntities = collisionEntities;
    }

    @Override
    public void removedFromEngine(Engine engine) {
        super.removedFromEngine(engine);
        collisionEntities = null;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }

    PlayerPositionUpdater playerPositionUpdater = new PlayerPositionUpdater(collisionEntities);
    BulletPositionUpdater bulletPositionUpdater = new BulletPositionUpdater(collisionEntities);


}