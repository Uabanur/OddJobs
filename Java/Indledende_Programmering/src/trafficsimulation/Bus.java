package trafficsimulation;

import java.awt.Color;
import java.awt.Point;

import trafficsimulation.Vehicle.direction;

public class Bus extends Vehicle {
	
	public Bus(){
		super();
		initVelocity=2;
	}

	public void move() {
		velocity = initVelocity;
		
		switch (dir) {
		case UP:
			position.y += checkDirection() ? velocity : Simulation.TRACKSIZE - this.getSize() - this.position.y;
			if (position.y >= Simulation.TRACKSIZE - Simulation.TRACKWIDTH / 2) {
				dir = direction.LEFT;
			}
			break;

		case DOWN:
			position.y -= checkDirection() ? velocity : this.getSize();
			if (position.y <= Simulation.TRACKWIDTH / 2) {
				dir = direction.RIGHT;
			}
			break;

		case RIGHT:
			position.x += checkDirection() ? velocity : Simulation.TRACKSIZE - this.getSize() - this.position.x;
			if (position.x >= Simulation.TRACKSIZE - Simulation.TRACKWIDTH / 2) {
				dir = direction.UP;
			}
			break;

		case LEFT:
			velocity = 1.5*initVelocity;
			position.x -= checkDirection() ? velocity : this.getSize();
			if (position.x <= Simulation.TRACKWIDTH / 2) {
				dir = direction.DOWN;
			}
			break;
		}
	}

	public Color getColor() {
		return Color.RED;
	}

	public Point getPosition() {
		return position;
	}

	public int getSize() {
		return 4;
	}

}
