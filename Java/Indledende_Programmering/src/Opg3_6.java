
public class Opg3_6 {

	public static void main(String[] args) {
		
		quadratic(2, 2, -2);
	}

	private static void quadratic(int a, int b, int c) {
		
		System.out.printf("x1: %.4f\n", (-b + (Math.sqrt(b*b-4*a*c)))/(2*a));
		System.out.printf("x2: %.4f\n", (-b - (Math.sqrt(b*b-4*a*c)))/(2*a));
		
	}
}
