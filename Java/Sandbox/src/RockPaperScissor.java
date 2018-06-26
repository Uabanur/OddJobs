import java.util.Scanner;


public class RockPaperScissor {

	private static int[] score = {0,0};
	private static String computerChoice, userChoice;
	private static boolean running = true;

	public static void main(String[] args){
		
		Scanner console = new Scanner(System.in);
		
		intro();
		
		while(running){
			
			computerChoice = getCounter(1); // 1: random, 2: strategy, else: rock
			userChoice = getInput(console);

			
			battle(userChoice, computerChoice);
			System.out.println("The score is " + score[0] + " - " + score[1]);
			running = goAgain(console);
			
			if(running){
				System.out.println("Choose your weapon!:");
			} else {
				System.out.println("Very well then, mighty fine joust, yes indeed!");
			}
		}
	}
	
	
	private static void intro(){
		System.out.println("Hello my fellow matey.");
		System.out.println("I wish to play the game of rocks, papers and scissors with the!");
		System.out.println("Please choose your move (rock, paper or scissor) and we will battle:");
	}

	private static String getInput(Scanner console){
		String userChoice = console.nextLine();
		if(!(userChoice.toLowerCase().equals("rock") 
				|| userChoice.toLowerCase().equals("paper")
				|| userChoice.toLowerCase().equals("scissor"))){
			System.out.println("Couldn't quite follow you with \"" + userChoice + "\"\nPlease choose one of \"rock\", \"paper\" and \"scissors\"");
			userChoice = getInput(console);
		}
		
		return userChoice;
	}
	
	private static String getCounter(int i){
		if(i == 1){
			return computerChoice();
		} else if(i == 2){
			return computerChoiceStrategy();
		} else return "rock";
	}
	
	private static String computerChoice(){
		String counter;
		
			int chooser = (int) (Math.random()*3+1);
			
			if(chooser == 1){
				counter = "rock";
			}else if(chooser == 2){
				counter = "paper";
			}else{
				counter = "scissor";
			}
		
		return counter;
	}
	
	private static String computerChoiceStrategy(){
		String counter;
		
		if(score[0] == 0 && score[1] == 0){
			int chooser = (int) (Math.random()*3+1);
			
			if(chooser == 1){
				counter = "rock";
			}else if(chooser == 2){
				counter = "paper";
			}else{
				counter = "scissor";
			}
		} else {
			if(userChoice.equals("rock")){
				counter = "scissor";
			} else if(userChoice.equals("paper")){
				counter = "rock";
			} else{
				counter = "paper";
			}
		}
		
		return counter;
	}
	
	
	private static void battle(String userChoice, 
			String computerChoice){
		
		System.out.println("You have chosen " + userChoice + " and i chose " + computerChoice);
		
		if((userChoice.equals("rock") && computerChoice.equals("scissor")) 
				|| (userChoice.equals("paper") && computerChoice.equals("rock")) 
				|| (userChoice.equals("scissor") && computerChoice.equals("paper"))){
			userWin();
		} else if (userChoice.equals(computerChoice)){
			userTie();
		} else {
			userLose();
		}
		
	}
	
	private static void userWin(){
		System.out.println("Good gracious my friend.\nI believe you have beaten me.\n");
		score[0]++;
	}
	
	private static void userTie(){
		System.out.println("Seems like we tied. Darn.\n");
	}
	
	private static void userLose(){
		System.out.println("Ooh donkey. The old man still got it!\nNo hard feelings i hope.\n");
		score[1]++;
	}
	
	private static boolean goAgain(Scanner console){
		System.out.println("Do you wish to play again? (y/n or yes/no)");
		String choice = console.nextLine();
		if(choice.toLowerCase().equals("yes") || choice.toLowerCase().equals("y")){
			return true;
		} else if(choice.toLowerCase().equals("no") || choice.toLowerCase().equals("n")){
			return false;
		} else {
			System.out.println("\nSorry could not understand.");
			return goAgain(console);
		}
		
	}
	

}
