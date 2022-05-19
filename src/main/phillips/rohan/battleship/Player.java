package main.phillips.rohan.battleship;

import java.util.*;
import java.util.stream.Collectors;

import main.phillips.rohan.battleship.board.Board;
import main.phillips.rohan.battleship.ships.Ship;

public class Player {
   private int playerNumber;
   private boolean isComputer;
   private boolean isInitialized;
   private Board pieceBoard;
   private Board guessBoard;
   private List<Ship> ships;

   public Player(int gridsize, int playerNumber, boolean isComputer){
      this.pieceBoard = new Board(gridsize);
      this.guessBoard = new Board(gridsize);
      this.ships = new ArrayList<>();
      this.playerNumber = playerNumber;
      this.isComputer = isComputer;
   }

   public void gatherInfo(Scanner userInput){
      String x = "";   
      while(!isInitialized){
         System.out.println("Is Player " + this.playerNumber + " a computer? (Y/N)");
         try{
            x = userInput.nextLine();
            if(x.equals("Y") || x.equals("y")){
               setIsComputer(true);
            }   
            isInitialized = true;
         }  catch (Exception nfe){
               System.out.println(nfe);
         }
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

   public void addShip(Ship ship){
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
      List<Object> result = ships.stream().filter(s -> s.getShipType() == ship.getShipType()).collect(Collectors.toList());
      return !result.isEmpty();
   }

}
