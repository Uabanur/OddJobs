package uabanur.spaceInvader.entities;

import java.awt.Color;
import java.awt.Graphics;

import uabanur.spaceInvader.entities.creatures.Enemy;

public class Gold extends Entity {

	public int tick = 0, lifeTime = 300;
	public static int goldValue = 100;
	long lifeStart = System.currentTimeMillis();

	public Gold(float x, float y) {
		super(x, y, 13, 15);
		bounds.x = (int) x;
		bounds.y = (int) y;
		
		
	}

	@Override
	public void tick() {
		
		bounds.x = (int) x;
		bounds.y = (int) y;
		
		width = (int) Math.abs((Math.sin((double) System.currentTimeMillis() / (double) 400) * 13)) +1;
		
		y += Enemy.enemySpeed/2;
		
		tick++;
		

		
	}

	@Override
	public void render(Graphics g) {
		
		if(tick >= lifeTime/3*2)
			g.setColor(Color.yellow.darker());
		else
			g.setColor(Color.yellow.brighter());
		
		g.fillOval((int) x - width/2, (int) y, width, height);

		// g.setColor(Color.blue);
		// g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

	}

}
