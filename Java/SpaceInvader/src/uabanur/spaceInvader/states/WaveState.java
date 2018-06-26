package uabanur.spaceInvader.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uabanur.spaceInvader.Display;
import uabanur.spaceInvader.entities.Gold;

public class WaveState extends State {
	
	public static int waveNumber = 1, waveEnemyNumber = 25, waveEnemySpawnTime = 500;
	private long oldTime;
	
	public WaveState(){
		
	}

	@Override
	public void tick() {
		if(waveEnemySpawnTime > 10)
			waveEnemySpawnTime = 500 - waveNumber * 10;
		else 
			waveEnemySpawnTime = 10;
		
		GameState.entityManager.player.tick();
		
		GameState.entityManager.entities.clear();
		
		if(Display.keyManager.p)
			State.setState(Display.menuState);
		
		if(oldTime < System.currentTimeMillis()){
			oldTime = System.currentTimeMillis() + 1000;
		}
			if(oldTime/100 == System.currentTimeMillis()/100){
				GameState.enemyCount = 0;
				GameState.enemySpawned = 0;
				State.setState(Display.gameState);
			}
			
			
		waveEnemyNumber =  waveNumber * 25;
		
		
		for (int i = 0; i < GameState.entityManager.gold.size(); i++) {
			GameState.entityManager.gold.get(i).tick();
			if(GameState.entityManager.gold.get(i).tick >= GameState.entityManager.gold.get(i).lifeTime)
				GameState.entityManager.gold.remove(i);
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		for (Gold e : GameState.entityManager.gold)
			e.render(g);
		
		GameState.entityManager.player.render(g);
		g.setFont(new Font("Verdana", 1, 40));
		g.setColor(Color.green.darker());
		g.drawString("Wave " + waveNumber, 200, 200);
		
	}

}
