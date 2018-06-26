import java.util.InputMismatchException;
import java.util.Scanner;


public class IsNumber {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		try{
		sc.nextFloat();
		System.out.println("yes");
		} catch (InputMismatchException ime){
			System.out.println("no");
		}

	}
}
