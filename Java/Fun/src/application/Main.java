package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	World world;
	static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			stage.setWidth(640);
			stage.setHeight(480);
			world = new World();
			world.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			world.setup();
			
			new AnimationTimer(){

				@Override
				public void handle(long now) {
					tick();
				}
				
			}.start();
			
			stage.setScene(world);
			stage.sizeToScene();
			stage.show();
			stage.centerOnScreen();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	void tick(){
		
		world.tick();
		
	}
}
