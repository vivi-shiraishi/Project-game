package com.mygdx.proj.entity;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.components.*;


public class PlayerEntity extends Entity implements InputProcessor {

    public static class InputConfiguration {
        private final int up, down, left, right, shoot, bomb, focus;

        public InputConfiguration(int up, int down, int left, int right, int shoot, int bomb, int focus) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.shoot = shoot;
            this.bomb = bomb;
            this.focus = focus;
        }
    }

    private final InputConfiguration config;
    private final InputComponent input;
    public int lives = 5;

    public PlayerEntity(float x, float y, Animation<Sprite> animation, InputConfiguration config) {
        this.config = config;
        RenderComponent render = new RenderComponent();
        render.animation = animation;
        this.add(render);

        PositionComponent position = new PositionComponent();
        position.x = x;
        position.y = y;
        this.add(position);

        HitboxComponent hitbox = new HitboxComponent();
        hitbox.x = 7;
        hitbox.y = 7;
        hitbox.width = 2;
        hitbox.height = 2;
        this.add(hitbox);

        input = new InputComponent();
        this.add(input);

        this.add(new DestructibleComponent());
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == config.up) {
            input.up = true;
        } if (keycode == config.down) {
            input.down = true;
        } if (keycode == config.left) {
            input.left = true;
        } if (keycode == config.right) {
            input.right = true;
        } if (keycode == config.shoot) {
            input.shoot = true;
        } if (keycode == config.bomb) {
            input.bomb = true;
        } if (keycode == config.focus){
            input.focus = true;
        }else {
            return false;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == config.up) {
            input.up = false;
        } if (keycode == config.down) {
            input.down = false;
        } if (keycode == config.left) {
            input.left = false;
        } if (keycode == config.right) {
            input.right = false;
        } if (keycode == config.shoot) {
            input.shoot = false;
        } if (keycode == config.bomb) {
            input.bomb = false;
        } if (keycode == config.focus){
            input.focus = false;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
