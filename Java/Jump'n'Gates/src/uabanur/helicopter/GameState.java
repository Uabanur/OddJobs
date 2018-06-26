package uabanur.helicopter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameState extends State {
	public static Ball user;


	public static int columnSpeed = 5, jumpHeight = 8, speedIncrease = 1, changeSpeedAt = 10,
			score = 0, highscore = 0, niveau = 1;

	public static ArrayList<Column> column = new ArrayList<Column>();

	public GameState() {
		user = new Ball();

		resetColumns();
	}

	@SuppressWarnings("static-access")
	
	@Override
	public void tick() {
		
		if(Display.pButton)
			State.setState(Display.pauseState);
		

		if (score > highscore){
			highscore = score;
			FileIO.setOutput();
		}


		for (int i = 0; i < column.size(); i++) {
			column.get(i).tick();

			if (column.get(i).rectangle1.x < -column.get(i).rectangle1.width) {
				column.remove(i);
				column.add(new Column(columnSpeed));
			}
		}

		for (Column c : column) {

			if (user.ball.intersects(c.rectangle1)) {
				if (user.ball.x <= c.rectangle1.x)
					user.ball.x = c.rectangle1.x - user.ball.width;

				if (user.ball.x > c.rectangle1.x) {
					user.yVel = 0;
					user.ball.y = c.rectangle1.y + c.rectangle1.height;
				}

			}

			if (user.ball.intersects(c.rectangle2)) {
				if (user.ball.x <= c.rectangle2.x)
					user.ball.x = c.rectangle2.x - user.ball.width;

				if (user.ball.x > c.rectangle2.x) {
					user.yVel = 0;
					user.ball.y = c.rectangle2.y - user.ball.height;
				}
			}

			if (user.ball.x >= c.rectangle1.x
					&& user.ball.x <= c.rectangle1.x + columnSpeed) // when it
																	// passes
				// through a section
				// by the column
				score++;

			if (score >= niveau * changeSpeedAt) {
				niveau++;
					if(score % 40 <= 20){
					c.columnSpeed += speedIncrease;
					columnSpeed += speedIncrease;
					}
			}
		}
		
		user.tick();

	}

	@Override
	public void render(Graphics g) {
		user.render(g);


		for (Column c : column) {
			c.render(g);
		}

		g.setColor(Color.green.darker());
		g.fillRect(0, Display.height - 20, Display.ground.width, Display.ground.height);

		screenText(g);

	}
	
	public static void resetColumns(){
		column.clear();
		column.add(new Column(columnSpeed));
	}

	public void screenText(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("Highscore: " + highscore, 10, 20);
		g.drawString("Score: " + score, 10, 35);
		g.setColor(Color.BLACK);
		g.drawString("Fps: " + Display.fpsCounter, Display.width - 100, 20);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Verdana", 1, 30));
		g.drawString("NIVEAU: " + niveau, 200, 40);
	}

}
