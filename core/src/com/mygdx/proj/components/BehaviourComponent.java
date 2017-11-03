package com.mygdx.proj.components;

import com.badlogic.ashley.core.Component;
import com.mygdx.proj.systems.BulletMovementSystem;

public class BehaviourComponent implements Component {
    public int num;
    public boolean enemy;
    public float timer;

    public BehaviourComponent(int i, boolean enemy){
        num = i;
        this.enemy = enemy;
    }
}
