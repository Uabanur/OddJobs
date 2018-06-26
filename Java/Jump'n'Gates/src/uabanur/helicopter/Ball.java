package uabanur.helicopter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Ball {

	public static Rectangle ball;
	
	static int ballSize = 20;
	public Ball() {
		ball = new Rectangle(ballSize, ballSize);

		ball.x = Display.width / 2 - ball.width / 2;
		ball.y = Display.height / 2 - ball.height / 2;

	}

	public static double yVel = 0, yAcc = 15.0 / 60;

	public void tick() {
		yVel += yAcc;

		if (ball.x <= -ball.width) {
			State.setState(Display.gameOverState);
		}

		if (ball.y <= Display.height - ball.height - Display.ground.height)
			ball.y += yVel;
		
		if(ball.y >= Display.height - ball.height - Display.ground.height){
			yVel = 0;
			ball.y = Display.height - Display.ground.height - ball.height;
		}

		if (ball.x <= Display.width / 2)
			ball.x++;

		if(ball.y < 0){
			yVel = 0;
			ball.y = 0;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow.darker());
		g.fillOval(ball.x, ball.y, ball.width, ball.height);

	}
	
	public static void upPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_UP && ball.y >= 0)
			yVel = -yAcc * 30;
		
	}
	
	public static void downPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_DOWN && ball.y < Display.height - Display.ground.height )
			yVel = yAcc * 30;
		
	}

}
