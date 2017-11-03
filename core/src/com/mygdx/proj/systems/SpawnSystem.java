package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.mygdx.proj.entity.*;
import com.mygdx.proj.entity.BulletEntities.Bullet1Entity;
import com.mygdx.proj.entity.BulletEntities.Bullet1PlayerEntity;
import com.mygdx.proj.entity.BulletEntities.Bullet2PlayerEntity;
import com.mygdx.proj.entity.EnemyEntities.*;
import com.mygdx.proj.util.Textures;

public class SpawnSystem extends EntitySystem{

    static public EnemyEntity enemySpawn(int num, float x, float y, int behaviour){
        switch(num){
            case 1: return new Enemy1Entity(x, y, Textures.enemy1Animation, behaviour);
            case 2: return new Enemy2Entity(x, y, Textures.enemy2Animation, behaviour);
            case 3: return new Enemy3Entity(x, y, Textures.enemy3Animation, behaviour);
            case 4: return new Enemy4Entity(x, y, Textures.enemy4Animation, behaviour);
            case 0: return new EnemyBossEntity(x, y, Textures.enemyBossAnimation, behaviour);
        }
        return null;
    }

    static public BulletEntity bulletSpawn(int num, float x, float y, float angle){
        switch(num){
            case 11: return new Bullet1Entity(x, y, Textures.bullet1RedAnimation, angle);
            case 12: return new Bullet1Entity(x, y, Textures.bullet1BlueAnimation, angle);
            case 13: return new Bullet1Entity(x, y, Textures.bullet1GreenAnimation, angle);
            case 14: return new Bullet1Entity(x, y, Textures.bullet1PurpleAnimation, angle);
            case 21: return new Bullet1Entity(x, y, Textures.bullet2RedAnimation, angle);
            case 22: return new Bullet1Entity(x, y, Textures.bullet2BlueAnimation, angle);
            case 23: return new Bullet1Entity(x, y, Textures.bullet2GreenAnimation, angle);
            case 24: return new Bullet1Entity(x, y, Textures.bullet2PurpleAnimation, angle);
            case 31: return new Bullet1Entity(x, y, Textures.bullet3RedAnimation, angle);
            case 32: return new Bullet1Entity(x, y, Textures.bullet3BlueAnimation, angle);
            case 33: return new Bullet1Entity(x, y, Textures.bullet3GreenAnimation, angle);
            case 34: return new Bullet1Entity(x, y, Textures.bullet3PurpleAnimation, angle);
            case 41: return new Bullet1Entity(x, y, Textures.bullet4RedAnimation, angle);
            case 42: return new Bullet1Entity(x, y, Textures.bullet4BlueAnimation, angle);
            case 43: return new Bullet1Entity(x, y, Textures.bullet4GreenAnimation, angle);
            case 44: return new Bullet1Entity(x, y, Textures.bullet4PurpleAnimation, angle);
            case 0x01: return new Bullet1PlayerEntity(x, y, angle);
            case 0x02: return new Bullet2PlayerEntity(x, y, angle);
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
