package com.mygdx.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Bird {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	
	private float rotation;
	private int width;
	private int height;
	
	
	public Bird(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x,y);
		velocity = new Vector2(0,0);
		acceleration = new Vector2(0,20);
	}
	
	public void onClick(){
		velocity.y = -20;
	}
	
	public void update(float delta){
		velocity.add(acceleration.cpy().scl(delta));
		
		if(velocity.y > 200){
			velocity.y = 200;
		}
		position.add(velocity.cpy().scl(delta));
		
	
		if (position.y > 150){
			position.y = 0;
			velocity.y= 0;
		}
		if (position.x > 137){
			position.x = 0;
		}
		
		Gdx.app.log("Testing velocity Y::", velocity.y+"");
	    if(velocity.y < 0){
			Gdx.app.log("Testing","Hello");

	    	rotation-= 600*delta;
	    	  if (rotation<-20){
	    		  rotation = -20;
	    	  }
	    }
		
	    if(isFalling()){
	    	rotation =+ 480*delta;
	    	if (rotation >90)
	    		rotation = 90;
	    }
	}

	public boolean isFalling(){
		return velocity.y >0;
	}
	
	public boolean shouldntFlap(){
		return velocity.y > 0;
	}

	public Vector2 getPosition() {
		return position;
	}


	public void setPosition(Vector2 position) {
		this.position = position;
	}


	public Vector2 getVelocity() {
		return velocity;
	}


	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}


	public Vector2 getAcceleration() {
		return acceleration;
	}


	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}


	public float getRotation() {
		return rotation;
	}


	public void setRotation(float rotation) {
		this.rotation = rotation;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	public float getX(){
		return position.x;
	}
	
	public float getY(){
		return position.y;
	}
	
}
