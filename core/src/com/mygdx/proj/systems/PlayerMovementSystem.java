package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.proj.components.HitboxComponent;
import com.mygdx.proj.components.InputComponent;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.util.Mappers;
import com.mygdx.proj.util.Pools;

public class PlayerMovementSystem extends MovementSystem{

    public static final float DELAY = 0.01f;

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = Mappers.positionMapper.get(entity);
        HitboxComponent hitbox = Mappers.hitboxMapper.get(entity);
        InputComponent input = Mappers.inputMapper.get(entity);

        input.timer -= deltaTime;

        Rectangle playerHitbox = Pools.rectPool.obtain();
        playerHitbox.set(
                position.x + hitbox.x,
                position.y + hitbox.y,
                hitbox.width,
                hitbox.height);
        if (input.focus) {
            if (input.timer <= 0f) {
                if (input.up && input.right) {
                    playerPositionUpdater.moveUp(position, playerHitbox, input, true, true);
                    playerPositionUpdater.moveRight(position, playerHitbox, input, true, true);
                } else if (input.up && input.left) {
                    playerPositionUpdater.moveUp(position, playerHitbox, input, true, true);
                    playerPositionUpdater.moveLeft(position, playerHitbox, input, true, true);
                } else if (input.up) {
                    playerPositionUpdater.moveUp(position, playerHitbox, input, false, true);
                } else if (input.down && input.right) {
                    playerPositionUpdater.moveDown(position, playerHitbox, input, true, true);
                    playerPositionUpdater.moveRight(position, playerHitbox, input, true, true);
                } else if (input.down && input.left) {
                    playerPositionUpdater.moveDown(position, playerHitbox, input, true, true);
                    playerPositionUpdater.moveLeft(position, playerHitbox, input, true, true);
                } else if (input.down) {
                    playerPositionUpdater.moveDown(position, playerHitbox, input, false, true);
                } else if (input.right) {
                    playerPositionUpdater.moveRight(position, playerHitbox, input, false, true);
                } else if (input.left) {
                    playerPositionUpdater.moveLeft(position, playerHitbox, input, false, true);
                }

            }
        } else {
            if (input.timer <= 0f) {
                if (input.up && input.right) {
                    playerPositionUpdater.moveUp(position, playerHitbox, input, true, false);
                    playerPositionUpdater.moveRight(position, playerHitbox, input, true, false);
                } else if (input.up && input.left) {
                    playerPositionUpdater.moveUp(position, playerHitbox, input, true, false);
                    playerPositionUpdater.moveLeft(position, playerHitbox, input, true, false);
                } else if (input.up) {
                    playerPositionUpdater.moveUp(position, playerHitbox, input, false, false);
                } else if (input.down && input.right) {
                    playerPositionUpdater.moveDown(position, playerHitbox, input, true, false);
                    playerPositionUpdater.moveRight(position, playerHitbox, input, true, false);
                } else if (input.down && input.left) {
                    playerPositionUpdater.moveDown(position, playerHitbox, input, true, false);
                    playerPositionUpdater.moveLeft(position, playerHitbox, input, true, false);
                } else if (input.down) {
                    playerPositionUpdater.moveDown(position, playerHitbox, input, false, false);
                } else if (input.right) {
                    playerPositionUpdater.moveRight(position, playerHitbox, input, false, false);
                } else if (input.left) {
                    playerPositionUpdater.moveLeft(position, playerHitbox, input, false, false);
                }
            }
        }
        Pools.rectPool.free(playerHitbox);
    }
}
