package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.GmHelpers.InputHandler;
import com.mygdx.gameworld.GameRenderer;
import com.mygdx.gameworld.GameWorld;

public class GameScreen implements Screen{
	
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime = 0;

	
	/*Constructor*/
	public GameScreen() {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getWidth();
        float gameWidth = 136;
        float gameHeight = screenHeight/(screenWidth/gameWidth);
		
        int midPoint = (int)(gameHeight/2);
		Gdx.app.log("GameScreen","Attached");
		world = new GameWorld(midPoint);
		renderer = new GameRenderer(world,(int)gameHeight,midPoint);
		Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.app.log("GameScreen",(1/delta)+"");
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		Gdx.app.log("GameScreen","Resized");		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameScreen","show called");
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameScreen","hide called");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameScreen","Pause called");		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameScreen","Resume Called");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameScreen","Disposed called");
	}

}
