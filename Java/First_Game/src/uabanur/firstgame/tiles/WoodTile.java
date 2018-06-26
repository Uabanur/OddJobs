package uabanur.firstgame.tiles;

import uabanur.firstgame.gfx.Assets;

public class WoodTile extends Tile {

	public WoodTile( int id) {
		super(Assets.wood, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
