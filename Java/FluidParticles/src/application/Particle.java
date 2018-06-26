package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class Particle extends Circle {

	Point2D vel;
	boolean attractor;
	private static double drag = 0.05;

	public Particle() {
		Random r = new Random();

		setRadius(r.nextInt(20));
		setCenterX(r.nextInt(World.WIDTH - World.BORDER_THICKNESS * 2) + World.BORDER_THICKNESS);
		setCenterY(r.nextInt(World.HEIGHT - World.BORDER_THICKNESS * 2) + World.BORDER_THICKNESS);
		setFill(Color.LIGHTBLUE);
		setFill(Color.rgb(0, 10, 250, 0.2));
		vel = Point2D.ZERO;
		attractor = false;
		
	}

	public void move() {
		vel = vel.multiply(1-drag);
		setCenterX(getCenterX() + vel.getX());
		setCenterY(getCenterY() + vel.getY());

		if (getCenterX() < 0) {
			setCenterX(World.WIDTH);
		}
		if (getCenterX() > World.WIDTH) {
			setCenterX(0);
		}

		if (getCenterY() < 0) {
			setCenterY(World.HEIGHT);
		}
		if (getCenterY() > World.HEIGHT) {
			setCenterY(0);
		}
	}

	public void addForce(Point2D point) {

		Point2D dir = new Point2D(getCenterX() - point.getX(), getCenterY() - point.getY());
		double newMag = 30 / dir.magnitude();
		if (newMag > 1)
			newMag = 1;

		dir = dir.normalize();

		if (attractor) {
			dir = dir.multiply(newMag / 2);
			vel = vel.subtract(dir);
		} else {
			dir = dir.multiply(newMag);
			vel = vel.add(dir);
		}

	}

	public void flipForce() {
		attractor = !attractor;

		if (attractor) {
			World.text.setText("Attracting");
			World.text.setFill(Color.GREEN);
		} else {
			World.text.setText("Repulsing");
			World.text.setFill(Color.RED);
		}
	}

	public void newVel() {
		Point2D ran = new Point2D(Math.random() * 2 - 1, Math.random() * 2 - 1);
		ran = ran.multiply(Math.random() * 50);
		this.vel = ran;
	}
	
	public static void setDrag(double value){
		drag = value;
	}

}
