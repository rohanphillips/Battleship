package main.phillips.rohan.battleship;

import java.util.*;

import main.phillips.rohan.battleship.board.Coordinates;

public class CoordinateInput{
   private boolean isComplete;
   private String start = "";
   private String end = "";
   private int length;

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
            if(!Coordinates.isValidOrientation(start, end, gridSize).getIsValid()){
               System.out.println("Please define a correct orientation, i.e A1..A3");
               reset();
            } else {
               isComplete = true;
               length = Coordinates.getOrientationLength(start, end);
            }
         }
      }
   }

   public void reset(){
      isComplete = false;
      start = "";
      end = "";
   }

   public void setIsComplete(boolean complete){
      isComplete = complete;
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

   public int getLength(){
      return length;
   }
}
