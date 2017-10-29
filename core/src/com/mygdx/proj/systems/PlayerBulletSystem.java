package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Entity;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.entity.BulletEntity;
import com.mygdx.proj.entity.PlayerBulletEntity;
import com.mygdx.proj.util.Mappers;

public class PlayerBulletSystem extends BulletSystem{

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = Mappers.positionMapper.get(entity);
        if (Mappers.inputMapper.get(entity).shoot)
            if (Mappers.inputMapper.get(entity).focus) {
                getEngine().addEntity(new PlayerBulletEntity(position.x, position.y, true));
            } else {
                getEngine().addEntity(new PlayerBulletEntity(position.x, position.y, false));
            }
    }
}
