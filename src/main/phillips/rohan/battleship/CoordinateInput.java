package main.phillips.rohan.battleship;

import java.util.*;

import main.phillips.rohan.battleship.board.Coordinates;

public class CoordinateInput{
   private boolean isComplete;
   private String start = "";
   private String end = "";

   public CoordinateInput(){
      this.isComplete = false;
      this.start = "";
      this.end = "";
   }

   public void getCoordinates(Scanner userInput, int gridSize){      
      while(!isComplete){
         if(!Coordinates.isValidPair(start, gridSize)){
            System.out.println("Enter a valid starting coordinate:");
            start = userInput.nextLine();
         } else if(!Coordinates.isValidPair(end, gridSize)){
            System.out.println("Enter a valid end coordinate:");
            end = userInput.nextLine();
         } else if(Coordinates.isValidPair(start, gridSize) && Coordinates.isValidPair(end, gridSize)){
            isComplete = true;
         }
      }
   }

   public boolean isComplete(){
      return isComplete;
   }

   public String getStart(){
      return start;
   }

   public String getEnd(){
      return end;
   }
}
