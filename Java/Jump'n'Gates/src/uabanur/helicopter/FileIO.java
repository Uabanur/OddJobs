package uabanur.helicopter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileIO {
	
	private static File file = new File("res/files/file.txt");
	
	public static void getInput(){
		
		try {
			Scanner input = new Scanner(file);
			
			GameState.highscore = input.nextInt();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not load file");
		}
		System.out.println("Loaded!");
		
	}

	
	public static void setOutput(){
		
		try {
			PrintStream output = new PrintStream(file);
			output.println(GameState.highscore);
			output.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Saved!");
	}
}
