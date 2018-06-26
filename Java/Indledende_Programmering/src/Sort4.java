import java.util.Arrays;


public class Sort4 {
	
	public static void sort4(int a0, int a1, int a2, int a3){
		
		int[] numbers = {a0, a1, a2, a3};

		Arrays.sort(numbers);
		
		System.out.print(numbers[0]);
		for(int i = 1; i < numbers.length; i++){	
			System.out.print(" " + numbers[i]);
		}
		
		System.out.println();
	}
}
