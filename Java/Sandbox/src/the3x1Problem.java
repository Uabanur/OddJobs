import java.util.Scanner;


public class the3x1Problem {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please inter a number to check: ");
		
		
		int testNumber = input.nextInt(), length = 1, biggestNumber = 1;
		testNumber = Math.abs(testNumber);
		
		System.out.print(testNumber + " ");
		
		while(testNumber != 1){
			
			length++;
 
			if(testNumber > biggestNumber)
				biggestNumber = testNumber;
			
			if(testNumber %2 == 0)
				testNumber /= 2;
			else 
				testNumber = testNumber*3+1;
			
			testNumber = Math.abs(testNumber);
			
			System.out.print(testNumber + " ");
		}
		System.out.println();
		System.out.println("Biggest number: " + biggestNumber);
		System.out.println("Length: " + length);
		
		
	}

}
