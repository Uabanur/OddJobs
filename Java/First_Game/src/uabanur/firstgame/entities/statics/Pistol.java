package uabanur.firstgame.entities.statics;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.Assets;
import uabanur.firstgame.inventory.Inventory;
import uabanur.firstgame.tiles.Tile;

public class Pistol extends StaticEntity {

	public Pistol(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH/2, Tile.TILEHEIGHT/2);
	}

	@Override
	public void tick() {
		if(checkEntityCollisions(10, 10) ||checkEntityCollisions(-10, -10)){
			handler.getWorld().getEntityManager().removeEntity(this);
			Inventory.items[0]=true;
			
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.pistol, (int) (x-handler.getGameCamera().getxOffset()),
				(int) (y-handler.getGameCamera().getyOffset()), width, height, null);
	}

}
