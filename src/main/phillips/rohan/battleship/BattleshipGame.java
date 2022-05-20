package main.phillips.rohan.battleship;

import java.util.*;

import main.phillips.rohan.battleship.ships.Battleship;
import main.phillips.rohan.battleship.ships.Carrier;
import main.phillips.rohan.battleship.ships.Cruiser;
import main.phillips.rohan.battleship.ships.Destroyer;
import main.phillips.rohan.battleship.ships.Ship;
import main.phillips.rohan.battleship.ships.Submarine;

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
		setInitialized(true);
		if(!isGridSizeValid(gridsize)){
			setInitialized(false);
		}
		player1 = new Player(gridsize, 1, false);
		player1.gatherInfo(userInput);
		player2 = new Player(gridsize, 2, false);
		player2.gatherInfo(userInput);
		selectShips(player1);

		setInProgress(getInitialized());
	}

	public void selectShips(Player player){
		int selected;
		System.out.println("Player " + player.getPlayerNumber() + " choose your ships:");
		while(Ship.ShipType.getList().size() != player.shipList().size()){
			List<String> diff = Ship.ShipType.getList();
			diff.removeAll(player.shipList());
			diff.forEach(s -> System.out.println((diff.indexOf(s) + 1) + ": " + s));
			selected = Integer.parseInt(userInput.nextLine());
			if(selected > 0 && selected <= diff.size()){
				Ship ship = buildShip(player, diff.toArray()[selected - 1].toString());
				player.addShip(ship);
			}			
		}
		
	}

	public Ship buildShip(Player player, String ship){
		Ship newShip;
		CoordinateInput input = new CoordinateInput();
		switch(ship){
			case "BATTLESHIP":
				newShip = new Battleship();
				break;
			case "CARRIER":
				newShip = new Carrier();
				break;
			case "CRUISER":
				newShip = new Cruiser();
				break;
			case "DESTROYER":
				newShip = new Destroyer();
				break;
			case "SUBMARINE":
				newShip = new Submarine();
				break;
			default:
				newShip = new Ship();
		}
		while(!input.isComplete()){
			input.getCoordinates(userInput, gridSize);
			if(newShip.getShipLength() != (input.getLength())){				
				System.out.println("Ship Length is " + newShip.getShipLength() + ", Length of coordinates entered is " + input.getLength());
				input.reset();
			} else {
				newShip.setStartCoordinate(input.getStart());
				newShip.setEndCoordinate(input.getEnd());
				if(!player.getPieceBoard().canPlaceShip(newShip)){
					System.out.println("Location selected conflicts with another ship placement, please select a new location");
					input.reset();
				}
			}
		}
		return newShip;
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




