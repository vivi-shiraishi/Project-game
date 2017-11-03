package com.mygdx.proj.entity;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.proj.components.DestroyComponent;
import com.mygdx.proj.components.HitboxComponent;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.components.RenderComponent;

public class BulletEntity extends Entity {
    public BulletEntity(float x, float y, float hx, float hy, float width, float height, boolean PDamaging, boolean EDamaging, Animation<Sprite> animation, float angle){
        this.PDamaging = PDamaging;
        this.EDamaging = EDamaging;

        RenderComponent render = new RenderComponent();
        if(angle != 0) {
            for(Sprite frame : animation.getKeyFrames()) {
                frame.setOrigin((x + width) / 2, (y + height / 2));
                frame.rotate(angle);
            }
        }
        render.animation = animation;
        this.add(render);

        PositionComponent position = new PositionComponent();
        position.x = x;
        position.y = y;
        this.add(position);

        HitboxComponent hitbox = new HitboxComponent();
        hitbox.x = hx;
        hitbox.y = hy;
        hitbox.width = width;
        hitbox.height = height;
        this.add(hitbox);
    }
    private boolean PDamaging, EDamaging;
}
