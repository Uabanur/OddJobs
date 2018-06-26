import java.util.Scanner;


public class ProcessName {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		processName(s);
		
	}

	private static void processName(Scanner s) {
		String name;
		System.out.print("Please enter your full name:\n");
		
		name = s.nextLine();
		String[] tokens = name.split(" ");
		
		System.out.print("Your name in reverse order is " + tokens[tokens.length-1] );
		
		for(int i = tokens.length-2; i >=0; i-- )
			System.out.print(", " + tokens[i]);
		
		System.out.println();
		
	}
}
