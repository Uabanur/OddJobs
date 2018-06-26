package uabanur.firstgame.states;

import java.awt.Graphics;

import uabanur.firstgame.Handler;

public abstract class State {
	
		private static State currentState = null;
	
	
	//CLASS
	
		protected Handler handler; 
	
	public State(Handler handler){
		this.handler=handler;
	}
	
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
