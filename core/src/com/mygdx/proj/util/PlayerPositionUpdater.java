package com.mygdx.proj.util;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.proj.components.InputComponent;
import com.mygdx.proj.components.PositionComponent;

import static com.mygdx.proj.Proj.*;
import static com.mygdx.proj.systems.PlayerMovementSystem.DELAY;

public class PlayerPositionUpdater extends PositionUpdater{
    public PlayerPositionUpdater(ImmutableArray<Entity> collEntities) {
        super(collEntities);
    }

    public void moveUp(PositionComponent position, Rectangle playerHitbox, InputComponent input, boolean biDirect, boolean focus){
        float py;
        if(focus) {
            if (biDirect)
                py = position.y + 0.8f;
            else
                py = position.y + 1.2f;
            playerHitbox.setY(py + 7);
            if (!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.y = py;
                input.timer = DELAY;
            }
        } else {

            if (biDirect)
                py = position.y + 1.4f;
            else
                py = position.y + 2;
            playerHitbox.setY(py + 7);
            if (!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.y = py;
                input.timer = DELAY;
            }
        }
    }
    public void moveDown(PositionComponent position, Rectangle playerHitbox, InputComponent input, boolean biDirect, boolean focus){
        float py;
        if(focus) {
            if (biDirect)
                py = position.y - 0.8f;
            else
                py = position.y - 1.2f;
            playerHitbox.setY(py + 7);
            if(!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.y = py;
                input.timer = DELAY;
            }
        } else {
            if (biDirect)
                py = position.y - 1.4f;
            else
                py = position.y - 2;
            playerHitbox.setY(py + 7);
            if (!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.y = py;
                input.timer = DELAY;
            }
        }
    }
    public void moveLeft(PositionComponent position, Rectangle playerHitbox, InputComponent input, boolean biDirect, boolean focus){
        float px;
        if(focus) {
            if (biDirect)
                px = position.x - 0.8f;
            else
                px = position.x - 1.2f;
            playerHitbox.setX(px + 7);
            if (!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.x = px;
                input.timer = DELAY;
            }
        } else {

            if (biDirect)
                px = position.x - 1.4f;
            else
                px = position.x - 2;
            playerHitbox.setX(px + 7);
            if (!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.x = px;
                input.timer = DELAY;
            }
        }
    }

    public void moveRight(PositionComponent position, Rectangle playerHitbox, InputComponent input, boolean biDirect, boolean focus){
        float px;
        if(focus) {
            if (biDirect)
                px = position.x + 0.8f;
            else
                px = position.x + 1.2f;
            playerHitbox.setX(px + 7);
            if (!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.x = px;
                input.timer = DELAY;
            }
        } else {

            if (biDirect)
                px = position.x + 1.4f;
            else
                px = position.x + 2;
            playerHitbox.setX(px + 7);
            if (!(playerHitbox.overlaps(physicalBorder1)||
                    playerHitbox.overlaps(physicalBorder2)||
                    playerHitbox.overlaps(physicalBorder3)||
                    playerHitbox.overlaps(physicalBorder4))) {
                position.x = px;
                input.timer = DELAY;
            }
        }
    }
}
