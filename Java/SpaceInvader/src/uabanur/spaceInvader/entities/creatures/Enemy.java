package uabanur.spaceInvader.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import uabanur.spaceInvader.Display;
import uabanur.spaceInvader.entities.Entity;
import uabanur.spaceInvader.gfx.Assets;
import uabanur.spaceInvader.states.WaveState;

public class Enemy extends Entity {
	public static int enemySpeed = 2;
	private int chance;
	private float fullHealth;
	public static Random r = new Random();

	public Enemy() {
		super(r.nextFloat() * (Display.width - 70), -100, 0, 0);


		
			health = 10f;
			super.width = 70;
			super.height = 50;
			
			chance = r.nextInt(10);
			
		 if (chance >= 9 && WaveState.waveNumber >= 3) {
			health = 50f;
			super.width = 100;
			super.height = 80;
		}

		health = health * WaveState.waveNumber*WaveState.waveNumber;

		fullHealth = health;
		bounds.width = width;
		bounds.height = height;
	}

	@Override
	public void tick() {
		setBounds();
		y += enemySpeed;

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.enemy, (int) x, (int) y, width, height, null);
		g.setColor(Color.green);
		g.drawRect((int) x, (int) y - 15, width, 10);
		if (health / fullHealth < 0.66) {
			g.setColor(Color.yellow);
			if (health / fullHealth < 0.33)
				g.setColor(Color.red);
		}
		g.fillRect((int) x, (int) y - 15,
				(int) (width * (health / fullHealth)), 10);

		// g.setColor(Color.blue);
		// g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

	}

	private void setBounds() {
		bounds.x = (int) (x);
		bounds.y = (int) (y);
	}

}
