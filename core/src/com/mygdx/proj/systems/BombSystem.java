package com.mygdx.proj.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mygdx.proj.components.InputComponent;
import com.mygdx.proj.components.PositionComponent;
import com.mygdx.proj.entity.BombEntity;
import com.mygdx.proj.util.Mappers;

public class BombSystem extends IteratingSystem {
	public BombSystem() {
		super(Family.all(PositionComponent.class,
				InputComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		PositionComponent position = Mappers.positionMapper.get(entity);
		//if (Mappers.inputMapper.get(entity).bomb)
			//getEngine().addEntity(new BombEntity(position.x, position.y));
	}
}
