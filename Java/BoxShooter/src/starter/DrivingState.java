package starter;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrivingState extends State{

	static Rectangle car;
	
	private double angle, turnSpeed, speed;
	boolean left, right, driving, reversing;
	
	public void setup() {
		View.setFPS(60);
		angle = 0;
		speed = 5;
		turnSpeed = 3;
		left = false;
		right = false;
		driving = false;
		reversing = false;
		
		car = new Rectangle(View.CANVAS_WIDTH/2, View.CANVAS_HEIGHT-40, 10,30);
		car.setFill(Color.BLUE);
		car.setStroke(Color.BLACK);
		View.add(car);
	}

	public void tick() {
		
		
		
		if(driving){
			car.setX(car.getX()+Math.sin(angle/180*Math.PI)*speed);
			car.setY(car.getY()-Math.cos(angle/180*Math.PI)*speed);
		} else if (reversing){
			car.setX(car.getX()-Math.sin(angle/180*Math.PI)*speed*0.5);
			car.setY(car.getY()+Math.cos(angle/180*Math.PI)*speed*0.5);
		}
		
		if(driving){
			if(left)
				angle -= turnSpeed;
			if(right)
				angle += turnSpeed;
		} else if(reversing){
			if(left)
				angle += turnSpeed;
			if(right)
				angle -= turnSpeed;
		}
			
		
		angle = angle % 360;
		
		car.setRotate(angle);
		
		if(car.getX() < car.getHeight()/2){
			car.setX(car.getHeight()/2);
		}
		if(car.getX() > View.CANVAS_WIDTH - car.getHeight()){
			car.setX(View.CANVAS_WIDTH - car.getHeight());
		}
		if(car.getY() < car.getHeight()/2){
			car.setY(car.getHeight()/2);
		}
		if(car.getY() > View.CANVAS_HEIGHT - car.getHeight()){
			car.setY(View.CANVAS_HEIGHT - car.getHeight());
		}
		
	}
	
	public void render(GraphicsContext gc) {
		gc.setFill(Color.valueOf("#029d0f"));
		gc.fillRect(0, 0, View.CANVAS_WIDTH, View.CANVAS_HEIGHT);
		
		gc.setFill(Color.GRAY);
		gc.fillOval(50, 50, View.CANVAS_WIDTH-100, View.CANVAS_HEIGHT-100);
		
		gc.setFill(Color.valueOf("#029d0f"));
		gc.fillOval(150, 130, View.CANVAS_WIDTH-300, View.CANVAS_HEIGHT-260);
	}


	public void keyBoardPressed(KeyEvent event) {
		if(event.getCode() == KeyCode.A ){
			left = true;
		}
		if(event.getCode() == KeyCode.D){
			right= true;
		}
		if(event.getCode() == KeyCode.W){
			driving= true;
		}
		if(event.getCode() == KeyCode.S){
			reversing= true;
		}
		
		
	}

	public void keyBoardReleased(KeyEvent event) {
		if(event.getCode() == KeyCode.A){
			left = false;
		}
		if(event.getCode() == KeyCode.D){
			right= false;
		}
		if(event.getCode() == KeyCode.W){
			driving= false;
		}
		if(event.getCode() == KeyCode.S){
			reversing= false;
		}
	}

	public Rectangle getCar(){
		return car;
	}
	
}
