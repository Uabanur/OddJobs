package uabanur.firstgame;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

	private static String path = "/Users/Roar/Downloads/Happy_Background_Music (4).wav";

	public static void main(String[] args){
		play();

		
	}
	
	
	
	static void play() {
		
		playSound(path);
		
	}



	static void playSound(String path) {
		
		 try{
  	      AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
  	     Clip clip = AudioSystem.getClip();
  	     clip.open(audioInputStream);
  	     clip.loop(Clip.LOOP_CONTINUOUSLY);
  	    }
  	   catch(Exception ex){ 
  		System.out.println("Error with playing sound.");
  		ex.printStackTrace(); 
  		}
	

	}
	
}
