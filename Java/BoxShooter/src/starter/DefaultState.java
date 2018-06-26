package starter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class DefaultState extends State {
	
	public void setup() {
		
	}

	public void tick() {

	}

	public void render(GraphicsContext gc) {
		String text = "No state has been chosen";
		gc.fillText(text, 240, 210);
	}

	public void keyBoardPressed(KeyEvent event) {

	}

	public void keyBoardReleased(KeyEvent event) {

	}


}
