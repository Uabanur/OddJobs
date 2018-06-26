package uabanur.firstgame;

import uabanur.firstgame.gfx.GameCamera;
import uabanur.firstgame.input.KeyManager;
import uabanur.firstgame.input.MouseManager;
import uabanur.firstgame.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	//Constructor
	public Handler(Game game){
		this.game = game;

	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
