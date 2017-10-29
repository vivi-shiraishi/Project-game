package com.mygdx.proj;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.proj.components.HitboxComponent;
import com.mygdx.proj.entity.PlayerEntity;
import com.mygdx.proj.systems.*;
import com.mygdx.proj.util.BulletPositionUpdater;
import com.mygdx.proj.util.MapLoader;
import com.mygdx.proj.util.Textures;

public class Proj extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private ShapeRenderer shape;
	private Engine world, render;
	private PlayerEntity playerOne; //playerTwo;
	private OrthographicCamera camera;
	private FitViewport fitViewport;
	private MapLoader mapLoader;
	private BulletPositionUpdater bulletPositionUpdater;
	public static Rectangle
			physicalBorder1,
			physicalBorder2,
			physicalBorder3,
			physicalBorder4,
			despawnBorder1,
			despawnBorder2,
			despawnBorder3,
			despawnBorder4;

	private void loadTextures() {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		Textures.playerOneTexture = new Texture("player.one.png");
		Textures.playerOneRegions = new TextureRegion[2];
		for (int i = 0; i < 2; i++)
			Textures.playerOneRegions[i] =
					new TextureRegion(Textures.playerOneTexture, i * 16, 0, 16, 16);
		Textures.playerOneAnimation =
				new Animation<>(0.4f, Textures.playerOneRegions);

		/*Textures.playerTwoTexture = new Texture("player.two.png");
		Textures.playerTwoRegions = new TextureRegion[2];
		for (int i = 0; i < 2; i++)
			Textures.playerTwoRegions[i] =
					new TextureRegion(Textures.playerTwoTexture, i * 16, 0, 16, 16);
		Textures.playerTwoAnimation =
				new Animation<>(0.4f, Textures.playerTwoRegions);
*/
		Textures.obstacleTexture = new Texture("obstacle.png");
		Textures.obstacleRegion =
				new TextureRegion(Textures.obstacleTexture, 0, 0, 16, 16);
		Textures.obstacleAnimation =
				new Animation<>(1f, Textures.obstacleRegion);


		/*Textures.obstacleTexture = new Texture("Black and White Full (1).png");
		Textures.obstacleRegion = new TextureRegion[4];
		for(int i = 0; i < 4; i++)
			Textures.obstacleRegion[i] = new TextureRegion(Textures.obstacleTexture, (i * 32) + 16, 16, 16, 16);
		Textures.obstacleAnimation =
				new Animation<>(0.4f, Textures.obstacleRegion);
*/
		Textures.enemy1Texture = new Texture("Black and White Full (1).png");
		Textures.enemy1Regions = new TextureRegion[2];
		for(int i = 0; i < 2; i++)
			Textures.enemy1Regions[i] = new TextureRegion(Textures.enemy1Texture, i * 32, 27, 5, 5);
		Textures.enemy1Animation =
				new Animation<>(0.4f, Textures.enemy1Regions);

		Textures.enemy2Texture = new Texture("Black and White Full (1).png");
		Textures.enemy2Regions = new TextureRegion[2];
		for(int i = 0; i < 2; i++)
			Textures.enemy2Regions[i] = new TextureRegion(Textures.enemy2Texture, i * 32, 17, 8, 8);
		Textures.enemy2Animation =
				new Animation<>(0.4f, Textures.enemy2Regions);

		Textures.enemy3Texture = new Texture("Black and White Full (1).png");
		Textures.enemy3Regions = new TextureRegion[2];
		for(int i = 0; i < 2; i++)
			Textures.enemy3Regions[i] = new TextureRegion(Textures.enemy3Texture, i * 32, 2, 12, 12);
		Textures.enemy3Animation =
				new Animation<>(0.4f, Textures.enemy3Regions);

		Textures.enemy4Texture = new Texture("Black and White Full (1).png");
		Textures.enemy4Regions = new TextureRegion[2];
		for(int i = 0; i < 2; i++)
			Textures.enemy4Regions[i] = new TextureRegion(Textures.enemy4Texture, i * 32, 2, 12, 12);
		Textures.enemy4Animation =
				new Animation<>(0.4f, Textures.enemy4Regions);

		Textures.enemy5Texture = new Texture("Black and White Full (1).png");
		Textures.enemy5Regions = new TextureRegion[4];
		for(int i = 0; i < 4; i++)
			Textures.enemy5Regions[i] = new TextureRegion(Textures.enemy5Texture, 16 + (i * 32), 16, 16, 16);
		Textures.enemy5Animation =
				new Animation<>(0.4f, Textures.enemy5Regions);

		Textures.enemyBossTexture = new Texture("Black and White and Red.png");
		Textures.enemyBossRegions = new TextureRegion[4];
		for(int i = 0; i < 4; i++)
			Textures.enemyBossRegions[i] = new TextureRegion(Textures.enemyBossTexture, i * 33, 0, 32, 32);
		Textures.enemyBossAnimation =
				new Animation<>(0.4f, Textures.enemyBossRegions);

		Textures.bombTexture = new Texture("bomb.png");
		Textures.bombRegions = new TextureRegion[2];
		for (int i = 0; i < 2; i++)
			Textures.bombRegions[i] =
					new TextureRegion(Textures.bombTexture, i * 16, 0, 16, 16);
		Textures.bombAnimation =
				new Animation<>(0.2f, Textures.bombRegions);

		Textures.bombCenter =
				new TextureRegion(Textures.bombTexture, 2 * 16, 0, 16, 16);
		Textures.bombUp =
				new TextureRegion(Textures.bombTexture, 3 * 16, 0, 16, 16);
		Textures.bombDown =
				new TextureRegion(Textures.bombTexture, 4 * 16, 0, 16, 16);
		Textures.bombLeft =
				new TextureRegion(Textures.bombTexture, 5 * 16, 0, 16, 16);
		Textures.bombRight =
				new TextureRegion(Textures.bombTexture, 6 * 16, 0, 16, 16);
		Textures.bombVertical =
				new TextureRegion(Textures.bombTexture, 7 * 16, 0, 16, 16);
		Textures.bombHorizontal =
				new TextureRegion(Textures.bombTexture, 8 * 16, 0, 16, 16);
	}

	private boolean restart = false;

	private void initializeWorld() {
		world = new Engine();
		world.addSystem(new PlayerMovementSystem());
		world.addSystem(new BombSystem());
		world.addSystem(new ExplosionSystem());
		world.addSystem(new DestructionSystem());
		world.addEntityListener(new EntityListener() {
			@Override
			public void entityAdded(Entity entity) {
				render.addEntity(entity);
			}

			@Override
			public void entityRemoved(Entity entity) {
				render.removeEntity(entity);
				if (!(world.getEntities().contains(playerOne, true) /*&&
						world.getEntities().contains(playerTwo, true)*/)) {
					if(playerOne.lives <= 0)
						restart = true;
					else{
						playerOne.lives--;
						world.addEntity(playerOne);
						bulletPositionUpdater.getPlayerOne(playerOne);
					}
				}
			}
		});
		render = new Engine();
		render.addSystem(new RenderSystem(batch));

		physicalBorder1 = new Rectangle(-2,0,2,17*16 - 1);
		physicalBorder2 = new Rectangle(-2, 17*16,17*16 - 1,2);
		physicalBorder3 = new Rectangle(17*16,-1,2,17*16 - 1);
		physicalBorder4 = new Rectangle(-2,0,17*16 - 1,2);
		despawnBorder1 = new Rectangle(-4,0,2,17*16 +1);
		despawnBorder2 = new Rectangle(-4, 17*16 + 2,17*16 + 1,2);
		despawnBorder3 = new Rectangle(17*16 + 2,-3,2,17*16 + 1);
		despawnBorder4 = new Rectangle(-4,-4,17*16 + 1,2);

		playerOne = new PlayerEntity(16, 16, Textures.playerOneAnimation,
				new PlayerEntity.InputConfiguration(
						Input.Keys.UP,
						Input.Keys.DOWN,
						Input.Keys.LEFT,
						Input.Keys.RIGHT,
						Input.Keys.Z,
						Input.Keys.X,
						Input.Keys.SHIFT_LEFT
				));
		/*playerTwo = new PlayerEntity(16 * 15, 16 * 15, Textures.playerTwoAnimation,
				new PlayerEntity.InputConfiguration(
						Input.Keys.W,
						Input.Keys.S,
						Input.Keys.A,
						Input.Keys.D,
						Input.Keys.SPACE
				));*/
		world.addEntity(playerOne);
		//world.addEntity(playerTwo);

		//mapLoader.createEntities(world);

		Gdx.input.setInputProcessor(new InputMultiplexer(this, playerOne/*, playerTwo*/));

		camera = new OrthographicCamera();
		fitViewport = new FitViewport(17 * 16, 17 * 16, camera);
		fitViewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		fitViewport.apply();

		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	}

	@Override
	public void create() {
		//mapLoader = new MapLoader();
		//mapLoader.loadMap("map.tmx");
		loadTextures();
		initializeWorld();
	}

	@Override
	public void resize(int width, int height) {
		fitViewport.update(width, height);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (restart) {
			initializeWorld();
			restart = false;
		}

		world.update(Gdx.graphics.getDeltaTime());

		camera.update();
		//mapLoader.render(camera);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		render.update(Gdx.graphics.getDeltaTime());
		batch.end();
	}

	@Override
	public void dispose() {
		Textures.obstacleTexture.dispose();
		Textures.playerOneTexture.dispose();
		mapLoader.dispose();
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case Input.Keys.ESCAPE:
				Gdx.app.exit();
				break;

			case Input.Keys.R:
				initializeWorld();
				break;

			default:
				return false;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
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