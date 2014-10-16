package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.mygdx.gameObjects.Bird;
import com.mygdx.gameObjects.ScrollHandle;

public class GameWorld {
	
	private Bird bird;
	private ScrollHandle scroller;
	
	public ScrollHandle getScroller() {
		return scroller;
	}

	public void setScroller(ScrollHandle scroller) {
		this.scroller = scroller;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	public GameWorld(int midPoint){
		bird = new Bird(33,midPoint-5,17,12);
		scroller = new ScrollHandle(midPoint + 66);
	}
	
	public void update(float delta){
		Gdx.app.log("GameWorld", "Update");
			bird.update(delta);
			scroller.update(delta);
	}

	public Bird getBird() {
		return bird;
	}	
}
