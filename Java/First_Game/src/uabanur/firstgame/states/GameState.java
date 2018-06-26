package uabanur.firstgame.states;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.Assets;
import uabanur.firstgame.worlds.World;

public class GameState extends State{


	public static World[] world;
	
	public static int chooseWorld =0;

	
	public GameState(Handler handler){
		super(handler);
		world = new World [2];
		world[0] = new World(handler, 1,  "res/worlds/world1.txt");
		world[1] = new World(handler, 2 , "res/worlds/insideHouse.txt");
		handler.setWorld(world[chooseWorld]);
	}
	
	@Override
	public void tick() {
		world[chooseWorld].tick();
		
			//If Back button is pushed, go to main menu
		backButton();
		checkInventory();
	}

	@Override
	public void render(Graphics g) {
	world[chooseWorld].render(g);
	
		//Creates back button
	g.drawImage(Assets.backButton,handler.getWidth()-100,0,100,50,null);
	}
	
	
	private void backButton(){
		if(	handler.getMouseManager().getMouseX() > handler.getWidth()-100 &&
				handler.getMouseManager().getMouseY() < 50 &&
				handler.getMouseManager().isLeftPressed())
				State.setState(handler.getGame().mainMenuState);
	}
	
	private void checkInventory(){
		if(handler.getKeyManager().i)
			State.setState(handler.getGame().inventoryState);
		
	}
	
	
}
