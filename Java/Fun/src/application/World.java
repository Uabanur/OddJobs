package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;
import javafx.util.Duration;

public class World extends Scene {
	static Group root = new Group();

	Box floor;
	ArrayList<Cube> cubes = new ArrayList<>();
	ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Shape3D> shapes = new ArrayList<>();

	float bulletSpeed = 20, walkingSpeed = 5, turnSpeed = 1.5f;
	double angle = 0;
	PointLight light;

	boolean right = false, left = false, forward = false, 
			backward = false, turnRight = false, turnLeft = false;
	
	double mouseX = 0;
	Comparator<? super Shape3D> comparatorBoxes;

	public World() {
		super(root, 1200, 800);
	}

	public void setup() {
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setTranslateZ(-1000);
		camera.setTranslateX(Main.stage.getWidth() / 2);
		camera.setTranslateY(-40);
		camera.setNearClip(0.1);
		camera.setFarClip(2000.0);
		camera.setFieldOfView(40);
		camera.setRotationAxis(new Point3D(0, 1, 0));
		setCamera(camera);

		floor = new Box(2000, 10, 2000);
		floor.setTranslateX(0);
		floor.setTranslateZ(0);
		floor.setMaterial(new PhongMaterial(Color.LIGHTGRAY));
		floor.setTranslateY(0);
		root.getChildren().add(floor);


		light = new PointLight();
		root.getChildren().add(light);

		listeners();

		setFill(Color.ANTIQUEWHITE);
		for (double z = 200 - floor.getDepth() / 2; z < floor.getDepth() / 2; z += 300)
			for (double x = 200 - floor.getWidth() / 2; x < floor.getWidth() / 2; x += 300) {
				Cube box = new Cube(floor.getTranslateX() + x, floor.getTranslateZ() + z, 100);
				cubes.add(box);
				root.getChildren().add(box);
			}

		comparatorBoxes = new Comparator<Shape3D>() {
			public int compare(Shape3D s1, Shape3D s2) {

				Point3D camera = new Point3D(getCamera().getTranslateX(), getCamera().getTranslateY(), getCamera().getTranslateZ());
				Point3D shape1 = new Point3D(s1.getTranslateX(), s1.getTranslateY(), s1.getTranslateZ());
				Point3D shape2 = new Point3D(s2.getTranslateX(), s2.getTranslateY(), s2.getTranslateZ());

				return (int) (camera.distance(shape2) - camera.distance(shape1));
			}
		};

	}

	public void tick() {
		
		light.setTranslateX(getCamera().getTranslateX());
		light.setTranslateZ(getCamera().getTranslateZ());
		light.setTranslateY(getCamera().getTranslateY());

		moveCamera();

		shapes.clear();
		shapes.addAll(bullets);
		shapes.addAll(cubes);
		Collections.sort(shapes, comparatorBoxes);

		root.getChildren().clear();
		root.getChildren().add(floor);
		root.getChildren().addAll(shapes);

		for (int i = bullets.size() - 1; i >= 0; i--) {
			bullets.get(i).tick();

			Point3D camera = new Point3D(getCamera().getTranslateX(), getCamera().getTranslateY(), getCamera().getTranslateZ());
			Point3D bullet = new Point3D(bullets.get(i).getTranslateX(), bullets.get(i).getTranslateY(), bullets.get(i).getTranslateZ());

			if (camera.distance(bullet) > 2000) {
				bullets.remove(i);
				continue;
			}

			for (int j = cubes.size()-1; j >= 0; j--) {
				if (cubes.get(j).getBoundsInParent().intersects(bullets.get(i).getBoundsInParent())) {
					
					ScaleTransition stCube = new ScaleTransition();
					stCube.setNode(cubes.get(j));
					stCube.setDuration(Duration.millis(100));
					stCube.setToX(0);
					stCube.setToY(0);
					stCube.setToZ(0);
					stCube.play();
					stCube.setOnFinished(event -> {
						cubes.remove(stCube.getNode());
					});
					
					ScaleTransition stBullet = new ScaleTransition();
					stBullet.setNode(bullets.get(i));
					stBullet.setDuration(Duration.millis(80));
					stBullet.setToX(20);
					stBullet.setToY(20);
					stBullet.setToZ(20);

					stBullet.play();

					stBullet.setOnFinished(event -> {
						bullets.remove(stBullet.getNode());
					});

					break;
				}
			}

		}

	}

	void listeners() {

		setOnKeyPressed(key -> {

			if (key.getCode() == KeyCode.A) {
				left = true;
			}

			if (key.getCode() == KeyCode.D) {
				right = true;
			}

			if (key.getCode() == KeyCode.W) {
				forward = true;

			}

			if (key.getCode() == KeyCode.S) {
				backward = true;

			}

			if (key.getCode() == KeyCode.LEFT) {
				turnLeft = true;
			}

			if (key.getCode() == KeyCode.RIGHT) {
				turnRight = true;
			}
		});

		setOnKeyReleased(key -> {

			if (key.getCode() == KeyCode.A) {
				left = false;
			}

			if (key.getCode() == KeyCode.D) {
				right = false;
			}

			if (key.getCode() == KeyCode.W) {
				forward = false;
			}

			if (key.getCode() == KeyCode.S) {
				backward = false;
			}

			if (key.getCode() == KeyCode.LEFT) {
				turnLeft = false;
			}

			if (key.getCode() == KeyCode.RIGHT) {
				turnRight = false;
			}

			if (key.getCode() == KeyCode.SPACE) {
				shoot();
			}

		});

	}

	void shoot() {
		Bullet bullet = new Bullet(getCamera().getTranslateX(), getCamera().getTranslateZ(), angle);
		bullets.add(bullet);
		root.getChildren().add(bullet);

	}

	void moveCamera() {
		Camera camera = getCamera();

		if (turnLeft) {
			angle -= turnSpeed;
		}

		if (turnRight) {
			angle += turnSpeed;
		}

		if (forward) {
				camera.setTranslateZ(camera.getTranslateZ() + walkingSpeed * Math.cos(angle * Math.PI / 180));
				camera.setTranslateX(camera.getTranslateX() + walkingSpeed * Math.sin(angle * Math.PI / 180));
		}

		if (backward) {
				camera.setTranslateZ(camera.getTranslateZ() - walkingSpeed * Math.cos(angle * Math.PI / 180));
				camera.setTranslateX(camera.getTranslateX() - walkingSpeed * Math.sin(angle * Math.PI / 180));
		}

		if (right) {
				camera.setTranslateZ(camera.getTranslateZ() - 0.67 * walkingSpeed * Math.sin(angle * Math.PI / 180));
				camera.setTranslateX(camera.getTranslateX() + 0.67 * walkingSpeed * Math.cos(angle * Math.PI / 180));
		}

		if (left) {
				camera.setTranslateZ(camera.getTranslateZ() + 0.67 * walkingSpeed * Math.sin(angle * Math.PI / 180));
				camera.setTranslateX(camera.getTranslateX() - 0.67 * walkingSpeed * Math.cos(angle * Math.PI / 180));
		}

		camera.setRotate(angle);

		if (angle < 0) {
			angle = 359;
		} else if (angle >= 360) {
			angle = 0;
		}

	}

}
