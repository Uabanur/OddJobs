package uabanur.helicopter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PauseState extends State {
	
	public PauseState(){
		
	}

	@Override
	public void tick() {
		if (Display.space)
			State.setState(Display.gameState);
	}

	@Override
	public void render(Graphics g) {
		

		g.setColor(Color.green.darker());
		g.fillRect(0, Display.height - 20, Display.ground.width, Display.ground.height);
		
		screenText(g);

	}

	public void screenText(Graphics g) {
		
		
		
		g.setColor(Color.GREEN.darker());
		g.setFont(new Font("Verdana", 1, 30));
		g.drawString("GAME PAUSED",180 ,90);
		g.drawString("Continue: press space", 115, 300);
		
		g.setColor(Color.RED);
		g.drawString("Niveau: " + GameState.niveau, 200, 150);
		g.drawString("Score: " + GameState.score, 200, 190);
		g.drawString("Highscore: " + GameState.highscore, 200, 230);

	}

}
