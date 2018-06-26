package uabanur.firstgame.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.ImageLoader;

public class WinState extends State {
	
	public static BufferedImage winScreen;
	

	public WinState(Handler handler) {
		super(handler);
		winScreen = ImageLoader.loadImage("/textures/WinGame.png");
	}

	@Override
	public void tick() {
		if(handler.getGame().getKeyManager().esc)
			State.setState(handler.getGame().gameState);
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(winScreen, 0,0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
		
	}

}
