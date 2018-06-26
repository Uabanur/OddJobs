package uabanur.spaceInvader;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import uabanur.spaceInvader.input.KeyManager;
import uabanur.spaceInvader.states.GameState;
import uabanur.spaceInvader.states.MenuState;
import uabanur.spaceInvader.states.State;
import uabanur.spaceInvader.states.WaveState;
import uabanur.spaceInvader.states.WelcomeState;

public class Display {
	


	public static void main (String[] args) {
		
		setup();
		gameLoop();
		
		
		
		
	}

	public static int fpsCounter = 60;


	public static KeyManager keyManager = new KeyManager();

	public static void gameLoop() {

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

	private static String title = "SpaceInvader 1.0";
	public static int width = 600;
	public static int height = 600;
	public static int backgroundX = 0, backgroundY = 0;
	
	public static State welcomeState = new WelcomeState(),
			gameState = new GameState(),
			menuState = new MenuState(),
			waveState = new WaveState();

	private static void setup() {
		frame = new JFrame(title); // Making the frame for the window
		frame.setSize(width, height); // Setting the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminating
																// with x-button
		frame.setResizable(false);// Making the frame one true size
		frame.setLocationRelativeTo(null); // locating the frame in center
											// screen
		frame.setVisible(true); // Making the window visible.
		frame.addKeyListener(keyManager);

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
		
		State.setState(welcomeState);

	}

	// public static EntityManager entityManager = new EntityManager();


	public static void tick() {
		keyManager.tick();
		State.currentState.tick();

		// entityManager.tick();

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

		setBackground();

		// Draw here!

		// entityManager.render(g);

		State.currentState.render(g);

		// End drawing!

		bs.show(); // Making the buffers
		g.dispose(); // Makes sure that graphics are done with properly.

	}

	private static void setBackground() {

		g.setColor(Color.blue);
		g.fillRect(width / 2 - 200 + backgroundX, 0 + backgroundY, 400, height);
		g.setColor(Color.green.darker());
		g.fillRect(0 + backgroundX, 0 + backgroundY, width/2 - 200, height);
		g.fillRect(width - 100 + backgroundX, 0 + backgroundY, width/2 - 200, height);
		

	}

}
