package starter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Shape3D;
import javafx.stage.Stage;

public class View extends Application {

	public static int CANVAS_WIDTH = 640, CANVAS_HEIGHT = 480;
	private static int fps = 60;
	private long lastFrame;
	private static Group centerLayout;
	private BorderPane mainLayout;
	private HBox topLayout;
	private static Scene scene;
	private Canvas canvas;
	
	private static State currentState = new DefaultState();

	public static void runGame(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Lets begin");
		mainLayout = new BorderPane();
		centerLayout = new Group();

		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		centerLayout.getChildren().add(canvas);

		setup();

		AnimationTimer animation = new AnimationTimer() {

			@Override
			public void handle(long now) {
				long currentTime = now;
				if (now >= lastFrame + 1e9 / fps) {
					tick();
					render(gc);
					lastFrame = now;
					canvas.setWidth(scene.getWidth());
					canvas.setHeight(scene.getHeight());
				}

			}

		};

		animation.start();

		mainLayout.setCenter(centerLayout);
		mainLayout.setTop(topLayout);
		scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void add(Shape shape) {
		centerLayout.getChildren().add(shape);
	}
	public static void add(Shape3D shape) {
		centerLayout.getChildren().add(shape);
	}
	public static void remove(Shape shape){
		centerLayout.getChildren().remove(shape);
	}
	public static void remove(Shape3D shape){
		centerLayout.getChildren().remove(shape);
	}

	private void setup() {

		lastFrame = System.nanoTime();

		currentState.setup();

	}

	private void tick() {

		scene.setOnKeyPressed(event -> currentState.keyBoardPressed(event));
		scene.setOnKeyReleased(event -> currentState.keyBoardReleased(event));
		mainLayout.setOnMouseClicked(event -> currentState.mouseClicked(event));

		currentState.tick();

	}

	private void render(GraphicsContext gc) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		currentState.render(gc);
	}

	// GETTERS AND SETTERS

	public static void setCurrentState(State newState) {
		currentState = newState;
	}
	
	public static void setFPS(int newfps){
		fps = newfps;
	}
	
	public static Scene getScene(){
		return scene;
	}
}
