package main.phillips.rohan.battleship;

import java.util.*;
import java.util.stream.Collectors;

import main.phillips.rohan.battleship.board.Board;
import main.phillips.rohan.battleship.board.Coordinates;
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
   private static Random rand = new Random();

   public Player(int gridSize, int playerNumber, boolean isComputer){
      this.pieceBoard = new Board(gridSize);
      this.guessBoard = new Board(gridSize);
      this.ships = new ArrayList<>();
      this.playerNumber = playerNumber;
      this.isComputer = isComputer;
      this.gridSize = gridSize;
   }

   public static void setUserInput(Scanner input){
      userInput = input;
   }

   public void gatherInfo(){
      while(!isInitialized){
         PlayerMenu menu = new PlayerMenu();
         menu.setMenuHeader("Is Player " + this.playerNumber + " a computer? (Y/N)");
         menu.setupYesNo();         
         if(menu.getSelection() == 2){
            setIsComputer(true);
         } else {
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

   public Board getGuessBoard(){
      return this.guessBoard;
   }

   public void setIsComputer(boolean isComputer){
      this.isComputer = isComputer;
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

   public boolean takeGuess(Player otherPlayer){
      String guess;
      Ship ship;
      //print the grid
      pieceBoard.drawBoard();
      guessBoard.drawBoard();      
      System.out.println("Player " + playerNumber + ": Enter your location guess");
      guess = userInput.nextLine();
      if(Coordinates.isValidPair(guess, gridSize)){
         if(otherPlayer.getPieceBoard().isPositionEmpty(guess)){
            guessBoard.getPosition(guess).setIsGuessed(true);
            System.out.println("Missed!");
            return true;
         } else {
            //is a hit
            ship = otherPlayer.getPieceBoard().getPosition(guess).getShip();
            System.out.println("HIT! - " + ship.getShipAbbreviation());
            guessBoard.setPositionShip(guess, ship);
            otherPlayer.getPieceBoard().getPosition(guess).setIsHit(true);
            return false;
         }
      }
      return false;
   }

   public boolean isAllShipsSunk(){
      for(var i = 0; i < ships.size(); i++){
         if(!ships.get(i).isSunk(pieceBoard)){
            return false;
         }
      }
      return true;
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
         List<String> diff = Ship.ShipType.getList();
         ShipMenu menu = new ShipMenu();
			diff.removeAll(shipList());
         if(!isComputer){
            System.out.println("Player " + getPlayerNumber() + " choose your ships:");
            menu = new ShipMenu(userInput, diff, "Exit");
			   selected = menu.getSelection();
         } else{
            selected = rand.nextInt(diff.size() + 1) + 1;
         }					
			
			if(selected > 0 && selected <= diff.size()){
				Ship ship = buildShip(this, diff.toArray()[selected - 1].toString());
				addShip(ship);
			} else if(!isComputer) {
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
      newShip.setPlayer(this);
		CoordinateInput coordinates = newShip.getShipCoordinates();
		coordinates.setUserInput(userInput);

		while(!coordinates.isComplete()){			
			coordinates.getCoordinates(gridSize, newShip);
			if(newShip.getShipLength() != (coordinates.getLength())){				
				System.out.println("Ship Length is " + newShip.getShipLength() + ", Length of coordinates entered is " + coordinates.getLength());
				coordinates.reset();
			} else {            
				if(!player.getPieceBoard().canPlaceShip(newShip)){
					if(!newShip.getShipPlayer().isComputer){
                  System.out.println("Location selected conflicts with another ship placement, please select a new location");
               }               
					coordinates.reset();
				} else {
               newShip.setCoordinates(coordinates);
            }
			}
		}
		return newShip;
	}

}
