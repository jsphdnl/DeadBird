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
import com.mygdx.gameObjects.Grass;
import com.mygdx.gameObjects.Pipe;
import com.mygdx.gameObjects.ScrollHandle;
import com.mygdx.gameObjects.Scrollable;


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
	private ScrollHandle scroller;
	private Grass frontGrass,backGrass;
	private Pipe pipe1,pipe2,pipe3;
	
	
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
        scroller = myWorld.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3(); 
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
	
	   private void drawGrass() {
	        // Draw the grass
	        batcher.draw(grass, frontGrass.getX(), frontGrass.getY(),
	                frontGrass.getWidth(), frontGrass.getHeight());
	        batcher.draw(grass, backGrass.getX(), backGrass.getY(),
	                backGrass.getWidth(), backGrass.getHeight());
	    }

	    private void drawSkulls() {
	        // Temporary code! Sorry about the mess :)
	        // We will fix this when we finish the Pipe class.

	        batcher.draw(skullUp, pipe1.getX() - 1,
	                pipe1.getY() + pipe1.getHeight() - 14, 24, 14);
	        batcher.draw(skullDown, pipe1.getX() - 1,
	                pipe1.getY() + pipe1.getHeight() + 45, 24, 14);

	        batcher.draw(skullUp, pipe2.getX() - 1,
	                pipe2.getY() + pipe2.getHeight() - 14, 24, 14);
	        batcher.draw(skullDown, pipe2.getX() - 1,
	                pipe2.getY() + pipe2.getHeight() + 45, 24, 14);

	        batcher.draw(skullUp, pipe3.getX() - 1,
	                pipe3.getY() + pipe3.getHeight() - 14, 24, 14);
	        batcher.draw(skullDown, pipe3.getX() - 1,
	                pipe3.getY() + pipe3.getHeight() + 45, 24, 14);
	    }

	    private void drawPipes() {
	        // Temporary code! Sorry about the mess :)
	        // We will fix this when we finish the Pipe class.
	        batcher.draw(bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(),
	                pipe1.getHeight());
	        batcher.draw(bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + 45,
	                pipe1.getWidth(), midPoint + 66 - (pipe1.getHeight() + 45));

	        batcher.draw(bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(),
	                pipe2.getHeight());
	        batcher.draw(bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + 45,
	                pipe2.getWidth(), midPoint + 66 - (pipe2.getHeight() + 45));

	        batcher.draw(bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(),
	                pipe3.getHeight());
	        batcher.draw(bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + 45,
	                pipe3.getWidth(), midPoint + 66 - (pipe3.getHeight() + 45));
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
        
       // batcher.enableBlending();
        
        // 1. Draw Grass
        drawGrass();

        // 2. Draw Pipes
        drawPipes();
        batcher.enableBlending();

        // 3. Draw Skulls (requires transparency)
        drawSkulls();
        
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
