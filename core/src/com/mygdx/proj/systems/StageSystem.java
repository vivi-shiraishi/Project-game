package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mygdx.proj.components.HitboxComponent;
import com.mygdx.proj.components.PositionComponent;

public class StageSystem extends IteratingSystem{
    public StageSystem(){
        super(Family.all(HitboxComponent.class, PositionComponent.class).get());
    }

    static private float timer = 0;
    static private int event = 0;

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }

    @Override
    public void update(float deltaTime) {
        timer += deltaTime;
        act();
    }

    private void act(){
        switch(event){
            case 0: if(timer > 2) {
                event++;
                getEngine().addEntity(SpawnSystem.enemySpawn(1, 10, 260, 1));
                getEngine().addEntity(SpawnSystem.enemySpawn(1, 262, 260, 1));
            } return;
            case 1: if(timer > 6);

        }
    }
}
