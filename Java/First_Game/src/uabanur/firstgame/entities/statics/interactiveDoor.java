package uabanur.firstgame.entities.statics;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.states.GameState;
import uabanur.firstgame.tiles.Tile;

public class interactiveDoor extends StaticEntity {

	public interactiveDoor(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH-25, Tile.TILEHEIGHT+10);
		
		bounds.x = 0;
		bounds.y = Tile.TILEHEIGHT+10;
		bounds.width = Tile.TILEWIDTH-25;
		bounds.height = 2;
	}
	
	public static void init(){
		
	}

	@Override
	public void tick() {
		if(checkEntityCollisions(0, 10)){
			GameState.chooseWorld = 1;
		}
	}

	@Override
	public void render(Graphics g) {
		
		
	}

}
