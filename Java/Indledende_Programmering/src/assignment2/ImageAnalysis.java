package assignment2;

// s144063 Magnus Soeborg-Madsen 
// s144107 Roar Nind Steffensen

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class ImageAnalysis {
	// Fields
	private Scanner s;
	private int rows, columns;
	private double[][] image;

	// ####################################################
	// # CONSTRUCTOR
	// ####################################################
	//
	public ImageAnalysis(String filename) throws FileNotFoundException {
		// Setting locale to English, just in case
		s = new Scanner(new File(filename)).useLocale(Locale.ENGLISH);

		// Load first line containing number of rows and columns in the image.
		String line = s.nextLine();
		String[] tokens = line.split(" +");

		rows = Integer.parseInt(tokens[0]);

		columns = Integer.parseInt(tokens[1]);

		// Creating matrix with dimensions of given rows and columns,
		// with same size as input image.
		image = new double[rows][columns];

		// Scans and sanitizes the image pixel values.
		for (int n = 0; n < rows; n++) {

			// The image is scanned line by line (row by row).
			line = s.nextLine();

			// The line is split into an array of strings
			tokens = line.split(" +");

			// Each pixel element is parsed to a double, sanitized and stored in
			// the matrix
			for (int m = 0; m < columns; m++) {
				image[n][m] = sanitize(Double.parseDouble(tokens[m]));

			} //Ends loop storing in image
			
		}//Ends loop scanning line by line 
		
	}//Ends constructor
	
	// ####################################################
	// # METHODS
	// ####################################################
	//
	//Method for applying filter.
	public double[][] runFilter(String filterfilename) throws FileNotFoundException {
		
		// sets the scanner to read from the filterfilename path.
		s = new Scanner(new File(filterfilename)).useLocale(Locale.ENGLISH);
		
		//Scanning parameters as in the constructor.
		String line = s.nextLine();
		String[] tokens = line.split(" +");
		int k = Integer.parseInt(tokens[0]);

		//Initialize matrix for storing filter with requested size
		double[][] filter = new double[2 * k + 1][2 * k + 1];

		for (int n = 0; n < 2 * k + 1; n++) {
			line = s.nextLine();
			tokens = line.split(" +");

			for (int m = 0; m < 2 * k + 1; m++) {
				filter[n][m] = Double.parseDouble(tokens[m]);

			}// Ends loop storing in filter
		} // Ends loop scanning line by line

		//Initializes matrix for storing the filtered image
		double[][] filteredImage = new double[rows - 2 * k][columns - 2 * k];
		double sum = 0.0;
		
		//Going through all pixels in the image.
			//The assignment indexes from -k to k, but to simplify the process
			//we chose to index from 0 to 2*k inclusive. 
		for (int n = 0; n < rows - (2 * k); n++) {

			for (int m = 0; m < columns - (2 * k); m++) {
				
				//Applying filter to current pixel at Im(a,b).
				for (int j = 0; j < 2 * k + 1; j++) {
					for (int i = 0; i < 2 * k + 1; i++) {
						
						//Calculating the filtered pixel value FIm(a,b)
						sum += filter[i][j] * image[n + i][m + j];
						
					}//Ends calculating filter on current row of image
					
				}//Ends looping through rows of filter and image
				
				//Sanitizing filtered pixel and storing in the filtered image
				filteredImage[n][m] = sanitize(sum);
				
				//Resetting sum for filter calculations.
				sum = 0;
				
			}//Ends looping through pixels in current row of the image
			
		}//Ends looping through rows of the image.

		//Returning the filtered image
		return filteredImage;
	}

	//The sanitation method mentioned in the report. 
		//Maps the given pixel value to the interval [-1,1].
	private double sanitize(double pixel) {
		if (pixel > 1)
			return 1;
		else if (pixel < -1)
			return -1;
		else
			return pixel;
	}

}
