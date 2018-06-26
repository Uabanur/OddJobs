package uabanur.firstgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
		// Create all images or anything else that will be loaded into the game
			// Values, width and height: sizes of the cropped images from SpriteSheet
		private static final int width = 100, height = 100;
		
		public static BufferedImage  dirt, grass, stone, tree, house1, house2, boy, oldMan, player_still, pistol,
										backButton, floor, wood, wallet;
		public static BufferedImage[] player_down, player_up, player_left, player_right;
		
		
		//Has no constructor, only an initializer called by [game].
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet2.png"));
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		player_down[0] = sheet.crop(0, height,width, height);
		player_down[1] = sheet.crop(width, height,width, height);
		
		player_up[0] = sheet.crop(2* width, height,width, height);
		player_up[1] = sheet.crop(3* width, height,width, height);
		
		player_right[0] = sheet.crop(0, 2* height,width, height);
		player_right[1] = sheet.crop(2*width, 2*height,width, height);
		player_right[2] = sheet.crop(width, 2*height,width, height);
		player_right[3] = sheet.crop(2*width, 2*height,width, height);
		
		player_left[0] = sheet.crop(3*width, 2*height,width, height);
		player_left[1] = sheet.crop(1*width, 3*height,width, height);
		player_left[2] = sheet.crop(0, 3*height,width, height);
		player_left[3] = sheet.crop(1*width, 3*height,width, height);
		
		player_still = sheet.crop(2*width, 3*height, width, height);
		
		
	
		dirt = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(2*width, 0, width, height);
		tree = sheet.crop(3*width, 0, width, height);
		house1 = sheet.crop(0, 4*height, width, height-4);
		house2 = sheet.crop(2*width, 4*height, width, height-4);
		boy = sheet.crop(width, 4*height, width, height-4);
		floor = sheet2.crop(0,0,width, height);
		wood = sheet2.crop(width, 0, width, height);
		pistol = ImageLoader.loadImage("/textures/pistol.png");
		oldMan = ImageLoader.loadImage("/textures/OldMan.png");
		backButton = ImageLoader.loadImage("/textures/BackSign.png");
		wallet = ImageLoader.loadImage("/textures/wallet.png");
		
		
		
	}


		//	GETTERS 
	public static int getAssetWidth(){
		return width;
	}
	
	public static int getAssetHeight(){
		return height;
	}
	
	
}
