package uabanur.spaceInvader.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import uabanur.spaceInvader.Display;
import uabanur.spaceInvader.states.GameState;
import uabanur.spaceInvader.states.State;
import uabanur.spaceInvader.states.WaveState;

public class FileIO {
	private static File file = new File("res/files/file.txt");
	
	public static void getInput(){
		
		GameState.entityManager.entities.clear();
		GameState.entityManager.gold.clear();
		
		try {
			Scanner input = new Scanner(file);
			
			input.next();
			GameState.entityManager.player.gold = input.nextInt();
			input.next();
			GameState.entityManager.player.goldCollectDistance = input.nextInt();
			input.next();
			GameState.entityManager.player.goldCollectSpeed = input.nextInt();
			input.next();
			GameState.entityManager.player.damage = input.nextInt();
			input.next();
			GameState.entityManager.player.exp = input.nextInt();
			input.next();
			GameState.entityManager.player.level = input.nextInt();
			input.next();
			GameState.entityManager.player.deaths = input.nextInt();
			input.next();
			GameState.entityManager.player.fullHealth = input.nextInt();
			input.next();
			WaveState.waveNumber = input.nextInt();
			input.next();
			WaveState.waveEnemyNumber = input.nextInt();
			input.next();
			WaveState.waveEnemySpawnTime = input.nextInt();
			input.next();
			GameState.score = input.nextInt();
			input.next();
			GameState.enemyCount = input.nextInt();
			input.next();
			GameState.enemySpawned = input.nextInt();
			input.next();
			GameState.entityManager.enemyCounter = input.nextInt();
			
			State.setState(Display.waveState);
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not load file");
		}
		System.out.println("Loaded!");
		
	}
	
	
	
	public static void setOutput(){
		
		try {
			PrintStream output = new PrintStream(file);
			//From Player
			output.println("Gold: " + GameState.entityManager.player.gold);
			output.println("GoldCollectDistance: " + GameState.entityManager.player.goldCollectDistance);
			output.println("GoldCollectSpeed: " + GameState.entityManager.player.goldCollectSpeed);
			output.println("Damage: " + GameState.entityManager.player.damage);
			output.println("Exp: " + GameState.entityManager.player.exp);
			output.println("Level: " + GameState.entityManager.player.level);
			output.println("Deaths: " + GameState.entityManager.player.deaths);
			output.println("Health: " + (int) GameState.entityManager.player.fullHealth);
			
			//From Wave
			output.println("WaveNumber: "+ WaveState.waveNumber);
			output.println("WaveEnemyNumber: "+ WaveState.waveEnemyNumber);
			output.println("WaveEnemySpawnTime: "+ WaveState.waveEnemySpawnTime);
			
			//From GameState
			output.println("Score: " + GameState.score);
			output.println("EnemyCount: " + GameState.enemyCount);
			output.println("EnemySpawned: " + GameState.enemySpawned);
			
			//From EntityManager
			output.println("EnemyCounter: " + GameState.entityManager.enemyCounter);
			
			output.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Saved!");
		
	}
	
	
	
	
}
