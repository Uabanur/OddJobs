package uabanur.helicopter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOverState extends State {

	public GameOverState(){
		
	}
	
	@Override
	public void tick() {
		if(Display.anyKey)
			State.setState(Display.gameState);
		
		GameState.score = 0;
		Ball.ball.x = Display.width / 2;
		Ball.ball.y = Display.height / 2;
		GameState.columnSpeed = 5;
		GameState.niveau = 1;
		
		GameState.resetColumns();
	}

	@Override
	public void render(Graphics g) {
		
		screenText(g);

	}

	public void screenText(Graphics g) {
		g.setColor(Color.GREEN.darker());
		g.setFont(new Font("Verdana", 1, 30));
		g.drawString("GAME OVER!", 190, 180);
		g.drawString("Press a key to try again", 100, 230);
	}
	
	

}
