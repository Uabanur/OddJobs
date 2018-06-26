import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class ResultatFiltrering {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("/Users/Roar/Dropbox/Indlejrede Systemer/r/A3/Gezel/DS2.txt"));
		PrintStream printText = new PrintStream(new File("/Users/Roar/Dropbox/Indlejrede Systemer/m/Gibberish_resultater.txt"));
		boolean ready = false;
		while(s.hasNextLine()){
			String line = s.nextLine();
			String[] tokens = line.split("[^a-zA-Z]+");
			
			if(!ready && tokens.length > 0 && tokens[0].equals("ram")){
				ready = true;
			}
			
			if(ready && line.charAt(0) == '0'){
				break;
			}
			
		}
		
		
		boolean print = false;
		String index = "";
		String oldIndex = "";
		String resultat = "";
		while(s.hasNextLine()){
			String line = s.nextLine();
			
			for(int i = 0 ; i < line.length(); i++ ){
				if(line.charAt(i) != '/'){
					index += line.charAt(i);
				} else {
					break;
				}
			}
			
			
			if(!oldIndex.equals(index)){
				System.out.print(index + " ");
				print = true;
			}
			
			if(print){
				
				for(int i = 2*index.length()+2; i < line.length(); i++){
					if(line.charAt(i) != '/'){
						resultat += line.charAt(i);
					} else {
						break;
					}
				}
				
				System.out.println(resultat);
				printText.append(resultat + "\n");
				
				if(Integer.parseInt(index) == 250){
					break;
				}
			}
			
			oldIndex = index;
			index = "";
			resultat = "";
			print = false;
			
			
		}
		
	}
	
}
