package main.phillips.rohan.battleship.board;

import main.phillips.rohan.battleship.board.Coordinates.Column;
import main.phillips.rohan.battleship.ships.Ship;

public class Board {
   private int gridSize;
   private BoardPosition[][] positions;

   public static void main(String[] args) {
      Board board = new Board(10);
      BoardPosition position = board.getPosition(0, 0);
      board.drawBoard();
   }

   public Board(int grid){
      gridSize = grid;   
      positions = new BoardPosition[gridSize][gridSize];   
      initBoard();
   }

   public void reset(){
      positions = new BoardPosition[gridSize][gridSize] ;
      initBoard();
   }

   public void drawBoard(){
      for(var row = 0; row < gridSize; row++){
         if(row != 0){
            System.out.println("--".repeat(gridSize));
         }
         for(var col = 0; col < gridSize; col++){
            if(col != 0){
               System.out.print("|");
            }
            BoardPosition position = positions[row][col];
            System.out.print(getPositionCharacter(Coordinates.getCoordinatePair(row, col)));
         }
         System.out.println();
      }
   }

   public String getPositionCharacter(String str){
      int[] coordinates = Coordinates.getCoordinates(str, gridSize);
      BoardPosition position = positions[coordinates[0]][coordinates[1]];
      if(position.getIsEmpty()){
         return "O";
      } else if(position.getIsHit()){
         return "H";
      } else if(position.getIsGuessed()){
         return "G";
      }
      return "X";
   }

   public BoardPosition getPosition(int x, int y){
      return positions[x][y];
   }

   public int getGridSize(){
      return gridSize;
   }

   public boolean isPositionEmpty(String coordinate){
      int[] coordinates = Coordinates.getCoordinates(coordinate, gridSize);
      return getPosition(coordinates[0], coordinates[1]).getIsEmpty();
   }

   public void setPositionEmpty(String coordinate, boolean setEmpty){
      int[] coordinates = Coordinates.getCoordinates(coordinate, gridSize);
      getPosition(coordinates[0], coordinates[1]).setIsEmpty(setEmpty);
   }

   public boolean isPositionHit(String coordinate){
      int[] coordinates = Coordinates.getCoordinates(coordinate, gridSize);
      return getPosition(coordinates[0], coordinates[1]).getIsHit();
   }

   public boolean isPositionGuessed(String coordinate){
      int[] coordinates = Coordinates.getCoordinates(coordinate, gridSize);
      return getPosition(coordinates[0], coordinates[1]).getIsGuessed();
   }

   public boolean canPlaceShip(Ship ship){
      OrientationInfo info = Coordinates.isValidOrientation(ship.getStartCoordinate(), ship.getEndCoordinate(), gridSize);
      return info.getIsValid() && canPlace(info);
   }

   public boolean canPlace(OrientationInfo info){
      int col1 = Column.valueOf(info.getColumn(1)).getColumnNumber();
      int col2 = Column.valueOf(info.getColumn(2)).getColumnNumber();
      int row1 = info.getRow(1);
      int row2 = info.getRow(2);
      for(var i = col1; i <= col2; i++){
         for(var j = row1; j <= row2; j++){
            BoardPosition position = positions[i][j];
            if(!position.getIsEmpty()){
               return false;
            }
         }
      }
      return true;
   }

   private void initBoard(){
      for(var i = 0; i < gridSize; i++){
         for(var j = 0; j < gridSize; j++){
            BoardPosition newPosition = new BoardPosition(true, false, false);
            positions[i][j] = newPosition;
         }
      }
   }

}
