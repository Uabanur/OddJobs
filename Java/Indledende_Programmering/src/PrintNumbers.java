import java.util.Scanner;


public class PrintNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		printNumbers(number);
		
	}

	private static void printNumbers(int number) {
		
		System.out.print("[1]");
		
		for(int i = 2; i <= number ; i++){
			System.out.print("[" + i + "]");
		}
		
	}
	
}
