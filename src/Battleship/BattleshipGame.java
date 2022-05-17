package Battleship;

import java.util.*;

public class BattleshipGame {

	private boolean initialized;
	private boolean inProgress;
	private int gridSize;
	private Scanner userInput;
	private Player player1;
	private Player player2;
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		game.initGame(game.getUserGridSize());
		if(game.getInitialized()){
			System.out.println("Game Initialized.... Let's play");
			while(game.inProgress){
				game.inProgress = false;
			}
		} else {
			System.out.println("Game did not initialize");
		}
	}

	public BattleshipGame(){
		userInput = new Scanner(System.in);
	}

	public int getUserGridSize(){
		int size = 0;
		while(size < 7 || size > 10){
			System.out.println("Please enter game grid size (7 - 10)");  
			try {
				size = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException nfe){
				size = 0;
			}
		}  
		
		gridSize = size;
		return size;
	}

	public void initGame(int gridsize){			
		this.initialized = true;
		if(gridsize < 7 || gridsize > 10){
			this.initialized = false;
		}
		player1 = new Player(gridsize, 1, false);
		player1.gatherInfo(userInput);
		player2 = new Player(gridsize, 2, false);
		player2.gatherInfo(userInput);
		this.inProgress = this.initialized;
	}

	public boolean getInitialized(){
		return initialized;
	}

	public void setInitialized(boolean val){
		this.initialized = val;
	}

	public boolean getInProgress(){
		return inProgress;
	}

	public void setInProgress(boolean val){
		this.inProgress = val;
	}
}




