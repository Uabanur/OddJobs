package uabanur.firstgame.entities.statics;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.Assets;
import uabanur.firstgame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
	
	bounds.x = width/2-4 ;
	bounds.y = 100;
	bounds.width = 9;
	bounds.height = height/5-2;
	}
	
	@Override
	public void tick() {

		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x-handler.getGameCamera().getxOffset()),
				(int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		
	}

}
