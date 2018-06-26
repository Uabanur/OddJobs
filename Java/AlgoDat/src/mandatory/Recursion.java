package mandatory;

import java.util.Scanner;

public class Recursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(f(sc.nextInt()));
		sc.close();
	}
	
	private static int f(int n){
		if(n <= 2) return n;
		
		return 2*f(n-1) + f(n-2) - f(n-3);
	}
}
