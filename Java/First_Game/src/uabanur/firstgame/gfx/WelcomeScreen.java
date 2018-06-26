package uabanur.firstgame.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uabanur.firstgame.Handler;


public class WelcomeScreen {
	
	private Handler handler;
	public static BufferedImage welcomeScreen;
	
	
	public WelcomeScreen(Handler handler){
		this.handler = handler;
	}
	
	public static void init(){
		welcomeScreen = ImageLoader.loadImage("/textures/welcome.png");

	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(welcomeScreen,0,0,handler.getWidth(),handler.getHeight(),null);
//		g.fillRect(handler.getWidth()/2-85, handler.getHeight()/2+40, 170, 110);
	}
}
