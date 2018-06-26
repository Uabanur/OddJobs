package application;


import com.sun.javafx.sg.prism.NGNode;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

@SuppressWarnings("restriction")
public class Bullet extends Sphere{

	double x, z, angle, speed = 20;

	Bullet(double x_, double z_, double angle_) {
		x = x_;
		z = z_;
		angle = angle_;

		setTranslateX(x);
		setTranslateZ(z);
		setTranslateY(-20);
		setRadius(8);
		setMaterial(new PhongMaterial(Color.RED));
		
	}
	
	void tick(){
		
		setTranslateZ(getTranslateZ() + speed * Math.cos(angle * Math.PI / 180));
		setTranslateX(getTranslateX() + speed * Math.sin(angle * Math.PI / 180));
		
	}

	
}
