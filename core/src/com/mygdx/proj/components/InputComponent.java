package com.mygdx.proj.components;

import com.badlogic.ashley.core.Component;

public class InputComponent implements Component {
    public boolean left, right, up, down, shoot, bomb, focus;
    public float timer;
}
