package weekplan1;

import java.util.Scanner;

public class Algorithm1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] A = new int[sc.nextInt()];
		
		for(int i = 0; i < A.length; i++){
			A[i] = sc.nextInt();
		}
		
		
		System.out.println(algorithm1(A));
		
		sc.close();
	}
	
	public static int algorithm1(int[] A){
		
		if(A[0] >= A[1]){
			return 0;
		}
		
		for(int i = 1; i < A.length-1; i++){
			if(A[i-1] <= A[i] && A[i] >= A[i+1]){
				return i;
			}
		}
		
		if(A[A.length-2] <= A[A.length-1]){
			return A.length-1;
		}
		
		return 0;
	}
	
}
