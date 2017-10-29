package com.mygdx.proj.util;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.entity.BulletEntity;
import com.mygdx.proj.entity.PlayerEntity;
import com.mygdx.proj.systems.DestructionSystem;

import java.lang.Math;

import static com.mygdx.proj.Proj.*;
import static com.mygdx.proj.systems.BulletMovementSystem.DELAY;

public class BulletPositionUpdater extends PositionUpdater{
    public BulletPositionUpdater(ImmutableArray<Entity> collEntities) {
        super(collEntities);
    }

    public BulletPositionUpdater(ImmutableArray<Entity> collEntities, BulletEntity bulletEntity) {
        super(collEntities);
        bullet = bulletEntity;
    }

    private float py, px;
    private int bounces = 0;
    private DestructionSystem destructionSystem = new DestructionSystem();
    private static PlayerEntity playerOne;
    private BulletEntity bullet;

    public void moveBullet(PositionComponent position, Rectangle bulletHitbox, Rectangle playerHitbox , float angle, float dist){
        py = position.y + (float)(Math.sin(angle) * dist);
        px = position.x + (float)(Math.cos(angle) * dist);
        bulletHitbox.setY(py);
        bulletHitbox.setX(px);

    }

    public void moveStraight(PositionComponent position, Rectangle bulletHitbox, Rectangle playerHitbox , float angle, float dist){
        moveBullet(position, bulletHitbox, playerHitbox, angle, dist);
        if(collides(bulletHitbox)) {
            if (bulletHitbox.overlaps(playerHitbox)) {
                destructionSystem.getEngine().removeEntity(playerOne);
            } else if (
                        bulletHitbox.overlaps(despawnBorder1) ||
                        bulletHitbox.overlaps(despawnBorder2) ||
                        bulletHitbox.overlaps(despawnBorder3) ||
                        bulletHitbox.overlaps(despawnBorder4)) {
                destructionSystem.getEngine().removeEntity(bullet);
                return;
            }
        }
        position.y = py;
        position.x = px;
        //Delay
    }

    public void moveCurve (PositionComponent position, Rectangle bulletHitbox, Rectangle playerHitbox , float curveAngle, float newAngle, float dist){
        //rotate texture
        moveStraight(position, bulletHitbox, playerHitbox, newAngle, dist);
    }

    public void moveStraightBounceStraight(PositionComponent position, Rectangle bulletHitbox, Rectangle playerHitbox , float angle, float dist, int maxBounces){
        float bouncingAngle = angle;
        moveBullet(position, bulletHitbox, playerHitbox, angle, dist);
        if(collides(bulletHitbox)) {
            if (bulletHitbox.overlaps(playerHitbox)) {
                destructionSystem.getEngine().removeEntity(playerOne);
            } else if (bounces < maxBounces)
                if(
                        bulletHitbox.overlaps(physicalBorder1)||
                        bulletHitbox.overlaps(physicalBorder2)||
                        bulletHitbox.overlaps(physicalBorder3)||
                        bulletHitbox.overlaps(physicalBorder4)
                        ) {
                bouncingAngle = findBounce(bulletHitbox, angle);
                //Rotate texture
                moveStraightBounceStraight(position, bulletHitbox, playerHitbox, bouncingAngle, dist, maxBounces);
                bounces++;
                }
            else if(
                        bulletHitbox.overlaps(despawnBorder1) ||
                        bulletHitbox.overlaps(despawnBorder2) ||
                        bulletHitbox.overlaps(despawnBorder3) ||
                        bulletHitbox.overlaps(despawnBorder4)
                        ) {
                destructionSystem.getEngine().removeEntity(bullet);
                return;
            }
        }
        else {
                moveStraight(position, bulletHitbox, playerHitbox, angle, dist);
                bounces = 0;
        }
    }

    public void moveStraightBounceCurve(PositionComponent position, Rectangle bulletHitbox, Rectangle playerHitbox , float curveAngle, float bounceAngle, float dist, int maxBounces) {
        float bouncingAngle = bounceAngle;
        moveBullet(position, bulletHitbox, playerHitbox, bounceAngle, dist);
        if (collides(bulletHitbox)) {
            if (bulletHitbox.overlaps(playerHitbox)) {
                destructionSystem.getEngine().removeEntity(playerOne);
            } else if (
                    bulletHitbox.overlaps(physicalBorder1) ||
                            bulletHitbox.overlaps(physicalBorder2) ||
                            bulletHitbox.overlaps(physicalBorder3) ||
                            bulletHitbox.overlaps(physicalBorder4)
                    ) {
                if (bounces < maxBounces) {
                    bouncingAngle = findBounce(bulletHitbox, bounceAngle);
                    //Rotate texture
                    moveStraightBounceCurve(position, bulletHitbox, playerHitbox, curveAngle, bouncingAngle, dist, maxBounces);
                    bounces++;
                    return;
                } else {
                    moveCurve(position, bulletHitbox, playerHitbox, curveAngle, bouncingAngle, dist);
                    bounces = 0;
                    return;
                }
            } else if(
                    bulletHitbox.overlaps(despawnBorder1) ||
                            bulletHitbox.overlaps(despawnBorder2) ||
                            bulletHitbox.overlaps(despawnBorder3) ||
                            bulletHitbox.overlaps(despawnBorder4)
                    ) {
                destructionSystem.getEngine().removeEntity(bullet);
                return;
            }
        }
        position.y = py;
        position.x = px;
        //Delay
    }

    public void moveCurveBounceStraight(PositionComponent position, Rectangle bulletHitbox, Rectangle playerHitbox , float angle, float newAngle, float dist, int maxBounces){
        //rotate bullet
        moveStraightBounceStraight(position, bulletHitbox, playerHitbox, angle, dist, maxBounces);
    }

    public void moveCurveBounceCurve(PositionComponent position, Rectangle bulletHitbox, Rectangle playerHitbox , float angle, float newAngle, float bounceAngle, float dist, int maxBounces){
       //rotate bullet
        moveStraightBounceCurve(position, bulletHitbox, playerHitbox, angle, bounceAngle, dist, maxBounces);
    }

    private float findBounce(Rectangle bulletHitbox, float angle){
        if(bulletHitbox.overlaps(physicalBorder1))
            return bounceAngle(angle, physicalBorder1);
        else if(bulletHitbox.overlaps(physicalBorder2))
            return bounceAngle(angle, physicalBorder2);
        else if(bulletHitbox.overlaps(physicalBorder3))
            return bounceAngle(angle, physicalBorder3);
        else if(bulletHitbox.overlaps(physicalBorder4))
            return bounceAngle(angle, physicalBorder4);
        return angle;
    }

    private float bounceAngle(float angle, Rectangle collider){
        if(collider == physicalBorder1 || collider == physicalBorder3){
            return 360 - angle;
        } else if(collider == physicalBorder2 || collider == physicalBorder4) {
            return 180 - angle;
        }
        return angle;
    }

    public void getPlayerOne(PlayerEntity player){
        playerOne = player;
    }
}
