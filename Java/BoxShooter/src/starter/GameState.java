package starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameState extends State {

	Rectangle player;
	final int FLOOR_HEIGHT = 20, PLAYER_SIZE = 20;
	private double vel, acc, walkingSpeed, jumpHeight, tileSize;
	private boolean left, right, standing;
	private boolean [][] map;
	
	@Override
	public void setup() {
		
		tileSize = 20;
		walkingSpeed = 7;
		acc = 1;
		vel = 0;
		jumpHeight = 12;
		
		
		player = new Rectangle(View.CANVAS_WIDTH/2, 0, PLAYER_SIZE, PLAYER_SIZE);
		setupBackground();
		


	}

	@Override
	public void tick() {

		vel += acc;
		if(vel > 10)
			vel = 10;
		
		movePlayer();

		

	}

	@Override
	public void render(GraphicsContext gc) {
		drawBackground(gc);
		gc.setFill(Color.DARKBLUE);
		gc.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());

	}

	private void movePlayer(){
		player.setY(player.getY() + vel);
		standing = false;
		
		//Controlling the player, standing on tiles. Wow..
		for(int y = 0; y < map[0].length; y++ ){
			for(int x = 0; x < map.length;  x++){
				if(map[x][y] && (player.getX() + PLAYER_SIZE >= tileSize*x && player.getX() <= tileSize*(1+x))){
							//Check over tile
					if(player.getY()+PLAYER_SIZE < (y+1)*tileSize && player.getY() + PLAYER_SIZE >= tileSize*y){
//						System.out.println("Standing on tile!");
						player.setY(tileSize*(y)-PLAYER_SIZE);
						standing = true;
						vel = 0;
					} 
							//Check under tile
					else if(player.getY() < tileSize*(y+1) && player.getY() > tileSize*(y)){
//						System.out.println("Hit underside of tile!");
						player.setY(tileSize*(y+1));
//						System.out.println("Players y: " + player.getY() + " , corner of tile: " + tileSize*(y+1));
						standing = false;
						vel = 0;
					} 
					
				}
			}
		}
		
		
		if (left && player.getX() > 0)
			player.setX(player.getX()-walkingSpeed);

		if (player.getX() < 0)
			player.setX(0);

		if (right && player.getX() < View.CANVAS_WIDTH - PLAYER_SIZE)
			player.setX(player.getX()+walkingSpeed);

		
		if (player.getX() > View.CANVAS_WIDTH - PLAYER_SIZE)
			player.setX(View.CANVAS_WIDTH - PLAYER_SIZE);
		
	}
	
	@Override
	public void keyBoardPressed(KeyEvent event) {

			
		if (event.getCode() == KeyCode.W && standing) {
			vel = -jumpHeight;
		}
		if (event.getCode() == KeyCode.A) {
			left = true;
		}
		if (event.getCode() == KeyCode.D) {
			right = true;
		}

	}

	@Override
	public void keyBoardReleased(KeyEvent event) {

		if (event.getCode() == KeyCode.A) {
			left = false;
		}
		if (event.getCode() == KeyCode.D) {
			right = false;
		}

	}

	private void setupBackground(){

		map = new boolean[100][20];
		try {
			Scanner mapScanner = new Scanner(new File("src/starter/GameMap.txt"));
			
			for(int y = 0; y < map[0].length; y++){
				String line = mapScanner.nextLine();
				for(int x = 0; x < line.length(); x++){
					map[x][y] = line.charAt(x) == '1'? true: false;
				}
			}
			mapScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
		
	}
	
	private void drawBackground(GraphicsContext gc) {
		gc.setFill(Color.GRAY);
		
		for(int y = 0; y < map[0].length; y++){
			for(int x = 0; x < map.length; x++){
				if(map[x][y]){
					gc.fillRect(tileSize*x, tileSize*y, tileSize, tileSize);
				}
			}
		}
		
		

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
	


}
