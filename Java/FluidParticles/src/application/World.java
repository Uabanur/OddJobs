package application;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class World extends Scene {
	List<Particle> particles = new ArrayList<>();
	final static int BORDER_THICKNESS = 20, WIDTH = 800, HEIGHT = 600;
	static Text text;
	Group pop;

	public World(Pane root) {
		super(root, WIDTH, HEIGHT);

		pop = new Group();
		root.getChildren().add(pop);

		for (int i = 0; i < 1000; i++)
			particles.add(new Particle());
		pop.getChildren().addAll(particles);

		Rectangle[] borders = createBorders();
		pop.getChildren().addAll(borders);

		text = new Text("Repulsing");
		text.setFill(Color.RED);
		text.setFont(new Font(60));
		text.setTranslateX(WIDTH / 2 - text.getLayoutBounds().getWidth() / 2);
		text.setTranslateY(80);
		pop.getChildren().add(text);
		
		
		setOnMouseClicked(e -> {
			for (Particle particle : particles) {
				particle.flipForce();
			}
		});

		setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.SPACE) {

				for (Particle particle : particles) {
					particle.newVel();
				}

			}
		});

	}

	public void tick(Long now) {
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		for (Particle particle : particles) {
			particle.move();
			particle.addForce(new Point2D(mouse.getX() - Main.stage.getX(), mouse.getY() - Main.stage.getY() - 20));

		}
	}

	private Rectangle[] createBorders() {
		Rectangle[] borders = new Rectangle[4];

		borders[0] = new Rectangle(0, 0, getWidth(), BORDER_THICKNESS);
		borders[1] = new Rectangle(0, getHeight() - BORDER_THICKNESS, getWidth(), BORDER_THICKNESS);
		borders[2] = new Rectangle(0, 0, BORDER_THICKNESS, getHeight());
		borders[3] = new Rectangle(getWidth() - BORDER_THICKNESS, 0, BORDER_THICKNESS, getHeight());
		
		for(Rectangle border: borders){
			border.setFill(Color.LIGHTSEAGREEN);
		}

		return borders;
	}

}
