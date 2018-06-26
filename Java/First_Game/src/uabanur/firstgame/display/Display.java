package uabanur.firstgame.display;

import java.awt.Canvas;		// Canvas to paint/put graphics on
import java.awt.Dimension; 	// Used to give canvas a size

import javax.swing.JFrame;	// Window Frame to put canvas in

public class Display {

		
		private JFrame frame;
		private Canvas canvas;
		
		//Values  /Game/Launcher
		private String title;
		private int width, height;
	
	
	
		//Constructor	
	
	public Display(String title, int width, int height){
		
		this.title = title;
		this.width = width;
		this.height = height;
		
				
		createDisplay();
	}
	

		//Sets up the Frame and Canvas 
	private void createDisplay(){
		
		frame = new JFrame(title); //Making the frame for the window
		frame.setSize(width,height); // Setting the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminating with x-button
		frame.setResizable(false);// Making the frame one true size
		frame.setLocationRelativeTo(null); //locating the frame in center screen
		frame.setVisible(true); //Making the window visible.
		
		canvas = new Canvas(); 				//Creating a canvas for graphics
		canvas.setPreferredSize(new Dimension(width, height)); 	//All three are to control 
		canvas.setMaximumSize(new Dimension(width, height));  	//the size of the canvas
		canvas.setMinimumSize(new Dimension(width, height));   	//to be equal our frame
		canvas.setFocusable(false); // Making the application in focus (weird, just do it)
		
		frame.add(canvas); //Putting the canvas in the frame
		frame.pack();      //Securing that the canvas is snug in the frame
	}
	


	// GETTERS AND SETTERS
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	
}
