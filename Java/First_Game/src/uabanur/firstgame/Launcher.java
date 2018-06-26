package uabanur.firstgame;


public class Launcher {

	public static void main(String[] args){
		
		
		// Values: String <Title>, int <width of window>, int <height of window>
		
		Game game = new Game("First Game",64*9,64*6);
		game.start();
	}
	
}
