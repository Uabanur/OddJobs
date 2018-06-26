package uabanur.spaceInvader.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uabanur.spaceInvader.Display;
import uabanur.spaceInvader.files.FileIO;

public class MenuState extends State {
	
	private long oldTime1, oldTime2, oldTime3, oldTimeSave, oldTimeLoad;
	 public MenuState(){
		 
	 }
	
	@Override
	public void tick() {

		GameState.entityManager.player.tick();
		
		if(Display.keyManager.enter)
			State.setState(Display.gameState);
		
		if(Display.keyManager.s && oldTimeSave <= System.currentTimeMillis()){
				oldTimeSave = System.currentTimeMillis() + 500;
			FileIO.setOutput();
		}
		
		if(Display.keyManager.l && oldTimeLoad <= System.currentTimeMillis()){
			oldTimeLoad = System.currentTimeMillis() + 500;
			FileIO.getInput();
		}
		
		
		//Gold Value
		if(Display.keyManager.one && GameState.entityManager.player.gold >= 1000 && 
				oldTime1 <= System.currentTimeMillis()){
			oldTime1 = System.currentTimeMillis() + 200;
			GameState.purchase[0] = true;
			GameState.entityManager.player.gold -= 1000;
		}
		
		//Magnet Range
		if(Display.keyManager.two && GameState.entityManager.player.gold >= 2000 && 
				oldTime2 <= System.currentTimeMillis()){
			oldTime2 = System.currentTimeMillis() + 200;
			GameState.purchase[1] = true;
			GameState.entityManager.player.gold -= 2000;
		}
		
		//Damage
		if(Display.keyManager.three && GameState.entityManager.player.gold >= 5000 &&
				oldTime3 <= System.currentTimeMillis()){
			oldTime3 = System.currentTimeMillis() + 200;
			GameState.purchase[2] = true;
			GameState.entityManager.player.gold -= 5000;
		}
		
		//Double bullet
		if(Display.keyManager.four && GameState.entityManager.player.gold >= 20000 && !GameState.purchase[3]){
			GameState.purchase[3] = true;
			GameState.entityManager.player.gold -= 20000;
		}
		
		//Diagonal Lasers
		if(Display.keyManager.five && GameState.entityManager.player.gold >= 50000 && !GameState.purchase[4]){
			GameState.purchase[4] = true;
			GameState.entityManager.player.gold -= 50000;
		}
		
		//Ray gun
		if(Display.keyManager.six && GameState.entityManager.player.gold >= 100000 && !GameState.purchase[5]){
			GameState.purchase[5] = true;
			GameState.entityManager.player.gold -= 100000;
		}

		
	}

	@Override
	public void render(Graphics g) {
		screenText(g);
		
	}
	
	
	
	private void screenText(Graphics g){
		
		g.setColor(Color.BLACK);
		g.drawString("Fps: " + Display.fpsCounter, Display.width - 100, 20);
		
		g.drawString("exp: " + GameState.entityManager.player.exp + "/" + GameState.entityManager.player.level*20, Display.width - 100, Display.height - 10);
		g.drawString("gold: " + GameState.entityManager.player.gold, Display.width - 100, Display.height - 30);
		g.drawString("Level: " + GameState.entityManager.player.level, Display.width - 100, Display.height - 50);
		g.drawString("Deaths: " + GameState.entityManager.player.deaths, 15, Display.height - 70);
		g.drawString("Damage: " + GameState.entityManager.player.damage, 15, Display.height - 50);
		g.drawString("Health: " + GameState.entityManager.player.health, 7, Display.height - 30);
		
		g.setFont(new Font("Verdana", 0, 15));
		g.drawString("Press S to save game", 20, 20);
		g.drawString("Press L to load saved game", 20, 40);

		g.setColor(Color.cyan);
		g.setFont(new Font("Verdana", 1, 30));
		g.drawString("MENU", 250, 150);
		g.drawString("ENTER TO CONTINUE", 125, 500);
		g.setFont(new Font("Verdana", 3, 20));
		g.drawString("Items for purchase:", 180, 220);
		
		
		g.setFont(new Font("Verdana", 1, 15));
		g.drawString("Press 1", 130, 260);
		g.drawString("Press 2", 270, 260);
		g.drawString("Press 3", 400, 260);
		g.drawString("Press 4", 130, 370);
		g.drawString("Press 5", 270, 370);
		g.drawString("Press 6", 400, 370);

		
		
		g.setColor(Color.black);
		g.drawString("GoldValue+", 125, 285);
		g.drawString("Magnet+", 270, 285);
		g.drawString("Damage+", 390, 285);
		g.drawString("Double Bullet", 110, 395);
		g.drawString("Diagonal lasers", 240, 395);
		g.drawString("RayGun", 400, 395);

		
		
		
		g.setColor(Color.YELLOW.darker());
		if(GameState.purchase[0] || oldTime1 >= System.currentTimeMillis())
			g.drawString("PURCHASED", 120, 310);
		else
			g.drawString("1.000 GOLD",120,310);
		
		if(GameState.purchase[1] || oldTime2 >= System.currentTimeMillis())
			g.drawString("PURCHASED", 250, 310);
		else 
			g.drawString("2.000 GOLD", 250, 310);
			
		if(GameState.purchase[2] || oldTime3 >= System.currentTimeMillis())
			g.drawString("PURCHASED", 380, 310);
		else
			g.drawString("5.000 GOLD", 380, 310);
		
		if(GameState.purchase[3])
			g.drawString("PURCHASED", 120, 420);
		else
			g.drawString("20.000 GOLD", 120, 420);
		
		if(GameState.purchase[4])
			g.drawString("PURCHASED", 255, 420);
		else
			g.drawString("50.000 GOLD", 255, 420);
		
		if(GameState.purchase[5])
			g.drawString("PURCHASED", 380, 420);
		else
			g.drawString("100.000 GOLD", 380, 420);
		
		
	}

}
