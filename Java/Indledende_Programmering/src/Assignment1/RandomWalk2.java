package Assignment1;

import java.util.Random;

public class RandomWalk2 {

	public static void main(String[] args) {
		runSimulation2(50, 20, 5);
	}

	private static int x1, y1, x2, y2, direction;

	public static void runSimulation2(int n, int t, int s) {
		
		if(!(n>0) || !(t>0) || !(s>0)){
			System.out.println("--ERROR-- \nNon-positive values not allowed");
			System.exit(0);
		} 

		// Access the Random class to get uniformly distributed numbers.
		Random r = new Random();

		showParameters(n, t, s);

		placeParticles(r, n);

		showCoordinates();

		// move t times.
		for (int i = 0; i < t; i++) {
			moveP1(n, s, r);
			
			if(x1 == x2 && y1 == y2){
				showCoordinates();
				System.out.println("Crash");
				break;
			}
			
			moveP2(s);
			showCoordinates();
			
			if(x1 == x2 && y1 == y2){
				System.out.println("Crash");
				break;
			} 
		}
	}

	private static void moveP1(int n, int s, Random r) {

		// choosing what direction to move particle 1:
		// up = 0, down = 1, left = 2, right = 3.
		direction = r.nextInt(4);

		if (direction == 0) {
//			System.out.println("Moving Up");
			moveUp(n, s, r, 1);
		} else if (direction == 1) {
//			System.out.println("Moving Down");
			moveDown(n, s, r, 1);
		} else if (direction == 2) {
//			System.out.println("Moving Left");
			moveLeft(n, s, r, 1);
		} else {
//			System.out.println("Moving Right");
			moveRight(n, s, r, 1);
		}

	}

	private static void moveP2(int s) {
		//If the difference in x is bigger than in y change x
		if(Math.abs(x1 - x2) > Math.abs(y1 - y2)){
			if(x1 - x2 > 0){
				x2 += (x1-x2) > s? s : x1-x2;
			} else {
				x2 -= (x2-x1) > s? s : x2-x1;
			}
			
		} else {  		// else change y also if they are equal.
			
			if(y1 - y2 > 0){
				y2 += (y1-y2) > s? s : y1-y2;
			} else {
				y2 -= (y2-y1) > s? s : y2-y1;
			}
			
		}
	}

	private static void placeParticles(Random r, int n) {

		// Place particle1 at random on grid.
		x1 = r.nextInt(n);
		y1 = r.nextInt(n);

		// Place particle2 at random on grid
		x2 = r.nextInt(n);
		y2 = r.nextInt(n);

	}

	private static void moveUp(int n, int s, Random r, int p) {
		// random move with possible length 0 to s (including s)
		int move = r.nextInt(s)+1;
		
		//p is chosen in order to choose particle 1 or particle 2.
			//Could have been done with boolean, but found it more clear with values 1 or 2.
		if (p == 1) {
			//Checking if in grid then move
			if (y1 + move < n)
				y1 += move;
		} else {
			//Checking if in grid then move
			if (y2 + move < n)
				y2 += move;
		}
	}

	private static void moveDown(int n, int s, Random r, int p) {
		int move = r.nextInt(s+1);
		if (p == 1) {
			if (y1 - move < n && y1 - move >= 0)
				y1 -= move;
		} else {
			if (y2 - move < n && y2 - move >= 0)
				y2 -= move;
		}
	}

	private static void moveRight(int n, int s, Random r, int p) {
		int move = r.nextInt(s+1);
		if (p == 1) {
			if (x1 + move < n)
				x1 += move;
		} else {
			if (x2 + move < n)
				x2 += move;
		}
	}

	private static void moveLeft(int n, int s, Random r, int p) {
		int move = r.nextInt(s+1);
		if (p == 1) {
			if (x1 - move < n && x1 - move >= 0)
				x1 -= move;
		} else {
			if (x2 - move < n && x2 - move >= 0)
			x2 -= move;
		}
	}

	
	private static void showParameters(int n, int t, int s) {
		//Show parameters n, t and s.
		System.out.println("n=" + n + " t=" + t + " s=" + s);
	}

	private static void showCoordinates() {
		// Show starting coordinates
		System.out.println("[" + x1 + ";" + y1 + "] [" + x2 + ";" + y2 + "]");

	}

}
