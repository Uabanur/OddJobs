import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cleaner {

	public static void cleanText(String filename) {
		boolean spaces;
		try {
			Scanner sc = new Scanner(new File(filename));
			
			while (sc.hasNextLine()) {
				String[] word = sc.nextLine().split(" ");
				spaces = false;
				
				for (int i = 0; i < word.length; i++) {
					word[i] = word[i].replaceAll("[^a-zA-Z]", "");
					
					if (word[i].trim().length() != 4 && !word[i].isEmpty()) {
						
						if (spaces)
							System.out.print(" ");
						
						System.out.print(word[i]);
						spaces = true;
					}
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
		}
	}
}
