package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.mygdx.proj.entity.*;
import com.mygdx.proj.util.Textures;

public class SpawnSystem extends EntitySystem{

    static public EnemyEntity enemySpawn(int num, float x, float y){
        switch(num){
            case 1: return new Enemy1Entity(x, y, Textures.enemy1Animation);
            case 2: return new Enemy2Entity(x, y, Textures.enemy2Animation);
            case 3: return new Enemy3Entity(x, y, Textures.enemy3Animation);
            case 4: return new Enemy4Entity(x, y, Textures.enemy4Animation);
            case 0: return new EnemyBossEntity(x, y, Textures.enemyBossAnimation);
        }
        return null;
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
    }

    @Override
    public void removedFromEngine(Engine engine) {
        super.removedFromEngine(engine);
    }
}
