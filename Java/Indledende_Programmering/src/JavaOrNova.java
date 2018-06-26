import java.util.Scanner;


public class JavaOrNova {
	
	public static void main(String[] args) {
		
		Scanner sr = new Scanner(System.in);
		
		String line = sr.nextLine();
		
		if(line.contains("java") || line.contains("nova"))
			System.out.println("yes");
		else
			System.out.println("no");
		
	}
	
}
