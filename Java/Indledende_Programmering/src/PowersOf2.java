
public class PowersOf2 {
	
	public static void main(String[] args) {
		
		
		printPowersOf2(10);
	}

	private static void printPowersOf2(int max) {
		System.out.print("1");
		for(int i = 1; i <= max; i++){
			
			System.out.print(" " + getPower(2, i));
			
			
		}
		
	}

	private static int getPower(int number, int power) {
		int result = 1;
		for(int i = 0; i < power; i++)
			result*=2;
		return result;
	}
	
}
