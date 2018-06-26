package uabanur.firstgame.entities.statics;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.Assets;
import uabanur.firstgame.states.State;
import uabanur.firstgame.tiles.Tile;

public class Boy extends StaticEntity {
	
	

	public Boy(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		//Creates the rectangle of the player which controls collision
	bounds.x 		= 25;
	bounds.y		= 50;
	bounds.width	= 13;
	bounds.height	= 13;
	}
	
	
	

	@Override
	public void tick() {
		if(checkEntityCollisions(10, 10) ||checkEntityCollisions(-10, -10) ||
				checkEntityCollisions(-10, 10) || checkEntityCollisions(10, -10)){
			if(handler.getGame().getKeyManager().space)
				State.setState(handler.getGame().citizen1Talk);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.boy, (int) (x-handler.getGameCamera().getxOffset()),
				(int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		g.drawString("Press Space", (int) (x-handler.getGameCamera().getxOffset())-5,
				(int) (y-handler.getGameCamera().getyOffset())-10);
		
	}

}
