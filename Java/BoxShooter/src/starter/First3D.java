package starter;

import java.awt.MouseInfo;
import java.util.ArrayList;

import javafx.geometry.Point3D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;

public class First3D extends State{
	ArrayList<Shape3D> shapes = new ArrayList<>();
	Box box;
	
	@Override
	public void setup() {
		box = new Box(100, 100, 100);
		box.setTranslateX(300);
		box.setTranslateY(200);
		box.setTranslateZ(100);
		box.setRotationAxis(new Point3D(1, 1, 1.2));
		box.setMaterial(new PhongMaterial(Color.BLUE));
		View.add(box);
	}

	@Override
	public void tick() {
		box.setRotate(box.getRotate()+2);
		
		for(int i = shapes.size()-1; i >= 0; i--){
			shapes.get(i).toFront();
			shapes.get(i).setTranslateZ(shapes.get(i).getTranslateZ() + 5);
			shapes.get(i).setScaleX(30/shapes.get(i).getTranslateZ());
			shapes.get(i).setScaleY(30/shapes.get(i).getTranslateZ());
			
			if(shapes.get(i).getTranslateZ() > 200){
				View.remove(shapes.get(i));
				shapes.remove(i);
			}
			
		}
	}

	@Override
	public void render(GraphicsContext gc) {
		
	}

	@Override
	public void keyBoardPressed(KeyEvent event) {
		
	}

	@Override
	public void keyBoardReleased(KeyEvent event) {
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		Sphere bullet = new Sphere(10);
		bullet.setTranslateX(event.getSceneX());
		bullet.setTranslateY(event.getSceneY());
		bullet.setTranslateZ(10);
		bullet.setMaterial(new PhongMaterial(Color.RED));
		View.add(bullet);
		shapes.add(bullet);
		System.out.println(shapes.size());
		
	}
	
}
