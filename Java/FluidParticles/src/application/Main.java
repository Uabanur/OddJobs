package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		try {
			BorderPane root = new BorderPane();
			World world = new World(root);
			world.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(world);
			stage.setAlwaysOnTop(true);
			stage.show();

			new AnimationTimer() {

				@Override
				public void handle(long now) {
					world.tick(now);

				}
			}.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
