package main.phillips.rohan.battleship;

import java.util.*;
import java.util.stream.Collectors;

import main.phillips.rohan.battleship.board.Board;
import main.phillips.rohan.battleship.menu.PlayerMenu;
import main.phillips.rohan.battleship.menu.ShipMenu;
import main.phillips.rohan.battleship.ships.*;

public class Player {
   private int playerNumber;
   private boolean isComputer;
   private boolean isInitialized;
   private Board pieceBoard;
   private Board guessBoard;
   private List<Ship> ships;
   private int gridSize;
   private static Scanner userInput;

   public Player(int gridSize, int playerNumber, boolean isComputer){
      this.pieceBoard = new Board(gridSize);
      this.guessBoard = new Board(gridSize);
      this.ships = new ArrayList<>();
      this.playerNumber = playerNumber;
      this.isComputer = isComputer;
      this.gridSize = gridSize;
   }

   public void setUserInput(Scanner userInput){
      this.userInput = userInput;
   }

   public void gatherInfo(){
      while(!isInitialized){
         PlayerMenu menu = new PlayerMenu();
         menu.setMenuHeader("Is Player " + this.playerNumber + " a computer? (Y/N)");
         menu.setupYesNo();
         switch(menu.getSelection()){
            case 2:
               setIsComputer(true);
               break;
            default:
               setIsComputer(false);
         }
         isInitialized = true;
      }
   }

   public void setPlayerNumber(int num){
      this.playerNumber = num;
   }

   public int getPlayerNumber(){
      return this.playerNumber;
   }

   public Board getPieceBoard(){
      return this.pieceBoard;
   }

   public Board getGuessboard(){
      return this.guessBoard;
   }

   public void setIsComputer(boolean iscomputer){
      isComputer = iscomputer;
   }

   public boolean getIsComputer(){
      return isComputer;
   }

   public boolean getIsInitialized(){
      return isInitialized;
   }

   public void setIsInitialized(boolean init){
      isInitialized = init;
   }

   public void addShip(Ship ship){
      pieceBoard.updateBoardShipCoordinates(ship);
      ships.add(ship);
   }

   

   public Ship getShip(Ship.ShipType type){
      List<Ship> result = ships.stream().filter(s -> s.getShipType() == type).collect(Collectors.toList());
      if(!result.isEmpty()){
         return result.get(0);
      } else{
         return new Ship();
      }     
   }

   public List<Ship> getShips(){
      return ships;
   }

   public int shipCount(){
      return ships.size();
   }

   public boolean shipExists(Ship ship){
      List<Ship> result = ships.stream().filter(s -> s.getShipType() == ship.getShipType()).collect(Collectors.toList());
      return !result.isEmpty();
   }

   public List<String> shipList(){
      return ships.stream().map(s -> s.getShipType().toString()).collect(Collectors.toList());
   }

   public void selectShips(){
		int selected;
		boolean existSelected = false;
		
		while(Ship.ShipType.getList().size() != shipList().size() && !existSelected){
			System.out.println("Player " + getPlayerNumber() + " choose your ships:");
			List<String> diff = Ship.ShipType.getList();
			diff.removeAll(shipList());
			ShipMenu menu = new ShipMenu(userInput, diff, "Exit");
			selected = menu.getSelection();
			if(selected > 0 && selected <= diff.size()){
				Ship ship = buildShip(this, diff.toArray()[selected - 1].toString());
				addShip(ship);
				getPieceBoard().drawBoard();
			} else {
				existSelected = menu.isExitSelected();
			}						
		}		
	}

   private static Ship initShip(String shipToBuild){
      Ship newShip;
      switch(shipToBuild){
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
      return newShip;
   }

   public Ship buildShip(Player player, String shipToBuild){
		Ship newShip = initShip(shipToBuild);
		CoordinateInput input = new CoordinateInput(userInput);
		
		while(!input.isComplete()){			
			input.getCoordinates(gridSize, newShip.getShipLength());
			if(newShip.getShipLength() != (input.getLength())){				
				System.out.println("Ship Length is " + newShip.getShipLength() + ", Length of coordinates entered is " + input.getLength());
				input.reset();
			} else {
				newShip.setStartCoordinate(input.getPair().getStart());
				newShip.setEndCoordinate(input.getPair().getEnd());
				newShip.setCoordinateList(input.getCoordinateList());
				if(!player.getPieceBoard().canPlaceShip(newShip)){
					System.out.println("Location selected conflicts with another ship placement, please select a new location");
					input.reset();
				}
			}
		}
		return newShip;
	}

}
