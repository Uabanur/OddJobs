package trafficsimulation;

import java.awt.Color;
import java.awt.Point;

public class DrunkenDriver extends Vehicle {

	public DrunkenDriver(){
		super();
		initVelocity = 3;
		velocity = initVelocity;
	}
	
	
	public void move(){
		
		if(r.nextInt(10) == 0){
			int newVel = r.nextInt(3);
			if(newVel == 0) 
				velocity = 0.7*initVelocity;
			else if(newVel == 1)
				velocity = 1.4*initVelocity;
			else
				velocity = initVelocity;
		}
		
		switch(dir){
		case UP: position.y += velocity; break;
		case DOWN: position.y -= velocity; break;
		case RIGHT: position.x += velocity; break;
		case LEFT: position.x -= velocity; break;
		}

		
		if(!checkAllBoundries()){
			switch(dir){
			case UP: position.y -= 2*velocity; break;
			case DOWN: position.y += 2*velocity; break;
			case RIGHT: position.x -= 2*velocity; break;
			case LEFT: position.x += 2*velocity; break;
			}
			changeDirection();
		}
		
		if(r.nextInt(10) == 0)
			changeDirection();
		
	}

	public Color getColor() {
		return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}

	public Point getPosition() {
		return position;
	}

	public int getSize() {
		return 2;
	}
	
	private void changeDirection(){
		int choice = r.nextInt(4);
		switch(choice){
		case 0: dir = direction.UP; break;
		case 1: dir = direction.DOWN; break;
		case 2: dir = direction.LEFT; break;
		case 3: dir = direction.RIGHT; break;
		}
	}
}
