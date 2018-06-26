package weekplan1;

import java.util.Scanner;

public class Algorithm2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] A = new int[sc.nextInt()];
		
		for(int i = 0; i < A.length; i++){
			A[i] = sc.nextInt();
		}
		
		
		System.out.println(algorithm2(A));
		
		sc.close();
	}
	
	public static int algorithm2(int[] A){
		
		int max = 0;
		
		for(int i = 0; i < A.length; i++){
			if(A[i] > A[max])
				max = i;
		}
		
		return max;
	}
}
