package uabanur.firstgame.inventory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.Assets;
import uabanur.firstgame.gfx.ImageLoader;
import uabanur.firstgame.states.State;

public class Inventory {
	
	private Handler handler;
	public static BufferedImage inventoryScreen, backSign;
	public static boolean[] items;

	public Inventory(Handler handler){
		this.handler = handler;
		
	}
	
	public void init() {
		inventoryScreen = ImageLoader.loadImage("/textures/Inventory.png");
		backSign = ImageLoader.loadImage("/textures/BackSign.png");
		
		items = new boolean[] {false, false, false, false, false, false};

	}

	public void tick() {
		backButton();
	}

	public void render(Graphics g) {
		g.drawImage(inventoryScreen,0,0,handler.getWidth(),handler.getHeight(),null);
		g.drawImage(backSign,handler.getWidth()-100,handler.getHeight()-50,100,50,null);
			if(items[0]){
				g.drawImage(Assets.pistol, 145, 110, 50, 50, null);
			}
			if(items[1]){
				g.drawImage(Assets.wallet, 265, 110, 50, 50, null);
			}
			
	}
	
	private void backButton(){
		if(	handler.getKeyManager().esc ||
				handler.getKeyManager().enter ||
				handler.getMouseManager().getMouseX() > handler.getWidth()-100 &&
				handler.getMouseManager().getMouseY() > handler.getHeight()-50 &&
				handler.getMouseManager().isLeftPressed())
				State.setState(handler.getGame().gameState);
	}


	
}
