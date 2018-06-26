package uabanur.spaceInvader.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	public float x, y, health;
	public int width, height, goldValue;
	protected Rectangle bounds;
	
	public Entity(float x, float y, int width, int height){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
		
	}
	
	
	public abstract void tick();
	
	public abstract  void render(Graphics g);


}
