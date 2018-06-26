package uabanur.firstgame.states;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.WelcomeScreen;

public class MainMenuState extends State {
	
		private WelcomeScreen welcomeScreen;
		
	public MainMenuState(Handler handler){
		super(handler);
		welcomeScreen = new WelcomeScreen(handler);
		WelcomeScreen.init();
	}	

	@Override
	public void tick() {
	if(	handler.getMouseManager().getMouseX() > handler.getWidth()/2-85 &&
		handler.getMouseManager().getMouseX() < handler.getWidth()/2-85+170 &&
		handler.getMouseManager().getMouseY() > handler.getHeight()/2+40 &&
		handler.getMouseManager().getMouseY() < handler.getHeight()/2+40 + 110 &&
		handler.getMouseManager().isLeftPressed())
		State.setState(handler.getGame().gameState);
	}


	@Override
	public void render(Graphics g) {
		welcomeScreen.render(g);
		
	}

}
