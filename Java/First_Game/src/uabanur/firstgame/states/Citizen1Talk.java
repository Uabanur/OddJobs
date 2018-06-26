package uabanur.firstgame.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.ImageLoader;
import uabanur.firstgame.inventory.Inventory;

public class Citizen1Talk extends State {
	
	public static BufferedImage[] talk;
	
	public Citizen1Talk(Handler handler) {
		super(handler);
		
		talk = new BufferedImage[3];
		talk[0] = ImageLoader.loadImage("/textures/Citizen1TalkPart1.png");
		talk[1] = ImageLoader.loadImage("/textures/Citizen1TalkPart2.png");
		talk[2] = ImageLoader.loadImage("/textures/Citizen1TalkPart3.png");
		
	}

	

	private int dialogSeperator = 0;
	
	@Override
	public void tick() {
		
		if(	dialogSeperator == 0 &&
			handler.getMouseManager().isLeftPressed() &&
			handler.getMouseManager().getMouseX() > handler.getGame().getWidth()-170*2 -10 &&
			handler.getMouseManager().getMouseX() < handler.getGame().getWidth()-170 &&
			handler.getMouseManager().getMouseY() > handler.getGame().getHeight()-60){
			dialogSeperator =1;
		}
		
		if(	dialogSeperator == 1 && 
				handler.getMouseManager().isLeftPressed() &&
				handler.getMouseManager().getMouseX() > handler.getGame().getWidth()-170 &&
				handler.getMouseManager().getMouseY() > handler.getGame().getHeight()-60){
			State.setState(handler.getGame().gameState);
			
		}
		if( Inventory.items[1]){
			dialogSeperator = 2;
		}
		
		if(	dialogSeperator == 2 && 
				handler.getMouseManager().isLeftPressed() &&
				handler.getMouseManager().getMouseX() > handler.getGame().getWidth()-170 &&
				handler.getMouseManager().getMouseY() > handler.getGame().getHeight()-60){
			State.setState(handler.getGame().winState);
			
		}
	}

	@Override
	public void render(Graphics g) {
			g.drawImage(talk[dialogSeperator],0,0, 
					handler.getGame().getWidth(),handler.getGame().getHeight(),null);

	}

}
