package uabanur.spaceInvader.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import uabanur.spaceInvader.Display;
import uabanur.spaceInvader.entities.creatures.Enemy;
import uabanur.spaceInvader.entities.creatures.Player;
import uabanur.spaceInvader.states.GameState;
import uabanur.spaceInvader.states.WaveState;

public class EntityManager {

	public ArrayList<Entity> entities;
	public ArrayList<Gold> gold;
	private long oldEnemySpawnTime;

	public EntityManager() {

		entities = new ArrayList<Entity>();
		gold = new ArrayList<Gold>();

	}

	public Player player = new Player(Display.width / 2 - 70 / 2,
			Display.height / 3 * 2, 70, 70);

	public int enemyCounter = 5;

	@SuppressWarnings("static-access")
	public void tick() {
		player.tick();
		


		for (int i = 0; i < gold.size(); i++) {
			gold.get(i).tick();
			if(gold.get(i).lifeStart - System.currentTimeMillis()>= gold.get(i).lifeTime)
				gold.remove(i);
		}

		for (int j = 0; j < entities.size(); j++) {
			for (int i = 0; i < player.shooting.size(); i++) {
				if (player.shooting.get(i).bullet.intersects(entities.get(j).bounds)) {
					entities.get(j).health -= player.damage;
					
					if (!GameState.purchase[5])
						player.shooting.remove(i);
				}

			}

			if (player.bounds.intersects(entities.get(j).bounds)) {
				player.health--;
				entities.get(j).health--;
			}

			if (entities.get(j).health <= 0) {
				gold.add(new Gold(entities.get(j).x + entities.get(j).width / 2, entities.get(j).y + entities.get(j).height / 2));
				entities.remove(j);
				GameState.enemyCount++;
				GameState.score += 10;
				player.exp++;

			}
		}


		for (int i = 0; i < gold.size(); i++) {
			if (player.bounds.intersects(gold.get(i).bounds)) {
				if(Math.random()*10 >= 8)
					player.gold += 5*(Math.random()*gold.get(i).goldValue-50) + 50;
				else 
					player.gold += (Math.random()*gold.get(i).goldValue-50) + 50;
				
				gold.remove(i);
			}
		}

		if (GameState.score >= 200)
			enemyCounter = GameState.score / 40;
		;

		if (entities.size() <= enemyCounter % 30 && GameState.enemySpawned < WaveState.waveEnemyNumber && 
				(oldEnemySpawnTime <= System.currentTimeMillis() || entities.size() <= 2)){
			oldEnemySpawnTime = System.currentTimeMillis() + WaveState.waveEnemySpawnTime;
			entities.add(new Enemy());
			GameState.enemySpawned++;
		}

		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).y >= Display.height){
				GameState.enemyCount++;
				player.health -= entities.get(i).health;
				entities.remove(i);
			}
		}

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}

	}

	public void render(Graphics g) {
		player.render(g);

		for (Entity e : entities)
			e.render(g);

		for (Gold e : gold)
			e.render(g);
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void removeEntity(Entity e) {
		entities.remove(e);
	}

	public void removeEntity(int i) {
		entities.remove(i);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

}
