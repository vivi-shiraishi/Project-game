package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.mygdx.proj.components.*;

public class BehaviorSystem extends IteratingSystem{
    private Family destructibleFamily;
    private ImmutableArray<Entity> destructibleEntities;

    private Family collisionFamily;
    private ImmutableArray<Entity> collisionEntities;

    public BehaviorSystem() {
        super(Family.all(PositionComponent.class, BehaviourComponent.class).get());
        destructibleFamily = Family.all(
                PositionComponent.class,
                HitboxComponent.class,
                DestructibleComponent.class).get();
        collisionFamily = Family.all(
                PositionComponent.class,
                HitboxComponent.class,
                StaticColliderComponent.class)
                .exclude(DestructibleComponent.class).get();
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        destructibleEntities = engine.getEntitiesFor(destructibleFamily);
        collisionEntities = engine.getEntitiesFor(collisionFamily);
    }

    @Override
    public void removedFromEngine(Engine engine) {
        super.removedFromEngine(engine);
        destructibleEntities = null;
        collisionEntities = null;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        /*for(Entity entity1 : getEntities()){
            entity1.getComponent(BehaviourComponent.class).act();
        }*/
    }
}
