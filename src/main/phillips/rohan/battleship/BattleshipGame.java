package main.phillips.rohan.battleship;

import java.util.*;


import main.phillips.rohan.battleship.ships.Ship;
import main.phillips.rohan.battleship.menu.*;

public class BattleshipGame {

	private boolean initialized;
	private boolean inProgress;
	private int gridSize;
	private Scanner userInput;
	private Player player1;
	private Player player2;
	private List<String> messages;
	public static void main(String[] args) {
		Menu menu = new MainMenu();
		menu.setMenuHeader("Main Menu");
		BattleshipGame game = new BattleshipGame();

		while(!menu.isExitSelected() && !game.getInitialized()){
			switch(menu.getSelection()){
				case 1:
					game.initGame(game.getUserGridSize());
					break;
				case 2:
					game.player1.setIsInitialized(false);
					game.player1.gatherInfo();
					break;
				case 3:
					game.player2.setIsInitialized(false);
					game.player2.gatherInfo();
					break;
				case 4:
					game.player1.selectShips();
					break;
				case 5:
					game.player2.selectShips();;
					break;
				case 6:
					if(game.initialized && game.canPlay()){
						game.setInitialized(true);
					} else {
						System.out.println("Can't play yet, everything not ready yet");
						game.messages.forEach(m -> System.out.println((game.messages.indexOf(m) + 1) + ": " + m + "\n"));
					}
					break;
				case 7:
					System.out.println("Bye!  Hope you had a good time");
					menu.setIsExitSelected(true);
					break;
				default:
					System.out.println("Invalid Menu Selection, please reselect");					
					break;
			}
		}
		
		
		if(game.getInitialized()){
			System.out.println("Game Initialized.... Let's play");
			game.player1.getPieceBoard().drawBoard();
			while(game.inProgress){
				game.inProgress = false;
			}
		}
	}

	public BattleshipGame(){
		userInput = new Scanner(System.in);
		messages = new ArrayList<>();
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
		if(!isGridSizeValid(gridsize)){
			setInitialized(false);
		}
		player1 = new Player(gridsize, 1, false);		
		player1.setUserInput(userInput);
		player2 = new Player(gridsize, 2, false);
		player2.setUserInput(userInput);

		setInProgress(true);
	}

	public boolean canPlay(){
		messages = new ArrayList<>();
		boolean player1Ready = Ship.ShipType.getList().size() == player1.shipList().size();
		if(!player1Ready) messages.add("Player 1 has not selected all ships");
		return messages.isEmpty();
	}		

	public boolean getInitialized(){
		return initialized;
	}

	public void setInitialized(boolean val){
		initialized = val;
	}

	public boolean getInProgress(){
		return inProgress;
	}

	public void setInProgress(boolean val){
		inProgress = val;
	}

	public boolean isGridSizeValid(int gridsize){
		return gridsize >= 7 && gridsize <= 10;
	}
}




