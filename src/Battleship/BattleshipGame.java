package Battleship;

import java.util.*;

public class BattleshipGame {

	private boolean initialized;
	private boolean inProgress;
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		game.initGame();
		if(game.getInitialized()){
			System.out.println("Game Initialized.... Let's play");
			while(game.inProgress){
				game.inProgress = false;
			}
		} else {
			System.out.println("Game did not initialize");
		}
	}

	public void initGame(){
		int gridSize = 0;
		Scanner myInput = new Scanner(System.in);
		while(gridSize < 7 || gridSize > 10){
			System.out.println("Please enter game grid size (7 - 10)");  
			gridSize = Integer.parseInt(myInput.nextLine());
		}  
		myInput.close();
		this.initialized = true;
		this.inProgress = true;
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

	public static String play(){
		return "We will play Battleships";
	}

	private class Board{
		int gridSize;
		BoardPosition[][] positions = new BoardPosition[gridSize][gridSize];

		public Board(){
			gridSize = 10;
		};

		public void board(int grid){
			gridSize = grid;
		}

		public void reset(){
			positions = new BoardPosition[gridSize][gridSize] ;
		}

		public BoardPosition getPosition(int x, int y){
			return positions[x][y];
		}

	}

	private class BoardPosition{
		private static boolean isEmpty = true;
		private static boolean isHit = false;
		private static boolean isGuessed = false;

		public static void setIsEmpty(boolean setEmpty){
			BoardPosition.isEmpty = setEmpty;
		}

		public static void setIsHit(boolean setIsHit){
			BoardPosition.isHit = setIsHit;
		}

		public static void setIsGuessed(boolean setIsGuessed){
			BoardPosition.isGuessed = setIsGuessed;
		}
	}
	
}




