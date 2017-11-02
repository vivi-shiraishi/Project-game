package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mygdx.proj.components.HitboxComponent;
import com.mygdx.proj.components.PositionComponent;

public class StageSystem extends IteratingSystem{
    public StageSystem(Engine world){
        super(Family.all(HitboxComponent.class, PositionComponent.class).get());
        this.world = world;
    }
    static private Engine world;
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

    private static void act(){
        switch(event){
            case 0: if(timer > 2) {
                event++;
                world.addEntity(SpawnSystem.enemySpawn(0, 10, 270));
                world.addEntity(SpawnSystem.enemySpawn(0, 262, 270));
            } return;

        }
    }
}
