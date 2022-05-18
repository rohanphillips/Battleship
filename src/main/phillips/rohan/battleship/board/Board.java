package main.phillips.rohan.battleship.board;

public class Board {
   private int gridSize;
   BoardPosition[][] positions = new BoardPosition[gridSize][gridSize];

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

}
