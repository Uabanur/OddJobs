package trafficsimulation;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class Vehicle {
	
	protected Point position;
	protected double initVelocity, velocity;
	protected Random r = new Random();
	protected direction dir;
	
	public Vehicle(){
		//Set vehicle randomly on track
		this.position = new Point();
		int startingEdge = r.nextInt(4);
		boolean random = true;
		if(random){
			switch(startingEdge){
			case 0: position.x = Simulation.TRACKWIDTH/2;
					position.y = r.nextInt(Simulation.TRACKSIZE - Simulation.TRACKWIDTH) + Simulation.TRACKWIDTH/2;
					dir = direction.DOWN;
					break;
			case 1: position.x = Simulation.TRACKSIZE - Simulation.TRACKWIDTH/2;
					position.y = r.nextInt(Simulation.TRACKSIZE - Simulation.TRACKWIDTH) + Simulation.TRACKWIDTH/2;
					dir = direction.UP;
					break;
			case 2: position.x = r.nextInt(Simulation.TRACKSIZE - Simulation.TRACKWIDTH) + Simulation.TRACKWIDTH/2;
					position.y = Simulation.TRACKWIDTH/2;
					dir = direction.RIGHT;
					break;
			case 3: position.x = r.nextInt(Simulation.TRACKSIZE - Simulation.TRACKWIDTH) + Simulation.TRACKWIDTH/2;
					position.y = Simulation.TRACKSIZE - Simulation.TRACKWIDTH/2;
					dir = direction.LEFT;
					break;
			}
		} else {
			position.x = Simulation.TRACKWIDTH/2;
			position.y = Simulation.TRACKWIDTH/2;
			dir = direction.RIGHT;
		}

	}
	
	protected enum direction{LEFT, RIGHT, UP, DOWN;}

	protected boolean checkAllBoundries(){
		
		boolean check = false;
		if(position.x - velocity > getSize() && position.x + velocity < Simulation.TRACKSIZE-getSize()){
			if(position.y - velocity > getSize() && position.y + velocity < Simulation.TRACKSIZE-getSize()){
				check = true;
				
				if(position.x + velocity + getSize() > Simulation.TRACKWIDTH && position.x - velocity - getSize() < Simulation.TRACKSIZE - Simulation.TRACKWIDTH){
				 if(position.y + velocity + getSize() > Simulation.TRACKWIDTH && position.y - velocity - getSize() < Simulation.TRACKSIZE - Simulation.TRACKWIDTH){
					check = false;
				 }
				}
			}
		}
		return check;
	}
	
	protected boolean checkDirection(){
		switch(dir){
		case UP: return position.y + velocity < Simulation.TRACKSIZE - getSize(); 
		case DOWN: return position.y - velocity > getSize(); 
		case RIGHT: return position.x + velocity < Simulation.TRACKSIZE - getSize(); 
		case LEFT: return position.x -velocity > getSize(); 
		default: return false;
		}
		
	}
	
	public abstract void move();
	
	public abstract Color getColor();

	public abstract Point getPosition();

	public abstract int getSize();

	
}
