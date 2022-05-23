package main.phillips.rohan.battleship;

import java.util.*;

import main.phillips.rohan.battleship.board.Coordinates;
import main.phillips.rohan.battleship.board.Coordinates.Column;
import main.phillips.rohan.battleship.menu.Menu;
import test.phillips.rohan.battleship.board.Pair;

public class CoordinateInput{
   private boolean isComplete;
   private Pair pair;
   private int length;

   public CoordinateInput(){
      this.isComplete = false;
      pair = new Pair();
   }

   public CoordinateInput(String start, String end){
      pair = new Pair(start, end);
      this.isComplete = false;
   }

   /**
    * This function will take get a single coordinate from the user and get a list of all valid coordinates
    * @param Scanner userInput    console user input
    * @param int gridSize
    * @param int shipSize
    * @return
    */
   public List<Pair> getCoordinatesFromSingle(Scanner userInput, int gridSize, int shipLength){
      List<Pair> list = new ArrayList<>();
      int row1;
      int row2;
      int col1;
      int col2;
      String temp;

      while(!Coordinates.isValidPair(pair.getStart(), gridSize)){
         pair.setStart(userInput.nextLine());
         if(Coordinates.isValidPair(pair.getStart(), gridSize)){
            row1 = Coordinates.getRow(pair.getStart());
            col1 = Column.valueOf(Coordinates.getColumn(pair.getStart())).getColumnNumber();
            row2 = row1 + shipLength;
            col2 = col1 + shipLength - 1;
            temp = Column.get(col1) + row2;
            if(Coordinates.isValidPair(temp, gridSize) && Coordinates.isValidOrientation(pair.getStart(), temp, gridSize).getIsValid()){               
               list.add(new Pair(pair.getStart(), temp));
            }
            temp = Column.get(col2) + (row1 + 1);
            if(Coordinates.isValidPair(temp, gridSize) && Coordinates.isValidOrientation(pair.getStart(), temp, gridSize).getIsValid()){
               list.add(new Pair(pair.getStart(), temp));
            }
         }         
      }
      return list;
   }

   public void getCoordinates(Scanner userInput, int gridSize, int shipLength){      
      List<Pair> list;
      Menu menu;

      while(!isComplete){
         if(!Coordinates.isValidPair(pair.getStart(), gridSize)){
            System.out.println("Enter a valid starting coordinate:");
            list = getCoordinatesFromSingle(userInput, gridSize, shipLength);
            menu = new Menu(userInput, Pair.createMenuPairList(list), "Exit");
            int selection = menu.getSelection();
            if(selection <= list.size()){
                pair = list.get(selection -1);                
            }
         } else if(Coordinates.isValidPair(pair.getStart(), gridSize) && Coordinates.isValidPair(pair.getEnd(), gridSize)){
            if(!Coordinates.isValidOrientation(pair.getStart(), pair.getEnd(), gridSize).getIsValid()){
               System.out.println("Please define a correct orientation, i.e A1..A3");
               reset();
            } else {
               isComplete = true;
               length = Coordinates.getOrientationLength(this.pair);
            }
         }
      }
   }

   public List<String> getCoordinateList(){
      int col1 = Column.valueOf(Coordinates.getColumn(pair.getStart())).getColumnNumber();
      int col2 = Column.valueOf(Coordinates.getColumn(pair.getEnd())).getColumnNumber();
      int row1 = Coordinates.getRow(pair.getStart()) + 1;
      int row2 = Coordinates.getRow(pair.getEnd()) + 1;

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
      pair = new Pair();
   }

   public void setIsComplete(boolean complete){
      isComplete = complete;
   }

   public boolean isComplete(){
      return isComplete;
   }
   
   public Pair getPair(){
      return pair;
   }

   public int getLength(){
      return length;
   }
}
