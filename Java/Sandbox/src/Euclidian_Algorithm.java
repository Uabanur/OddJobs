import java.util.Scanner;

public class Euclidian_Algorithm {

	public static void main(String[] args) {
		int[] a = {1,2, 3}, b = {1, 2};
		Euclidean_Algorithm_Numbers(14, 3);
		
		
	}
	
	public static void Euclidean_Algorithm_Numbers(int a, int b){
		int var1, var2, s1, s2, t1, t2, temp, tempt, temps;
		
		var1 = Math.max(a, b);
		var2 = Math.min(a, b);
		s1 = 1; s2 = 0;
		t1 = 0; t2 = 1;
		
		temp = Integer.MAX_VALUE;
		System.out.println("r_k\ts\tt");
		System.out.println();
		while(temp != 0){
			System.out.println(var1 + "\t" + s1 + "\t" + t1);
			temp = var1 - (var1/var2) * var2;
			
			temps = s1 - (var1/var2)*s2;
			tempt = t1 - (var1/var2)*t2;
			
			var1 = var2;
			var2 = temp;
			t1 = t2;
			t2 = tempt;
			s1 = s2;
			s2 = temps;
			
		}
		System.out.println(var1 + "\t" + s1 + "\t" + t1);
		System.out.println(var2 + "\t" + s2 + "\t" + t2);
		System.out.println();
		System.out.println("sfd: " + var1 + ", s: " + s1 + ", t: " + t1);
		System.out.println(Math.max(a,b) + "*(" + s1 + ") + " + Math.min(a,b) + "*(" + t1 + ") = " + (Math.max(a,b)*s1+Math.min(a,b)*t1));
		
	}
	
	public static void Euclidean_Algorithm_Polynimials(int[] a, int[] b){
		if(a.length == 0 || b.length == 0){
			System.out.println("invalid input");
			System.exit(0);
		}
		
		System.out.print("Polynomial #1: ");
		System.out.print(a[0]);
		for(int i = 1; i < a.length; i++){
			System.out.print(" + " + a[i] + "*x^" + i);
		}
		System.out.println();
	
		System.out.print("Polynomial #2: ");
		System.out.print(b[0]);
		for(int i = 1; i < b.length; i++){
			System.out.print(" + " + b[i] + "*x^" + i);
		}
		System.out.println();
	
		
		int[] var1, var2;
		boolean done = false;
		var1 = a.length > b.length? a : b;
		var2 = a.length > b.length? b : a;
		int temp = 0;
		
		while(!done){
			temp = a[a.length-1] - (a[a.length-1]/b[b.length-1]) * b[b.length-1];
			
			done = true;
		}
		
		System.out.println(temp);
		
	}
	
}




















