package Battleship;

public class Board {
   int gridSize;
   BoardPosition[][] positions = new BoardPosition[gridSize][gridSize];

   public Board(){
      gridSize = 10;
   }

   public void board(int grid){
      gridSize = grid;
   }

   public void reset(){
      positions = new BoardPosition[gridSize][gridSize] ;
   }

   public BoardPosition getPosition(int x, int y){
      return positions[x][y];
   }
}
