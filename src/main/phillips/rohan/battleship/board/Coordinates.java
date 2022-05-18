package main.phillips.rohan.battleship.board;

import java.util.Optional;

import java.util.Arrays;

public class Coordinates {
   
   private Coordinates() {
      throw new IllegalStateException("Coordinates class");
   }

   public enum Column{
      A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), J(9);

      private int columnNumber;

      private Column(int column){
         this.columnNumber = column;
      }

      public int getColumnNumber(){
         return columnNumber;
      }

      public static Optional<Column>  get(int col){
         return Arrays.stream(Column.values()).filter(column -> column.columnNumber == col).findFirst();
      }
   }

   public static boolean isValidLength(String str){
      return str.length() >= 2;
   }

   public static boolean isValidPair(String str, int gridSize){
      //will check if valid coordinate pair has been passed 'A3'
      if(!isValidLength(str)) return false;

      String col = str.substring(0, 1).toUpperCase();
      String digits = str.substring(1);
      int row = Integer.parseInt(digits) - 1;
      
      if(!Character.isAlphabetic(col.charAt(0))) return false;

      if(!isValidColumn(col, gridSize)) return false;

      return isValidRow(row, gridSize);
   }

   public static int[] getCoordinates(String coord, int gridSize){
      int[] willReturn = new int[] {-1, -1};
      if(isValidPair(coord, gridSize)){
         String col = coord.substring(0,1).toUpperCase();
         int row = Integer.parseInt(coord.substring(1)) - 1;
         if(coord.length() >= 2){
            willReturn[0] = Column.valueOf(col).getColumnNumber();
            willReturn[1] = row;
         }
      }
      return willReturn;
   }

   private static boolean isValidColumn(String str, int gridSize){
      try{
         int col = Column.valueOf(str).columnNumber;
      }
      catch(IllegalArgumentException i){
         return false;
      }
      return Column.valueOf(str).columnNumber < gridSize;
   }

   private static boolean isValidRow(int row, int gridSize){
      return row >= 0 && row < gridSize;
   }

}
