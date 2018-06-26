package trafficsimulation;

import java.awt.Point;

/**
 * 
 * @author Paul Fischer
 *
 */
public class TrafficDriver {


	public static void main(String[] args) {
		// Create a simulation ...
		Simulation sim = new Simulation(20, 1000);
		// ... and run it.
		sim.run();

	}
}
