package uabanur.firstgame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uabanur.firstgame.Handler;
import uabanur.firstgame.gfx.Animation;
import uabanur.firstgame.gfx.Assets;

public class Player extends Creatures{
	
	//Animation; walkingSpeed is how long it takes (ms) for the animation to take a step (not player-movement-speed)
	private Animation animDown, animUp, animRight, animLeft;
	private int walkingSpeed = 300; //[ms]
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);
			
			//Creates the rectangle of the player which controls collision
		bounds.x 		= 25;
		bounds.y		= 50;
		bounds.width	= 13;
		bounds.height	= 13;
		
		
		//Animations
		animDown = new Animation(walkingSpeed, Assets.player_down);
		animUp = new Animation(walkingSpeed, Assets.player_up);
		animLeft = new Animation(walkingSpeed, Assets.player_left);
		animRight = new Animation(walkingSpeed, Assets.player_right);
	}

	@Override
	public void tick() {
		spaceForSpeed();
		
		//Animation tick
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		//Movement tick
		getInput();
		move();
		
		// Centers camera on Player
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void spaceForSpeed() {
		if(handler.getGame().getKeyManager().space)
			speed = 30;
		else speed = DEFAULT_SPEED;
		
	}

	private void getInput(){
			//xMove and yMove is from [Creatures] and controls the direction and magnitude of the player
		xMove 	= 0;
		yMove 	= 0;
			
			//speed is from [Creatures] and controls player-movement-speed
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		if(handler.getKeyManager().right){
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		
		//Draws player with the chosen animation frame controlled by input
		g.drawImage(getCurrentAnimationFrame(), (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		
		
//	Shows the red rectangle controlling collisions with player
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//				bounds.width, bounds.height);
		
	}
	
	
	//GETTER
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if (yMove < 0){
			return animUp.getCurrentFrame();
		}else if(yMove > 0){
			return animDown.getCurrentFrame();
		}else {
			return Assets.player_still;
		}
		
		
	}

	
	
}
