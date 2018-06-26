package uabanur.spaceInvader.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	public boolean[] keys;
	public boolean up, down, left, right, space, i, esc, enter, one, two, three, four, five, six, seven, eight, nine, zero, p, s, l, r, anyKey;

	public KeyManager() {
		keys = new boolean[256];

	}

	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		i = keys[KeyEvent.VK_I];
		esc = keys[KeyEvent.VK_ESCAPE];
		enter = keys[KeyEvent.VK_ENTER];
		one = keys[KeyEvent.VK_1];
		two = keys[KeyEvent.VK_2];
		three = keys[KeyEvent.VK_3];
		four = keys[KeyEvent.VK_4];
		five = keys[KeyEvent.VK_5];
		six = keys[KeyEvent.VK_6];
		seven = keys[KeyEvent.VK_7];
		eight = keys[KeyEvent.VK_8];
		nine = keys[KeyEvent.VK_9];
		zero = keys[KeyEvent.VK_0];
		p = keys[KeyEvent.VK_P];
		s = keys[KeyEvent.VK_S];
		l = keys[KeyEvent.VK_L];
		r = keys[KeyEvent.VK_R];
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		anyKey = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		anyKey = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
