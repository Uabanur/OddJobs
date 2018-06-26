package starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Snake extends State {
	Circle player, food;
	ArrayList<Circle> body;
	Rectangle upperBound, lowerBound, leftBound, rightBound;
	private int speed, playersize, bodysectionsize, points, maxpoints;
	private direction currentDir, lastDir;
	private boolean dead;

	public void setup() {
		View.setFPS(15);
		currentDir = direction.NONE;
		lastDir = direction.NONE;
		playersize = 10;
		bodysectionsize = playersize - 1;
		dead = false;
		speed = playersize * 2;

		player = new Circle(playersize, Color.YELLOW);
		player.setCenterX(View.CANVAS_WIDTH / 2 - player.getCenterX());
		player.setCenterY(View.CANVAS_HEIGHT / 2 - player.getCenterY());

		body = new ArrayList<Circle>();

		food = new Circle(playersize / 2, Color.RED);
		food.setCenterX(Math.random() * View.CANVAS_WIDTH);
		food.setCenterY(Math.random() * View.CANVAS_HEIGHT);
		View.add(player);
		View.add(food);

		upperBound = new Rectangle(0, 0, View.CANVAS_WIDTH, player.getRadius());
		upperBound.setFill(Color.GREEN);
		View.add(upperBound);
		lowerBound = new Rectangle(0, View.CANVAS_HEIGHT - player.getRadius(), View.CANVAS_WIDTH, player.getRadius());
		lowerBound.setFill(Color.GREEN);
		View.add(lowerBound);
		leftBound = new Rectangle(0, 0, player.getRadius(), View.CANVAS_HEIGHT);
		leftBound.setFill(Color.GREEN);
		View.add(leftBound);
		rightBound = new Rectangle(View.CANVAS_WIDTH - player.getRadius(), 0, player.getRadius(), View.CANVAS_HEIGHT);
		rightBound.setFill(Color.GREEN);
		View.add(rightBound);

	}

	public void tick() {
		if (!dead) {
			move();
		}

		if (player.intersects(food.getBoundsInLocal())) {
			body.add(new Circle(bodysectionsize, player.getFill()));
			placeFood();
			points++;
		}

		for (Circle c : body) {
			if (player.intersects(c.getBoundsInLocal())) {
				dead = true;
				player.setFill(Color.RED);
			}
		}

		if (points > maxpoints) {
			maxpoints = points;
		}
	}

	private void move() {

		for (int i = body.size() - 1; i >= 1; i--) {
			body.get(i).setCenterX(body.get(i - 1).getCenterX());
			body.get(i).setCenterY(body.get(i - 1).getCenterY());
		}

		if (!body.isEmpty()) {
			body.get(0).setCenterX(player.getCenterX());
			body.get(0).setCenterY(player.getCenterY());
		}

		switch (currentDir) {
		case LEFT:
			if (!player.intersects(leftBound.getBoundsInLocal()))
				player.setCenterX(player.getCenterX() - speed);
			break;
		case RIGHT:
			if (!player.intersects(rightBound.getBoundsInLocal()))
				player.setCenterX(player.getCenterX() + speed);
			break;
		case UP:
			if (!player.intersects(upperBound.getBoundsInLocal()))
				player.setCenterY(player.getCenterY() - speed);
			break;
		case DOWN:
			if (!player.intersects(lowerBound.getBoundsInLocal()))
				player.setCenterY(player.getCenterY() + speed);
			break;
		default:
			break;
		}
		lastDir = currentDir;
	}

	private void placeFood() {
		boolean check = false;
		food.setCenterX(Math.random() * (View.CANVAS_WIDTH - food.getRadius() * 4) + food.getRadius() * 2);
		food.setCenterY(Math.random() * (View.CANVAS_HEIGHT - food.getRadius() * 4) + food.getRadius() * 2);

		if (food.intersects(player.getBoundsInLocal()))
			check = true;

		for (Circle c : body)
			if (food.intersects(c.getBoundsInLocal()))
				check = true;

		if (food.intersects(leftBound.getBoundsInLocal()))
			check = true;
		if (food.intersects(rightBound.getBoundsInLocal()))
			check = true;
		if (food.intersects(upperBound.getBoundsInLocal()))
			check = true;
		if (food.intersects(lowerBound.getBoundsInLocal()))
			check = true;

		if (check)
			placeFood();
	}

	private void reset() {
		body.clear();
		player.setFill(Color.YELLOW);
		player.setCenterX(View.CANVAS_WIDTH / 2);
		player.setCenterY(View.CANVAS_HEIGHT / 2);
		currentDir = direction.NONE;
		placeFood();
		points = 0;
		dead = false;
	}

	public void render(GraphicsContext gc) {
		setBackground(gc);

		for (int i = 0; i < body.size(); i++) {
			gc.setFill(body.get(i).getFill());
			gc.fillOval(body.get(i).getCenterX() - player.getRadius(), body.get(i).getCenterY() - player.getRadius(), playersize * 2, playersize * 2);
			// gc.fillText(1+i + "", body.get(i).getCenterX() -
			// body.get(i).getRadius(), body.get(i).getCenterY() -
			// body.get(i).getRadius());

			// gc.fillOval(i*playerSize*2, 100, body.get(i).getRadius() * 2,
			// body.get(i).getRadius() * 2);
		}

		gc.setFill(Color.WHITE);
		gc.fillText("Points: " + points, 40, 40);
		gc.fillText("Max Points: " + maxpoints, 40, 60);

		if (dead) {
			gc.setFont(Font.font(70));
			gc.fillText("DEAD", View.CANVAS_WIDTH / 2 - 90, View.CANVAS_HEIGHT / 2 - 20);
			gc.setFont(Font.font(40));
			gc.fillText("SPACE TO RESET", View.CANVAS_WIDTH / 2 - 165, View.CANVAS_HEIGHT / 2 + 50);
			gc.setFont(Font.getDefault());
		}

	}

	public void keyBoardPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.W && lastDir != direction.DOWN) {
			currentDir = direction.UP;
		}
		if (event.getCode() == KeyCode.A && lastDir != direction.RIGHT) {
			currentDir = direction.LEFT;
		}
		if (event.getCode() == KeyCode.D && lastDir != direction.LEFT) {
			currentDir = direction.RIGHT;
		}
		if (event.getCode() == KeyCode.S && lastDir != direction.UP) {
			currentDir = direction.DOWN;
		}
		if (event.getCode() == KeyCode.SPACE && dead) {
			reset();
		}
		
	}

	public void keyBoardReleased(KeyEvent event) {

	}

	private void setBackground(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, View.CANVAS_WIDTH, View.CANVAS_HEIGHT);

	}

	private enum direction {
		LEFT, RIGHT, UP, DOWN, NONE;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
