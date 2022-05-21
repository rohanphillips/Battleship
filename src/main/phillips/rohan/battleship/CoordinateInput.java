package main.phillips.rohan.battleship;

import java.util.*;

import main.phillips.rohan.battleship.board.Coordinates;
import main.phillips.rohan.battleship.board.Coordinates.Column;

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

   public CoordinateInput(String start, String end){
      this.start = start;
      this.end = end;
      this.isComplete = false;
   }

   public List<String> getCoordinatesFromSingle(Scanner userInput, int gridSize, int shipLength){
      List<String> list = new ArrayList<>();
      int row1;
      int row2;
      int col1;
      int col2;
      String temp;

      while(!isComplete){
         start = userInput.nextLine();
         if(Coordinates.isValidPair(start, gridSize)){
            row1 = Coordinates.getRow(start);
            col1 = Column.valueOf(Coordinates.getColumn(start)).getColumnNumber();
            row2 = row1 + shipLength -1;
            col2 = col1 + shipLength - 1;
            temp = Column.get(col1) + row2;
            if(Coordinates.isValidPair(temp, gridSize)){               
               list.add(createItem(start, temp));
            }
            temp = Column.get(col2) + row1;
            if(Coordinates.isValidPair(temp, gridSize)){
               list.add(createItem(start, temp));
            }
            isComplete = true;
         }         
      }
      return list;
   }

   private String createItem(String start, String end){
      return start + ".." + end;
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

   public List<String> getCoordinateList(){
      int col1 = Column.valueOf(Coordinates.getColumn(start)).getColumnNumber();
      int col2 = Column.valueOf(Coordinates.getColumn(end)).getColumnNumber();
      int row1 = Coordinates.getRow(start) + 1;
      int row2 = Coordinates.getRow(end) + 1;

      List<String> list = new ArrayList<>();

      if(col1 == col2){
         String column = Column.get(col1);
         for(var i = row1; i <= row2; i++){
            list.add(column + i);
         }
      } else if(row1 == row2) {
         for(var i = col1; i <= col2; i++){
            list.add(Column.get(i) + (row1));
         }
      }
      return list;
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
