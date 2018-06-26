package uabanur.firstgame.gfx;

import uabanur.firstgame.Handler;
import uabanur.firstgame.entities.Entity;
import uabanur.firstgame.tiles.Tile;

public class GameCamera {
	
			//Values int xOffset, yOffset; is the amount the camera has moved on game map 
		private Handler handler;
		private float xOffset, yOffset;
	
	
		//Constructor
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
		//Checks if the camera has reched the map boundries, if so stops camera
	public void checkBlankSpace(){
		if(xOffset <= 0){
			xOffset = 0;
		}else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		if(yOffset <= 0){
			yOffset = 0;
		}else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT- handler.getHeight();
		}
	}
	
		//Centers on the chosen entity by moving camera (through offsets) to it.
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
		
		//If entity is at map boundary, the camera stops
		checkBlankSpace(); 
		
	}

		//Moves the camera by offsets
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	
	
		//GETTERS AND SETTERS
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
