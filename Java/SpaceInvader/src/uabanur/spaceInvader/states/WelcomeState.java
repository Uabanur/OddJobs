package uabanur.spaceInvader.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uabanur.spaceInvader.Display;

public class WelcomeState extends State{

	@Override
	public void tick() {
		if(Display.keyManager.enter)
			State.setState(Display.gameState);
		
		if(Display.keyManager.p)
			State.setState(Display.menuState);
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.setFont(new Font("Verdana", 1, 40));
		g.setColor(Color.green.darker());
		g.drawString("Welcome!", 190, 200);
		g.setFont(new Font("Verdana", 1, 25));
		g.drawString("Press enter to start", 160, 400);
		g.drawString("Press p to go to menu", 145, 450);
		
	}

}
