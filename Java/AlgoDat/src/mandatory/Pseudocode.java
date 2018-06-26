package mandatory;

import java.util.Arrays;
import java.util.Scanner;

public class Pseudocode {
	
	public static void main(String[] args) {
		
		int[] A = intArray();
		int n = A.length;
		
		Arrays.sort(A);
		
		for(int i = 0; i <= (n-1)/2; i++){
			
			int s = 0;
			for(int j = 0; j <= i; j++){
				s = s + A[j] + A[n-j-1];
			}
			System.out.println(s);
		}
		
	}

	private static int[] intArray() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		
		for(int i = 0; i < n; i++){
			A[i] = sc.nextInt();
		}
		
		sc.close();
		
		return A;
	}
	
	
}
