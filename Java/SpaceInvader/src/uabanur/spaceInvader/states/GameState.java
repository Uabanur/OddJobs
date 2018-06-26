package uabanur.spaceInvader.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uabanur.spaceInvader.Display;
import uabanur.spaceInvader.entities.EntityManager;
import uabanur.spaceInvader.entities.Gold;
import uabanur.spaceInvader.gfx.Assets;

public class GameState extends State {
	
	public static int score, enemyCount, enemySpawned;
	public static boolean[] purchase;
	public GameState(){
		
		purchase = new boolean[10];
		Assets.init();
	}
	
	public static EntityManager entityManager = new EntityManager();

	@Override
	public void tick() {
		if(enemyCount >= WaveState.waveEnemyNumber){
			WaveState.waveNumber++;
			Gold.goldValue += 10;
			State.setState(Display.waveState);
		}
			
		if(Display.keyManager.p)
			State.setState(Display.menuState);
		
		
		entityManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		entityManager.render(g);
		
		g.setFont(new Font("Verdana", 0, 12));
		
		g.setColor(Color.white);
		g.drawString("score: " + score, 10, Display.height - 10);
		
		g.setColor(Color.BLACK);
		g.drawString("Fps: " + Display.fpsCounter, Display.width - 100, 20);
		g.drawString("Enemy count:", 10, 20);
		g.drawString(GameState.enemyCount + "/" + WaveState.waveEnemyNumber, 10, 35);
		
		g.drawString("exp: " + entityManager.player.exp + "/" + entityManager.player.level*20, Display.width - 100, Display.height - 10);
		g.drawString("gold: " + entityManager.player.gold, Display.width - 100, Display.height - 30);
		g.drawString("Level: " + entityManager.player.level, Display.width - 100, Display.height - 50);
		
	}
	
	
	
}
