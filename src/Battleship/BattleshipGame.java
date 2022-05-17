package Battleship;

import java.util.*;

public class BattleshipGame {

	private boolean initialized;
	private boolean inProgress;
	private int gridSize;
	private Board board;
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

	public int getUserGridSize(){
		int size = 0;
		Scanner myInput = new Scanner(System.in);
		while(size < 7 || size > 10){
			System.out.println("Please enter game grid size (7 - 10)");  
			try {
				size = Integer.parseInt(myInput.nextLine());
			} catch (NumberFormatException nfe){
				size = 0;
			}

		}  
		myInput.close();
		this.gridSize = size;
		return size;
	}

	public void initGame(int gridsize){		
		this.initialized = true;
		if(gridsize < 7 || gridsize > 10){
			this.initialized = false;
		}
		this.board = new Board(this.gridSize);
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




