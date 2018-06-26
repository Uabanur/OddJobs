package application;

import java.util.Random;

import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Cube extends Box {
	
	double dx, dy, dr, size;
	
	public Cube(double x, double z, double size) {
		this.size = size;
		setWidth(size);
		setHeight(size);
		setDepth(size);
		setTranslateX(x);
		setTranslateZ(z);
		setTranslateY(-getHeight()/2);
		setMaterial(new PhongMaterial(Color.BLUE));
		
		setRotationAxis(new Point3D(Math.random(), Math.random(), Math.random()));
		dr = Math.random()*6-3;
		dx = Math.random()*2-1;
		dy = Math.random()*2-1;

	}
	
	void tick(){
		
		setRotate(getRotate() + dr);
		setTranslateX(getTranslateX() + dx);
		setTranslateY(getTranslateY() + dy);
		
		if(getTranslateX() < -getWidth()){
			setTranslateX(Main.stage.getWidth()+getWidth());
		} else if(getTranslateX() >= Main.stage.getWidth() + getWidth() ){
			setTranslateX(-getWidth());
		} else if(getTranslateY() < -getHeight()){
			setTranslateY(Main.stage.getHeight()+getHeight());
		} else if(getTranslateY() >= Main.stage.getHeight() + getHeight() ){
			setTranslateY(-getHeight());
		}

	}
	
	
	Cube impact(){
		
		
		Cube boxes = new Cube(getTranslateX(), getTranslateY(), size*0.67);
		
		return boxes;
		
	}

	
}
