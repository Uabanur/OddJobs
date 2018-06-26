package uabanur.helicopter;

import java.awt.Graphics;

public abstract class State {
	
	static State currentState = null;
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//GETTERS AND SETTERS
	
	public static void setState(State state){
		currentState=state;
	}
	
	public static State getState(){
		return currentState; 
	}
	
}
