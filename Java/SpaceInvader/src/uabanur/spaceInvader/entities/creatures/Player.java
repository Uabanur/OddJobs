package uabanur.spaceInvader.entities.creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import uabanur.spaceInvader.Display;
import uabanur.spaceInvader.entities.Entity;
import uabanur.spaceInvader.entities.Gold;
import uabanur.spaceInvader.gfx.Assets;
import uabanur.spaceInvader.gfx.Shot;
import uabanur.spaceInvader.states.GameState;
import uabanur.spaceInvader.states.State;

public class Player extends Entity {

	public int speed = 10, damage = 5, exp = 0, level = 1, gold = 0,
			goldCollectDistance = 50, goldCollectSpeed = 2, deaths = 0;

	public float fullHealth;
	private long oldTimeLevel;
	public ArrayList<Shot> shooting;

	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);

		shooting = new ArrayList<Shot>();

		health = 100;
		fullHealth = health;

		bounds.width = 30;
		bounds.height = 35;
		
	}


	@Override
	public void tick() {

		getInput();
		setBounds();
		shotNr();
		goldCollect();
		increseGoldValuePurchase();


		if (health <= 0) {
			reset();
			State.setState(Display.menuState);
			deaths++;
		}

		if (GameState.purchase[2]) {
			damage += 5;
			GameState.purchase[2] = false;
		}
		

		if (exp >= level * 20) {
			damage++;
			level++;
			exp = 0;
			oldTimeLevel = System.currentTimeMillis() + 800;
			health = fullHealth;
		}

		for (int i = 0; i < shooting.size(); i++) {
			shooting.get(i).tick();
			if (shooting.get(i).bullet.y < -100)
				shooting.remove(i);
		}

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.ship, (int) x, (int) y, width, height, null);
		g.setColor(Color.blue);
		// g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

		for (Shot s : shooting)
			s.render(g);

		g.setColor(Color.green);
		g.drawRect((int) x, (int) y + 15 + height, width, 10);
		if (health / fullHealth < 0.66) {
			g.setColor(Color.yellow);
			if (health / fullHealth < 0.33)
				g.setColor(Color.red);
		}
		g.fillRect((int) x, (int) y + 15 + height,
				(int) (width * (health / fullHealth)), 10);
		
		if(oldTimeLevel >= System.currentTimeMillis()){
			g.setColor(Color.red);
			g.setFont(new Font("Verdana", 1, 50));
			g.drawString("LEVEL UP", 160, 280);
			
		}

	}
	
	public void reset(){
		GameState.score = 0;
		GameState.enemyCount = 0;
		GameState.enemySpawned = 0;
		health = fullHealth;
		GameState.entityManager.entities.clear();
	}
	

	public void goldCollect() {

		if (GameState.purchase[1]) {
			goldCollectDistance += 10;
			goldCollectSpeed++;
			GameState.purchase[1] = false;
		}

		for (Entity g : GameState.entityManager.gold) {
			//Check if coin is within square of sides 2x goldCollectDistance around player
			if (Math.abs((g.x) - (x + width / 2)) <= goldCollectDistance
					&& Math.abs((g.y + g.height / 2) - (y + height / 2)) <= goldCollectDistance) {

				//checking the x-axis
				if ((g.x) - (x + width / 2) < 0) { //player is to the right of coin
					if ((g.x) - (x + width / 2) < -goldCollectSpeed) // check distance to coin
						g.x += goldCollectSpeed; //if coin is further than goldCollectDistance, move that amount
					else
						g.x += -(g.x - (x + width / 2)); // else move the rest of the way (don't overshoot)

				} else if (g.x - (x + width / 2) > 0) { // player is to the left of coin
					if ((g.x) - (x + width / 2) > goldCollectSpeed) // check distance to coin
						g.x -= goldCollectSpeed; //if coin is further than goldCollectDistance, move that amount
					else
						g.x -= g.x - (x + width / 2); // else move the rest of the way (don't overshoot)
				}
				 
				//checking the y-axis
				if (g.y + g.height / 2 - (y + height / 2) < 0) { // player is below coin
					if (g.y + g.height / 2 - (y + height / 2) < -goldCollectSpeed) // check distance to coin
						g.y += goldCollectSpeed; //if coin is further than goldCollectDistance, move that amount
					else
						g.y += -(g.y + g.height / 2 - (y + height / 2)); // else move the rest of the way (don't overshoot)
					
				} else if (g.y + g.height / 2 - (y + height / 2) > 0) { // player is above coin
					if (g.y + g.height / 2 - (y + height / 2) > goldCollectSpeed) // check distance to coin
						g.y -= goldCollectSpeed; //if coin is further than goldCollectDistance, move that amount
					else
						g.y -= g.y + g.height / 2 - (y + height / 2); // else move the rest of the way (don't overshoot)
				}
			}

		}

	}
	
	public void increseGoldValuePurchase(){
		
		
		if(GameState.purchase[0]){
			Gold.goldValue+=10;
			GameState.purchase[0] = false;
		}
		
		
	}

	public void shotNr() {

		if (Display.keyManager.space) {
			if(GameState.purchase[4]){
				
				shooting.add(new Shot(x - 10 - 12, y, 2));
				shooting.add(new Shot(x + 10, y, 3));
			}
				
			
			if (GameState.purchase[3]) {
				shooting.add(new Shot(x - 5, y, 1));
				shooting.add(new Shot(x + 5, y, 1));

			} else {

				shooting.add(new Shot(x, y, 1));
			}
		}

	}

	private void getInput() {
		if (Display.keyManager.up && bounds.y >= 0)
			y -= speed;

		if (Display.keyManager.down
				&& bounds.y <= Display.height - bounds.height)
			y += speed;

		if (Display.keyManager.left && bounds.x >= 0)
			x -= speed;

		if (Display.keyManager.right
				&& bounds.x <= Display.width - bounds.width)
			x += speed;

	}

	private void setBounds() {
		bounds.x = (int) (x + 20);
		bounds.y = (int) (y + 25);
	}

}
