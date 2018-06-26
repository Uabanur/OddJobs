package trafficsimulation;

import java.awt.Color;
import java.awt.Point;

import trafficsimulation.Vehicle.direction;

public class FamilyCar extends Vehicle {


	public FamilyCar() {
		super();
		initVelocity = 3;
		velocity = initVelocity;

	}

	public void move() {
		
		int newVel = r.nextInt(3);
		if(r.nextInt(5) == 0){
			if(newVel == 0) 
				velocity = 0.7*initVelocity;
			else if(newVel == 1)
				velocity = 1.4*initVelocity;
			else
				velocity = initVelocity;
		}
		int randomChange = r.nextInt(20);
		switch (dir) {
		case UP:
			position.y += checkDirection() ? velocity : Simulation.TRACKSIZE - this.getSize() - this.position.y;			
			if (position.y >= Simulation.TRACKSIZE - Simulation.TRACKWIDTH / 2) {
				dir = direction.LEFT;
			}
			if(randomChange == 0){
				position.x += checkAllBoundries()? velocity: 0;
			} else if(randomChange == 1){
				position.x -= checkAllBoundries()? velocity: 0;
			}
			break;

		case DOWN:
			position.y -= checkDirection() ? velocity : this.getSize();
			if (position.y <= Simulation.TRACKWIDTH / 2) {
				dir = direction.RIGHT;
			}
			if(randomChange == 0){
				position.x += checkAllBoundries()? velocity: 0;
			} else if(randomChange == 1){
				position.x -= checkAllBoundries()? velocity: 0;
			}
			break;

		case RIGHT:
			position.x += checkDirection() ? velocity : Simulation.TRACKSIZE - this.getSize() - this.position.x;
			if (position.x >= Simulation.TRACKSIZE - Simulation.TRACKWIDTH / 2) {
				dir = direction.UP;
			}
			if(randomChange == 0){
				position.y += checkAllBoundries()? velocity: 0;
			} else if(randomChange == 1){
				position.y -= checkAllBoundries()? velocity: 0;
			}
			break;

		case LEFT:
			position.x -= checkDirection() ? velocity : this.getSize();
			if (position.x <= Simulation.TRACKWIDTH / 2) {
				dir = direction.DOWN;
			}
			if(randomChange == 0){
				position.y += checkAllBoundries()? velocity: 0;
			} else if(randomChange == 1){
				position.y -= checkAllBoundries()? velocity: 0;
			}
			break;
		}

	}

	public Color getColor() {
		return Color.BLUE;
	}

	public Point getPosition() {
		return position;
	}

	public int getSize() {
		return 2;
	}

}
