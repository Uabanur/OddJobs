package uabanur.firstgame.entities.statics;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.Assets;

public class House1 extends StaticEntity {

	public House1(Handler handler, float x, float y) {
		super(handler, x, y, 200, 200);

		bounds.x = 30;
		bounds.y = 100;
		bounds.width = 133;
		bounds.height = 100;
		
	}

	@Override
	public void tick() {

		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.house1, (int) (x-handler.getGameCamera().getxOffset()),
				(int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		
	}

}
