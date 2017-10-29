package com.mygdx.proj.util;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.proj.components.HitboxComponent;
import com.mygdx.proj.components.PositionComponent;


public class PositionUpdater {

    public ImmutableArray<Entity> collisionEntities;

    public PositionUpdater(ImmutableArray<Entity> collEntities){
        collisionEntities= collEntities;
    }

    public boolean collides(Rectangle entity) {
        Rectangle collisionRectangle = Pools.rectPool.obtain();
        for (Entity collisionEntity : collisionEntities) {
            PositionComponent colliderPosition = Mappers.positionMapper.get(collisionEntity);
            HitboxComponent colliderHitbox = Mappers.hitboxMapper.get(collisionEntity);
            collisionRectangle.set(
                    colliderPosition.x + colliderHitbox.x,
                    colliderPosition.y + colliderHitbox.y,
                    colliderHitbox.width,
                    colliderHitbox.height);
            if (collisionRectangle.overlaps(entity)) {
                Pools.rectPool.free(collisionRectangle);
                return true;
            }
        }
        Pools.rectPool.free(collisionRectangle);
        return false;
    }

}
