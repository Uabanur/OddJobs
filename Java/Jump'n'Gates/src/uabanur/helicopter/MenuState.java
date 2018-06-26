package uabanur.helicopter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MenuState extends State {

	public MenuState() {

	}

	@Override
	public void tick() {
		if (Display.anyKey)
			State.setState(Display.gameState);

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.yellow.darker());
		g.fillOval(Display.width / 2 - Ball.ballSize / 2, Display.height / 2 - Ball.ballSize / 2, Ball.ballSize, Ball.ballSize);

		g.setColor(Color.green.darker());
		g.fillRect(0, Display.height - 20, Display.ground.width, Display.ground.height);

		screenText(g);

	}

	public void screenText(Graphics g) {
		g.setColor(Color.GREEN.darker());
		g.setFont(new Font("Verdana", 1, 30));
		g.drawString("WELCOME!", 210, 100);
		g.drawString("Press any key to start", 110, 150);
		g.drawString("Up and down to steer ball", 85, 300);
	}

}
