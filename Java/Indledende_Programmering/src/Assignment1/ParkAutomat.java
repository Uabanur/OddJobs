package Assignment1;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class ParkAutomat {

	public static Random rand = new Random(53332274312L);
	public static DecimalFormat df2 = new DecimalFormat("00");

	public static String randomTime() {
		return df2.format(rand.nextInt(24)) + ":" + df2.format(rand.nextInt(60));
	}

	private static int time, timeCheck, coin;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		runAutomat(sc);
		
	}
	

	private static void runAutomat(Scanner sc) {
		String startingTime, Userinput;
		//Starting main loop for several users.
		mainLoop: while (true) {
			
			//Initializing new user.
			startingTime = randomTime();
			boolean canInsertCoin = true;
			coin = 0;

			//Calculating current minute.
			time = Character.getNumericValue(startingTime.charAt(3)) * 10 + Character.getNumericValue(startingTime.charAt(4))
					+ (Character.getNumericValue(startingTime.charAt(0)) * 10 + Character.getNumericValue(startingTime.charAt(1))) * 60;
			
			//Setting up reference time.
			timeCheck = time;
			
			//Starting inner loop with current user
			userloop: while (true) {
				
				//Printing information on screen
				printText(startingTime, canInsertCoin);

				//Getting user input
				Userinput = sc.nextLine();

				//Checking user input
				if (Userinput.charAt(0) == 'T') {
					System.out.println("Shutting down.");
					break mainLoop;
					
				} else if (Userinput.charAt(0) == 'C') {
					System.out.println("Operation cancelled. Money returned " + (time-timeCheck)/2 + " dkk.");
					System.out.println("=== Transaction completed ===");
					continue mainLoop;
					
				} else if (Userinput.charAt(0) == 'B') {
					System.out.println("Your ticket is printed. Thank you");
					System.out.println("=== Transaction completed ===");
					continue mainLoop;
					
				} else if(isNumeric(Userinput)){ //Checking if input is a number
					
					//If a number, save the given coin
					coin = Integer.parseInt(Userinput);
				} else {
					
					//If not a number, coin is set to invalid value
					coin = 0;
				}
					

				if (canInsertCoin) {	//As long as user can insert coins
					
					//Checking if coin is legal if not, go to next user loop iteration.
					if(coin != 20 && coin != 10 && coin != 5 && coin != 2 && coin != 1){
						System.out.println("Illegal coin, try again.");
						continue userloop;
						
						// if coin is legal, we check that it will not surpass the 2 hour limit.
					} else if(time + coin*2 < timeCheck + 120){
						
						time += coin*2;
					} else{
						
						//if coin surpasses the 2 hour limit set time as 2 hours and return the change. 
						System.out.println("Maximum Parking time reached. "+ ((time + coin*2)-(timeCheck+120))/2 +" dkk returned.");
						time = timeCheck + 120;
						
						//Stop user from inserting more coins.
						canInsertCoin=false;
					}

				} else
					System.out.println("Maximum Parking time reached.");
			}
		}
		
	}

	private static void printText(String startingTime, boolean canInsertCoin) {
		
		System.out.println("****************************");
		System.out.println(" The time is " + startingTime);

		showParkingTime();
		if(canInsertCoin)
			System.out.println(" Please insert Coins");
		
		System.out.println(" C - Cancel");
		System.out.println(" B - Buy");

		System.out.println("****************************");
		
	}

	private static void showParkingTime() {
		
		//Calculating hours and minutes from time variable. 
		//Checking that the time is shown with leading zeros if needed.
		System.out.print(" Parking time until ");
		if (time / 60 >= 10)
			System.out.print(time / 60 + ":");
		else
			System.out.print("0" + time / 60 + ":");
		
		if (time % 60 >= 10)
			System.out.println(time % 60);
		else
			System.out.println("0" + time % 60);
	}
	
	private static boolean isNumeric(String Userinput){
		//Checking if Userinput is an integer, returning a boolean.
		try{
			Integer.parseInt(Userinput);
			return true;
		} catch(NumberFormatException nfe){
			return false;
		}
	}
}
