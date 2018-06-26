package Assignment1;

import java.util.Random;

public class RandomWalk {
	
	public static void main(String[] args) {
		runSimulation(10, 50, 2);
	}
	
	public static void runSimulation(int n, int t, int s){
		if(!(n>0) || !(t>0) || !(s>0)){
			System.out.println("--ERROR-- \nNon-positive values not allowed");
			System.exit(0);
		} 

		
		int x, y;
		
		
		//Access the Random class to get uniformly distributed random numbers.
		Random r = new Random();
		
		//Show given parameters.
		showParameters(n, t, s);
		
		//Place at random on grid.
		x = r.nextInt(n);
		y = r.nextInt(n);
		
		//Show starting coordinates
		System.out.println("[" + x + ";" + y + "]");
		
		//move t times.
		for(int i = 0; i < t; i++){
			
		//choosing what direction to move: up = 0, down = 1, left = 2, right = 3.
		int direction = r.nextInt(4);
		
		if(direction == 0){
			//System.out.println("Moving Up");
			y = moveUp(y, n, s, r);
		} else if(direction == 1){
			//System.out.println("Moving Down");
			y = moveDown(y, n, s, r);
		} else if(direction == 2){
			//System.out.println("Moving Left");
			x = moveLeft(x, n, s, r);
		} else {
			//System.out.println("Moving Right");
			x = moveRight(x, n, s, r);
		}
		
		//Show coordinates after each move
		System.out.println("[" + x + ";" + y + "]");
		}
	}
	
	private static int moveUp(int y, int n, int s, Random r) {
		//random move with possible length 0 to s (including)
		int move = r.nextInt(s+1);
		if(y + move < n)
			y+= move;
//		else 
//			System.out.println("Out of bounds");
		
		return y;
	}
	
	private static int moveDown(int y, int n, int s, Random r) {
		//random move with possible length 0 to s (including)
		int move = r.nextInt(s+1);
		if(y-move < n && y-move >= 0)
			y-= move;
//		else
//			System.out.println("Out of bounds");
		
		return y;
	}
	
	private static int moveLeft(int x, int n, int s, Random r) {
		//random move with possible length 0 to s (including)
		int move = r.nextInt(s+1);
		if(x-move < n && x-move >= 0)
			x-= move;
//		else
//			System.out.println("Out of bounds");
		
		return x;
	}
	
	private static int moveRight(int x, int n, int s, Random r) {
		//random move with possible length 0 to s (including)
		int move = r.nextInt(s+1);
		if(x+move < n)
			x+= move;
//		else
//			System.out.println("Out of bounds");
		
		return x;
	}
	
	

	private static void showParameters(int n, int t, int s){
		System.out.println("n=" + n + " t=" + t + " s=" + s);
	}
	
}
