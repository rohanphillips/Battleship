package main.phillips.rohan.battleship;

public class Board {
   int gridSize;
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
}
