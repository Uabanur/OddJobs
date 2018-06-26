package uabanur.spaceInvader.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage ship, enemy;
	
	public static void init(){
		
		ship = ImageLoader.loadImage("/textures/Ship.png");
		enemy = ImageLoader.loadImage("/textures/Enemy.png");
		
		
		
	}
	

}