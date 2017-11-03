package com.mygdx.proj.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RenderComponent implements Component {
    public Animation<Sprite> animation;
    public float timer;
}
