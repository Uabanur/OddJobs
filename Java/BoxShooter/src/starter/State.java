package starter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public abstract class State {
	
	
	public abstract void setup();

	public abstract void tick();

	public abstract void render(GraphicsContext gc);

	public abstract void keyBoardPressed(KeyEvent event);

	public abstract void keyBoardReleased(KeyEvent event);

	public void mouseClicked(MouseEvent event){
		
	}


}
