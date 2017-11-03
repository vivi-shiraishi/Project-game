package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.proj.components.*;
import com.mygdx.proj.util.BulletPositionUpdater;
import com.mygdx.proj.util.Mappers;
import com.mygdx.proj.util.Pools;

public class BulletMovementSystem extends IteratingSystem {

    public static final float DELAY = 0.01f;
    static private Rectangle playerHitbox = new Rectangle();


    private Family collisionFamily;
    private ImmutableArray<Entity> collisionEntities;
    private BulletPositionUpdater bulletPositionUpdater = new BulletPositionUpdater(collisionEntities);

    public BulletMovementSystem() {
        super(Family
                .all(PositionComponent.class,
                        HitboxComponent.class,
                        BehaviourComponent.class)
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
        bulletPositionUpdater.collisionEntities = collisionEntities;
    }

    @Override
    public void removedFromEngine(Engine engine) {
        super.removedFromEngine(engine);
        collisionEntities = null;
    }


    static public void playerUpdate(HitboxComponent playerH, PositionComponent playerP){
        playerHitbox.set (playerH.x + playerP.x, playerH.y + playerP.y, playerH.width, playerH.height);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = Mappers.positionMapper.get(entity);
        HitboxComponent hitbox = Mappers.hitboxMapper.get(entity);
        BehaviourComponent behaviour = Mappers.behaviourMapper.get(entity);
        //behaviour.timer -= deltaTime;
        Rectangle bulletHitbox = Pools.rectPool.obtain();
        bulletHitbox.set(
                position.x + hitbox.x,
                position.y + hitbox.y,
                hitbox.width,
                hitbox.height);
            if (behaviour.enemy) {
                switch (behaviour.num) {
                    case 1: break;
                }
            } else {
                switch (behaviour.num) {
                    case 1:
                        bulletPositionUpdater.moveStraight(position, bulletHitbox, playerHitbox, (float)Math.toRadians(135), 1.5f);
                        break;
                    case 2:
                        bulletPositionUpdater.moveStraight(position, bulletHitbox, playerHitbox, (float)Math.toRadians(120), 1.5f);
                        break;
                    case 3:
                        bulletPositionUpdater.moveStraight(position, bulletHitbox, playerHitbox, (float)Math.toRadians(95), 1.5f);
                        break;
                    case 4:
                        bulletPositionUpdater.moveStraight(position, bulletHitbox, playerHitbox, (float)Math.toRadians(85), 1.5f);
                        break;
                    case 5:
                        bulletPositionUpdater.moveStraight(position, bulletHitbox, playerHitbox, (float)Math.toRadians(60), 1.5f);
                        break;
                    case 6:
                        bulletPositionUpdater.moveStraight(position, bulletHitbox, playerHitbox, (float)Math.toRadians(45), 1.5f);
                        break;
                    default:
                        bulletPositionUpdater.moveStraight(position, bulletHitbox, playerHitbox, (float)Math.toRadians(90), 2f);
                }
            }

        Pools.rectPool.free(bulletHitbox);
    }
}
