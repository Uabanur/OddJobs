package uabanur.firstgame.worlds;

import java.awt.Graphics;

import uabanur.firstgame.Handler;
import uabanur.firstgame.entities.EntityManager;
import uabanur.firstgame.entities.creatures.Player;
import uabanur.firstgame.entities.statics.Boy;
import uabanur.firstgame.entities.statics.House2;
import uabanur.firstgame.entities.statics.OldMan;
import uabanur.firstgame.entities.statics.Pistol;
import uabanur.firstgame.entities.statics.Tree;
import uabanur.firstgame.entities.statics.interactiveDoor;
import uabanur.firstgame.tiles.Tile;
import uabanur.firstgame.utils.Utils;

public class World {
	
			//width and height gives amount of tiles in the game map (from world1.txt)
		private Handler handler;
		private int width, height; 
		private int spawnX, spawnY;
		private int[][] tiles;
		
	
			//Entities
		private EntityManager entityManager;
	
	public World(Handler handler, int chooseWorld , String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 0, 0));
		
		loadWorld(path);
		
		if(chooseWorld == 1){
			addTrees(handler);
			addHouses(handler);
			addCitizens(handler);
			addPistol(handler);
		}
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

	}
	
	
		//Loads in world from path (world1.txt file)
	
	private void loadWorld(String path){
			String file = Utils.loadFileAsString(path);
			String[] tokens = file.split("\\s+");
			width = Utils.parseInt(tokens[0]);
			height = Utils.parseInt(tokens[1]);
			spawnX = Utils.parseInt(tokens[2]);
			spawnY = Utils.parseInt(tokens[3]);
		
			tiles = new int[width][height];
		
			//Converting string to numbers and inserting them in the tiles array (creating map)
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

		
	}
	

	public void tick(){
		entityManager.tick();
		
	}
	
	
	public void render(Graphics g){
		
			int xStart	= (int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
			int xEnd	= (int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH+1);
			int yStart	= (int) Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEWIDTH);
			int yEnd	= (int) Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGHT+1);
			
			//rendering the visible part of the world map
			
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x,y).render(g,(int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y* Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
			//Rendering entities ; putting in entities and also the player on top of the map
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if(t == null)
			return Tile.dirtTile;
		
		return t;
	}
	
	private void addTrees(Handler handler){
		for(int i = 0; i<3;i++)
		entityManager.addEntity(new Tree(handler, 280+100*i, 350));
		
		for(int i = 0; i<10; i++)
			entityManager.addEntity(new Tree(handler, 400+200*i, 20));
			
		for(int i = 0; i<12;i++)
			entityManager.addEntity(new Tree(handler, 850 + 100*i,450));
		
		for(int i = 0; i<12;i++)
			entityManager.addEntity(new Tree(handler, 850 + 100*i,550));
		
	}
	
	private void addHouses(Handler handler){
		entityManager.addEntity(new House2(handler, 2790, 70));
		entityManager.addEntity(new interactiveDoor(handler, 2790+102, 70+127));
	}
	
	private void addCitizens(Handler handler){
		entityManager.addEntity(new OldMan(handler, 2800, 250));
		entityManager.addEntity(new Boy(handler, 100, 100));
	}
	
	private void addPistol(Handler handler){
		entityManager.addEntity(new Pistol(handler, 800, 556));
	}
	
	//GETTERS AND SETTERS
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
}
