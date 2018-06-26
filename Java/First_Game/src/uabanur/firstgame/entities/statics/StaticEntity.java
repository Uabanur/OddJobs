package uabanur.firstgame.entities.statics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

	}
	
	public float getxMove(){
		return xMove;
	}
	

}
