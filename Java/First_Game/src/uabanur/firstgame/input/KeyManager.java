package uabanur.firstgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right, space, i, esc, enter;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	 public void tick(){
		 up = keys[KeyEvent.VK_W];
		 down = keys[KeyEvent.VK_S];
		 left = keys[KeyEvent.VK_A];
		 right = keys[KeyEvent.VK_D];
		 space = keys[KeyEvent.VK_SPACE];
		 i = keys[KeyEvent.VK_I];
		 esc = keys[KeyEvent.VK_ESCAPE];
		 enter = keys[KeyEvent.VK_ENTER];
		 
	 }
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}
	
	
}
