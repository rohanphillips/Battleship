package main.phillips.rohan.battleship.board;

import main.phillips.rohan.battleship.board.Coordinates;

public class Board {
   private int gridSize;
   private BoardPosition[][] positions;

   public static void main(String[] args) {
      Board board = new Board(10);
      BoardPosition position = board.getPosition(0, 0);
      System.out.println("Hi " + board.isPositionEmpty("A1"));
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

   public boolean isPositionHit(String coordinate){
      int[] coordinates = Coordinates.getCoordinates(coordinate, gridSize);
      return getPosition(coordinates[0], coordinates[1]).getIsHit();
   }

   public boolean isPositionGuessed(String coordinate){
      int[] coordinates = Coordinates.getCoordinates(coordinate, gridSize);
      return getPosition(coordinates[0], coordinates[1]).getIsGuessed();
   }

   // public boolean placeShip(String ship, String start, String end){
   //    if(Coordinates.isValidPair(start, gridSize) && Coordinates.isValidPair(end, gridSize)){
         
   //    } else {
   //       return false;
   //    }
   // }



   private void initBoard(){
      for(var i = 0; i < gridSize; i++){
         for(var j = 0; j < gridSize; j++){
            BoardPosition newPosition = new BoardPosition(true, true, false);
            positions[i][j] = newPosition;
         }
      }
   }

}
