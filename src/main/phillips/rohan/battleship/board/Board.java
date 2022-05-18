package main.phillips.rohan.battleship.board;

import java.util.Optional;
import java.util.Arrays;
import java.util.ArrayList;

public class Board {
   private int gridSize;
   BoardPosition[][] positions = new BoardPosition[gridSize][gridSize];

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

   public Board(int grid){
      gridSize = grid;
   }

   public void reset(){
      positions = new BoardPosition[gridSize][gridSize] ;
   }

   public BoardPosition getPosition(int x, int y){
      return positions[x][y];
   }

   public int getGridSize(){
      return gridSize;
   }

   public int[] getCoordinates(String coord){
      int[] willReturn = new int[2];
      String[] chars = coord.split("");
      if(chars.length == 2){
         willReturn[0] = Column.valueOf(chars[0]).getColumnNumber();
         willReturn[1] = Integer.parseInt(chars[1]);
      }
      return willReturn;
   }
}
