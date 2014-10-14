package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.mygdx.gameObjects.Bird;

public class GameWorld {
	
	private Bird bird;
	
	public GameWorld(int midPoint){
		bird = new Bird(33,midPoint-5,17,12);
	}
	
	public void update(float delta){
		Gdx.app.log("GameWorld", "Update");
			bird.update(delta);
	}

	public Bird getBird() {
		return bird;
	}	
}
