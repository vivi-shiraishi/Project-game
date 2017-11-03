package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Entity;
import com.mygdx.proj.components.BehaviourComponent;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.entity.BulletEntities.Bullet1PlayerEntity;
import com.mygdx.proj.entity.BulletEntities.Bullet2PlayerEntity;
import com.mygdx.proj.entity.BulletEntity;
import com.mygdx.proj.entity.PlayerBulletEntity;
import com.mygdx.proj.util.Mappers;

public class PlayerBulletSystem extends BulletSystem{
    private final float DELAY = 0.5f;
    private final float FDELAY = 0.2f;
    private float time = 0;

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = Mappers.positionMapper.get(entity);
        BulletEntity bulletEntity;
            if (Mappers.inputMapper.get(entity).shoot) {
                if (Mappers.inputMapper.get(entity).focus){
                    if(time <= 0){
                        bulletEntity = SpawnSystem.bulletSpawn(0x02, position.x + 5, position.y + 16, 0);
                        bulletEntity.add(new BehaviourComponent(0, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x02, position.x + 8.5f, position.y + 16, 0);
                        bulletEntity.add(new BehaviourComponent(0, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x02, position.x + 13, position.y + 16, 0);
                        bulletEntity.add(new BehaviourComponent(0, false));
                        getEngine().addEntity(bulletEntity);
                        time = FDELAY;
                    }
                } else
                    if(time <= 0){
                        bulletEntity = SpawnSystem.bulletSpawn(0x01, position.x, position.y + 16, 60);
                        bulletEntity.add(new BehaviourComponent(1, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x01, position.x + 3, position.y + 16, 45);
                        bulletEntity.add(new BehaviourComponent(2, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x01, position.x + 6.5f, position.y + 16, 30);
                        bulletEntity.add(new BehaviourComponent(3, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x01, position.x + 8, position.y + 16, 0);
                        bulletEntity.add(new BehaviourComponent(0, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x01, position.x + 10.5f, position.y + 16, -30);
                        bulletEntity.add(new BehaviourComponent(4, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x01, position.x + 13, position.y + 16, -45);
                        bulletEntity.add(new BehaviourComponent(5, false));
                        getEngine().addEntity(bulletEntity);
                        bulletEntity = SpawnSystem.bulletSpawn(0x01, position.x + 16, position.y + 16, -60);
                        bulletEntity.add(new BehaviourComponent(6, false));
                        getEngine().addEntity(bulletEntity);
                        time = DELAY;
                }

            }
        if(time > 0)
            time -= deltaTime;
    }
}
