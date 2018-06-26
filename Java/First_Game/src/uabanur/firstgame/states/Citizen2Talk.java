package uabanur.firstgame.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.ImageLoader;
import uabanur.firstgame.inventory.Inventory;

public class Citizen2Talk extends State{

	public static BufferedImage[] talk;
	
	public Citizen2Talk(Handler handler) {
		super(handler);
		
		talk = new BufferedImage[2];
		talk[0] = ImageLoader.loadImage("/textures/Citizen2TalkPart1.png");
		talk[1] = ImageLoader.loadImage("/textures/Citizen2TalkPart2.png");
		
	}
	
	private int dialogSeperator = 0;

	@Override
	public void tick() {
		if(Inventory.items[0]){
			dialogSeperator = 1;
			Inventory.items[1]=true;
			} else {
			dialogSeperator = 0;
			}
		
		if(	handler.getMouseManager().isLeftPressed() &&
			handler.getMouseManager().getMouseX() > handler.getGame().getWidth()-170 &&
			handler.getMouseManager().getMouseY() > handler.getGame().getHeight()-60
				)
				State.setState(handler.getGame().gameState);
		
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(talk[dialogSeperator],0,0, 
				handler.getGame().getWidth(),handler.getGame().getHeight(),null);
		
	}

}
