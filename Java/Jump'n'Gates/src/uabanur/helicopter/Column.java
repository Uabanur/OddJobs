package uabanur.helicopter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Column {
	public Rectangle rectangle1, rectangle2;
	public Random rand;
	public int columnSpeed, rectSize;

	public Column(int columnSpeed) {
		rectSize = (int) (Math.random() * (Display.height - 100));

		this.columnSpeed = columnSpeed;

		rectangle1 = new Rectangle(100, rectSize);

		rectangle1.x = Display.width;
		rectangle1.y = 0;

		rectangle2 = new Rectangle(100, (int) (Display.height
				- rectangle1.height - 100));

		rectangle2.y = rectangle1.height + 100;
		rectangle2.x = Display.width;
	}

	public void tick() {
		rectangle1.x -= columnSpeed;
		rectangle2.x -= columnSpeed;
 
		if (GameState.score % 40 >= 20 && GameState.score %40 <= 40 ) {
			rectangle1.height = rectSize + (int) (Math.sin((double) System.currentTimeMillis() / 600) * 50);
			rectangle2.y = rectangle1.height + 100;
			rectangle2.height = (int) (Display.height - rectangle1.height - 100);
			
			if (GameState.score % 40 >= 30) {
				rectangle1.x += (int) (Math.cos((double) System.currentTimeMillis() / 500)*5);
				rectangle2.x += (int) (Math.cos((double) System.currentTimeMillis() / 500)*5);
			}
		}

	}

	public void render(Graphics g) {
		if (GameState.score % (GameState.changeSpeedAt) == 0
				&& GameState.score != 0) {
			g.setColor(Color.RED.darker());
			g.drawString("NIVEAU UP!", rectangle2.x + 12, rectangle2.y - 20);
		} else
			g.setColor(Color.green.darker());

		g.fillRect(rectangle1.x, rectangle1.y, rectangle1.width,
				rectangle1.height);

		g.fillRect(rectangle2.x, rectangle2.y, rectangle2.width,
				rectangle2.height);

	}

}
