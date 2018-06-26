import java.util.Arrays;
import java.util.Scanner;

public class FlexArray {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String input = s.nextLine();
		
		String[] tokens = input.split(" ");

		int[] array = new int[tokens.length];

		
		for(int i = 0; i < tokens.length; i++){
			array[i] = Integer.parseInt(tokens[i].trim());
		}
		
		printArray(array);
		
		
//		if(array.length > 3)
//			printArray(array);
//		else {
//			int[] fix = new int[3];
//			
//			for(int i = 0; i < array.length; i++)
//				fix[i] = array[i];
//			
//			for(int i = array.length-1; i < 3; i++)
//				fix[i] = s.nextInt();
//			
//			printArray(fix);
//		}
	}
	
	
	private static void printArray(int[] a) {
		int counter = 0;
		
		
		for(int number = 1; number*3 <= a.length; number++){
			System.out.print(a[0]);
			for (int j = 1; j < number*3; j++) {
				System.out.print("," + a[j]);
			}
			System.out.println();
		}
	}
}
