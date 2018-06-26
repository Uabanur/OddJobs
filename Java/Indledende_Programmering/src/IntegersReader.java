import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class IntegersReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("Integer.txt"));
		boolean outofRange = false;
		int lowerBound = s.nextInt();
		int lowCounter = 0;
		int higherBound = s.nextInt();
		int highCounter = 0;
		int checkInt;
		
		while(s.hasNextInt()){
			checkInt = s.nextInt();
			if(checkInt == lowerBound)
				lowCounter++;
			if(checkInt == higherBound)
				highCounter++;
			
			if(checkInt > higherBound || checkInt < lowerBound)
				outofRange = true;
			
		}
		
		System.out.println("lowerBound: " + lowerBound + ", occured " + lowCounter + " times.");
		System.out.println("higherBound: " + higherBound + ", occured " + highCounter + " times.");
		System.out.println(outofRange? "Not all in range":"All in range");
	}
	
	
}
