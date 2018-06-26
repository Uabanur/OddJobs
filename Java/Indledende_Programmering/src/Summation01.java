import java.util.Scanner;


public class Summation01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input start value");
		int start = s.nextInt();
		System.out.println("Input end value");
		int end = s.nextInt();
		
		int sum=0;
		
		for(int i = start; i <= end; i++){
			sum+=i;
		}
		System.out.printf("Sum is of integers from %d to %d is %d", start, end, sum);
	}
	
	
}
