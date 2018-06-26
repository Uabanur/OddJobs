package uabanur.helicopter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display implements KeyListener {

	public static Display display = new Display();

	public static void main(String args[]) {
		
		FileIO.getInput();
		setup();
		gameLoop();
		
	}

	public static int fpsCounter = 60;

	// public static Ball user;

	public static void gameLoop() {

		// user = new Ball();

		int fps = 60; // amount of frames pr second [#]
		double timePerTick = 1e9 / fps; // time per tick in seconds [s/#]
										// (computer is in nano)

		double delta = 0;
		long now;
		long lastTime = System.nanoTime(); // Getting the computers time in
											// nanoseconds
		long timer = 0;
		int ticks = 0;

		while (true) {
			now = System.nanoTime();
			delta += (now - lastTime); // Calculating time difference [s]
			timer += now - lastTime;
			lastTime = now;
			if (delta / timePerTick >= 1) { // Checking if time difference
											// equals time per tick
				tick();
				render();
				delta = 0; // reset the relative time difference to zero
				ticks++; // check how many ticks
			}

			if (timer >= 1e9) {
				// System.out.println("Fps: " + ticks); //Showing Fps in console
				fpsCounter = ticks;
				ticks = 0;
				timer = 0;
			}
		}
	}

	// Set up window

	private static JFrame frame;
	private static Canvas canvas;

	private static String title = "Jump'n'Gates Beta 1.3";
	static int width = 600;
	static int height = 400;

	public static Rectangle ground = new Rectangle(new Dimension(Display.width,
			20));

	public static State gameState = new GameState(),
			menuState = new MenuState(), 
			pauseState = new PauseState(),
			gameOverState = new GameOverState();

	private static void setup() {
		frame = new JFrame(title); // Making the frame for the window
		frame.setSize(width, height); // Setting the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminating
																// with x-button
		frame.setResizable(false);// Making the frame one true size
		frame.setLocationRelativeTo(null); // locating the frame in center
											// screen
		frame.setVisible(true); // Making the window visible.
		frame.addKeyListener(display);

		canvas = new Canvas(); // Creating a canvas for graphics
		canvas.setPreferredSize(new Dimension(width, height)); // All three are
																// to control
		canvas.setMaximumSize(new Dimension(width, height)); // the size of the
																// canvas
		canvas.setMinimumSize(new Dimension(width, height)); // to be equal our
																// frame
		canvas.setFocusable(false); // Making the application in focus (weird,
									// just do it)

		frame.add(canvas); // Putting the canvas in the frame
		frame.pack(); // Securing that the canvas is snug in the frame

		State.setState(menuState);

	}

	public static void tick() {
		State.currentState.tick();

		space = keys[KeyEvent.VK_SPACE];
		pButton = keys[KeyEvent.VK_P];

	}

	private static Graphics g;
	private static BufferStrategy bs;

	public static void render() {
		bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, width, height);

		setBackGround(g);

		State.currentState.render(g);

		// Draw here!

		// End drawing!

		bs.show(); // Making the buffers (pre screeners)
		g.dispose(); // Makes sure that graphics are done with properly.

	}

	private static void setBackGround(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, Display.width, Display.height);
		g.setColor(Color.white);
		g.fillOval(100, 30, 100, 60);
		g.fillOval(200, 30, 300, 150);
		g.fillOval(220, 20, 100, 60);
		g.fillOval(140, 100, 100, 60);
	}

	public static boolean[] keys = new boolean[256];
	public static boolean space, pButton, anyKey;

	@Override
	public void keyPressed(KeyEvent e) {
		Ball.upPressed(e);
		Ball.downPressed(e);
		
		anyKey = true;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		anyKey = false;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
