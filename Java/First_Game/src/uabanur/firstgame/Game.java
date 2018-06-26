package uabanur.firstgame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import uabanur.firstgame.display.Display;
import uabanur.firstgame.gfx.Assets;
import uabanur.firstgame.gfx.GameCamera;
import uabanur.firstgame.input.KeyManager;
import uabanur.firstgame.input.MouseManager;
import uabanur.firstgame.states.Citizen1Talk;
import uabanur.firstgame.states.Citizen2Talk;
import uabanur.firstgame.states.GameState;
import uabanur.firstgame.states.InventoryState;
import uabanur.firstgame.states.MainMenuState;
import uabanur.firstgame.states.State;
import uabanur.firstgame.states.WinState;

public class Game implements Runnable{

		private Display display;
		private int width, height;
		public String title;
		
		private boolean running = false;
		
		private Thread thread;
		
		private BufferStrategy bs;
		private Graphics g;
		
		
		//States
		public State gameState;
		public State mainMenuState;
		public State citizen2Talk;
		public State citizen1Talk;
		public State inventoryState;
		public State winState;
	
		//Input
		private KeyManager keyManager;
		private MouseManager mouseManager;
		
		//Camera
		private GameCamera gameCamera;
		
		//Handler 
		private Handler handler;
		
	
	
	//Constructor
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	
		//Starts the game, called from launcher. Automatically calls run();
	public synchronized void start(){
		if(running) 		//Securing that start() only runs 
			return;			//if running = false (not running twice)
			
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}


	//Initializes game.

	private void init(){ 
//		Music.play();
		display = new Display(title, width, height);
		
		//keyboard initialization
		display.getFrame().addKeyListener(keyManager);
		
		//mouse initialization
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		// Initializes assets (all tiles, entities and creatures)
		Assets.init();
		
		// Sets up a handler for sharing values and objects
		handler = new Handler(this);
		
		// Sets up the game camera to control camera movement in game.
		gameCamera = new GameCamera(handler, 0,0);
		
		
		//Setup game states
		gameState = new GameState(handler);
		mainMenuState 	= new MainMenuState(handler);
		citizen2Talk 	= new Citizen2Talk(handler);
		citizen1Talk 	= new Citizen1Talk(handler);
		inventoryState 	= new InventoryState(handler);
		winState 		= new WinState(handler);
		State.setState(mainMenuState); 
	}
	
	
		//handles the update of variables and objects
	private void tick(){ 
			keyManager.tick();
			if(State.getState() != null){
				State.getState().tick();
			}
		}
	
	
	
	private void render(){ // prints new positions an graphics on screen
		
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs==null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);	// Clear screen
		
		
		if(State.getState() != null){	
			State.getState().render(g); //Controlling render of current state
		}
		
		
		// Draw here! 
		
		

		
		// End drawing! 

		bs.show();		// Making the buffers (pre screeners)
		g.dispose();	// Makes sure that graphics are done with properly. 
	}
	
	public void run(){
		init();
	
			int fps = 60; // amount of frames pr second [#]
			double timePerTick = 1e9/fps; // time per tick in seconds [s/#] (computer is in nano)
			
			double delta = 0; 
			long now;
			long lastTime = System.nanoTime(); //Getting the computers time in nanoseconds
			long timer = 0;
			int ticks = 0;
	
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime); //Calculating time difference [s]
			timer += now - lastTime;
			lastTime = now; 
			
			if(delta/timePerTick >= 1){ //Checking if time difference equals time per tick
			tick();
			render();
			delta = 0; // reset the relative time difference to zero
			ticks++; // check how many ticks
			}
			
			if(timer >= 1e9){
				System.out.println("Fps: " + ticks); //Showing Fps in console
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
	return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	
	public int getWidth() {	
		return width;
	}

	public int getHeight() {
		return height;
	}


	
	public synchronized void stop(){
		if(!running) 	//Securing that start() only runs 
						//if running = true (not stopping twice)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
