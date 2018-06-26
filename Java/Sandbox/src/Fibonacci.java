
public class Fibonacci {
	
	public static void main(String[] args){
		fibonacciNumbers(1,1,12);
		
	}
	
	private static void fibonacciNumbers(int first, int second, int level){
		level = Math.abs(level);
		if(level == 0){
			//do nothing
		} else {
			System.out.print(first + "  ");
			fibonacciNumbers(second, (first + second), level - 1);
		}
	}
}
