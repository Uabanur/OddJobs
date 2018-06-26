package uabanur.spaceInvader.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Shot {
	
	private int shotSpeed = 40, shotSelecter;
	public Rectangle bullet;
	
	public Shot(float x, float y, int shotSelecter){
		
		this.shotSelecter = shotSelecter;
		bullet = new Rectangle(6, 10);
		
		bullet.x = (int) (x + 32);
		bullet.y = (int) y;
		
		
	}
	
	
	public void tick(){
		bullet.y -= shotSpeed;
		
		if(shotSelecter == 2)
			bullet.x -= shotSpeed/4;
			 
		else if(shotSelecter == 3)
			bullet.x += shotSpeed/4;
		
		
	}
	
	public void render(Graphics g){
		if(shotSelecter == 1){
		g.setColor(Color.green.brighter());
		g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
		} else if (shotSelecter == 2 || shotSelecter == 3){
			g.setColor(Color.yellow);
			g.fillOval(bullet.x, bullet.y, bullet.width*3, bullet.height*2);
		}
		
	}

}
