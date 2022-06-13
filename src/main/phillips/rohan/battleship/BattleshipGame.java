package main.phillips.rohan.battleship;

import java.util.*;
import javax.swing.*;

import main.phillips.rohan.battleship.ships.Ship;
import main.phillips.rohan.battleship.menu.*;

public class BattleshipGame {

	private boolean initialized;
	private boolean inProgress;
	private Scanner userInput;
	private Player player1;
	private Player player2;
	private List<String> messages;
	private int playerTurn;
	private boolean gameWon;
	public static void main(String[] args) {
		
		BattleshipGame game = new BattleshipGame();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				createAndShowGUI();
			}
		});
		//game.menu();
	}

	public BattleshipGame(){
		userInput = new Scanner(System.in);
		messages = new ArrayList<>();
		playerTurn = 1;
		gameWon = false;
	}

	private static void createAndShowGUI(){
		JFrame frame = new JFrame("Hello World Swing");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);

		frame.pack();
		frame.setVisible(true);
	}

	public void menu(){
		Menu menu = new MainMenu();
		menu.setMenuHeader("Main Menu");
		while(!menu.isExitSelected() && !getInitialized()){
			switch(menu.getSelection()){
				case 1:
					initGame(getUserGridSize());
					break;
				case 2:
					player1.setIsInitialized(false);
					player1.gatherInfo();
					break;
				case 3:
					player2.setIsInitialized(false);
					player2.gatherInfo();
					break;
				case 4:
					player1.selectShips();
					break;
				case 5:
					player2.selectShips();
					break;
				case 6:
					if(canPlay()){
						setInitialized(true);
						play();
					} else {
						System.out.println("Can't play yet, everything not ready yet");
						messages.forEach(m -> System.out.println((messages.indexOf(m) + 1) + ": " + m + "\n"));
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
	}

	public void play(){
		if(getInitialized()){
			System.out.println("Game Initialized.... Let's play");
			while(!gameWon){
				while (!player1.takeGuess(player2)){
					System.out.println("P1");
				}
				if(player2.isAllShipsSunk()){
					setGameWon(true);
					System.out.println("Player 1 is the Winner!");
				}
				pressAnyKey();

				while(!player2.takeGuess(player1) && !gameWon){
					System.out.println("P2");
				}
				if(player1.isAllShipsSunk()){
					setGameWon(true);
					System.out.println("Player 2 is the Winner!");
				}
				pressAnyKey();
			}
		}
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
		
		return size;
	}

	public void pressAnyKey(){
		System.out.println("Press Any key to continue...");
		userInput.nextLine();
	}

	public void initGame(int gridSize){		
		if(!isGridSizeValid(gridSize)){
			setInitialized(false);
		}
		Player.setUserInput(userInput);
		player1 = new Player(gridSize, 1, false);				
		player2 = new Player(gridSize, 2, false);

		setInProgress(true);
	}

	public boolean canPlay(){
		messages = new ArrayList<>();
		boolean player1Ready = Ship.ShipType.getList().size() == player1.shipList().size();
		boolean player2Ready = Ship.ShipType.getList().size() == player2.shipList().size();
		if(!player1Ready) messages.add("Player 1 has not selected all ships");
		if(!player2Ready) messages.add("Player 2 has not selected all ships");
		return messages.isEmpty();
	}		

	public boolean getInitialized(){
		return initialized;
	}

	public void setInitialized(boolean val){
		initialized = val;
	}

	public void setPlayerTurn(int playerTurn){
		this.playerTurn = playerTurn;
	}

	public int getPlayerTurn(){
		return playerTurn;
	}

	public void setGameWon(boolean set){
		gameWon = set;
	}

	public boolean getInProgress(){
		return inProgress;
	}

	public void setInProgress(boolean val){
		inProgress = val;
	}

	public boolean isGridSizeValid(int gridSize){
		return gridSize >= 7 && gridSize <= 10;
	}
}




