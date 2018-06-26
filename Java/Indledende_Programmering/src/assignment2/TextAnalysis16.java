package assignment2;

// s144063 Magnus Soeborg-Madsen 
// s144107 Roar Nind Steffensen

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextAnalysis16 {
	
	// used to store all words
	private String[] tokens;
	
	// number of words in text (or rather: length of string array tokens)
	private int wordCounter;

	// We did not use the parameter maxNoOfWords.

	// ####################################################
	// # CONSTRUCTOR
	// ####################################################
	//
	public TextAnalysis16(String sourceFileName, int maxNoOfWords) {

		String fileName = sourceFileName;

		// scans entire text into string txtFull
		Scanner s;
		try {
			// the delimeter \\Z means 'end of input'
			// i.e. it scans until the end of the txt file
			// and stores everything the string s
			
			s = new Scanner(new File(fileName));
			s.useDelimiter("\\Z");

			String txtFull = s.next();
			
			// close scanner to make Eclipse happy
			s.close();
			
			// System.out.println(txtFull);
			this.tokens = txtFull.split("[^a-zA-Z]+");

			// word count
			this.wordCounter = tokens.length;

		} catch (FileNotFoundException e1) {
			System.out.println("File not found :-(");
			e1.printStackTrace();
		}

	} // ends constructor

	// ####################################################
	// # METHODS
	// ####################################################
	//
	public int wordCount() {
		// returns the number of words in the file
		return this.wordCounter;
	} // ends method wordCount

	public int frequency(String word) {

		int freqCounter = 0;
		for (int i = 0; i < wordCounter; i++) {

			if (tokens[i].equals(word)) {
				freqCounter++;

			} // ends if
		} // ends for

		return freqCounter;
	} // ends method contains

	public boolean contains(String word1, String word2) {

		boolean checker = false;

		for (int i = 0; i < (wordCounter - 1); i++) {

			// this method is case insensitive

			// if the current word is word1,
			if (tokens[i].equalsIgnoreCase(word1)) {

				// and next word is word 2
				if (tokens[i+1].equalsIgnoreCase(word2)) {

					checker = true;
					
					if(checker) {
						// if a match has been found, stop looking for more matches
						break;
					}

				} // ends if for next word
			} // ends if for current word
		} // ends for

		return checker;
	} // ends method contains

}
