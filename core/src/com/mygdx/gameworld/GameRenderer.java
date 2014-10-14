package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.GmHelpers.AssetLoader;
import com.mygdx.gameObjects.Bird;


public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	
	private SpriteBatch batcher;
	
	private int midPoint;
	private int gameHeight;
	
	//Game Objects
	private Bird bird;
	
	//Game Assets
	private TextureRegion bg, grass;
	private Animation birdAnimation;
	private TextureRegion birdUp, birdMid, birdDown;
	private TextureRegion skullUp,skullDown, bar;
	
	
	/*
	 * Bird initializer
	 */
	
	private void initGameObjects(){
		bird = myWorld.getBird();
	}
	
	/*
	 * Asset Initializer
	 */
	private void initGameAssets(){
		bg = AssetLoader.bg;
		grass = AssetLoader.grass;
		birdAnimation = AssetLoader.birdAnimation;
		birdMid = AssetLoader.bird;
		birdDown = AssetLoader.birdUp;
		birdUp = AssetLoader.birdDown;
		skullUp = AssetLoader.skullUp;
		skullDown = AssetLoader.skullDown;
		bar = AssetLoader.bar;
	}
	
	
	public GameRenderer(GameWorld world,int gameHeight,int midPoint){
		myWorld = world;
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 136, gameHeight);
		
		this.gameHeight = gameHeight;
		this.midPoint = midPoint;
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		
		initGameObjects();
		initGameAssets();
	}
	
	public void render(float runTime) {
		Gdx.app.log("GameWorld","render");
		/*
		 * Set Main Background color
		 */
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Gdx.app.log("GameWorld mid::", midPoint+"");

		
		shapeRenderer.begin(ShapeType.Filled);
        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPoint + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPoint + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPoint + 77, 136, 100);
        
        shapeRenderer.end();
		
		/*
		 * SpriteBatch
		 */
        
        batcher.begin();
        
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPoint+23, 136, 43);
        
        batcher.enableBlending();
        
        if (bird.shouldntFlap()){
        	batcher.draw(birdMid, bird.getX(),bird.getY(),bird.getWidth() / 2.0f, 
        			bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
        			1,1,bird.getRotation());
        }
        else{
            batcher.draw(birdAnimation.getKeyFrame(runTime), bird.getX(),
                    bird.getY(), bird.getWidth() / 2.0f,
                    bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
                    1, 1, bird.getRotation());
        }
        batcher.end();
	}

}
