package main.phillips.rohan.battleship;

import java.util.*;

public class Player {
   private int playerNumber;
   private boolean isComputer;
   private boolean isInitialized;
   private Board pieceBoard;
   private Board guessBoard;

   public Player(int gridsize, int playerNumber, boolean isComputer){
      pieceBoard = new Board(gridsize);
      guessBoard = new Board(gridsize);
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

}
