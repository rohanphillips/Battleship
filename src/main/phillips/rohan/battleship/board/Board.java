package main.phillips.rohan.battleship.board;

import java.util.Random;

import main.phillips.rohan.battleship.CoordinateInput;
import main.phillips.rohan.battleship.board.Coordinates.Column;
import main.phillips.rohan.battleship.ships.Battleship;
import main.phillips.rohan.battleship.ships.Ship;

public class Board {
   private int gridSize;
   private BoardPosition[][] positions;
   private Random rand = new Random();

   public static void main(String[] args) {
      Board board = new Board(10);
      Battleship ship = new Battleship();
      CoordinateInput input = new CoordinateInput("A1", "a4");
      ship.setStartCoordinate(input.getPair().getStart());
      ship.setEndCoordinate(input.getPair().getEnd());
      ship.setCoordinateList(input.getCoordinateList());
      board.updateBoardShipCoordinates(ship);
      board.drawBoard();
      System.out.println(Coordinates.getRandomCoordinate(board.gridSize));
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

   private static String addPadding(String str){
      if(str.length() == 1){
         return " " + str + " ";
      } else if(str.length() == 2){
         return str + " ";
      } else {
         return str.substring(0, 3);
      }
   }

   public void drawBoard(){
      for(var row = 0; row < gridSize; row++){
         if(row != 0){            
            System.out.println("   " + "---".repeat(gridSize) + "-".repeat(gridSize - 1));
         } else {
            System.out.print("   ");
            for(var col = 0; col < gridSize; col++){
               if(col != 0){
                  System.out.print(" ");
               }               
               System.out.print(addPadding(Column.get(col)));
            }
            System.out.println();
            System.out.println("   ".repeat(gridSize) + " ".repeat(gridSize - 1));
         }
         System.out.print(addPadding(String.valueOf((row + 1))));
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
         return addPadding("O");
      } else if(position.getIsHit()){
         return addPadding("H");
      } else if(position.getIsGuessed()){
         return addPadding("G");
      }
      return addPadding(position.getShip().getShipType().name());
   }

   

   public BoardPosition getPosition(String coordinate){
      int[] coordinates = Coordinates.getCoordinates(coordinate, gridSize);
      return positions[coordinates[0]][coordinates[1]];
   }

   public int getGridSize(){
      return gridSize;
   }

   public void setPositionShip(String coordinate, Ship ship){
      getPosition(coordinate).setShip(ship);
   }

   public boolean isPositionEmpty(String coordinate){      
      return getPosition(coordinate).getIsEmpty();
   }

   public void setPositionEmpty(String coordinate, boolean setEmpty){
      getPosition(coordinate).setIsEmpty(setEmpty);
   }

   public boolean isPositionHit(String coordinate){
      return getPosition(coordinate).getIsHit();
   }

   public boolean isPositionGuessed(String coordinate){
      return getPosition(coordinate).getIsGuessed();
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

   public void updateBoardShipCoordinates(Ship ship){
      ship.getCoordinateList().forEach(c -> {
         setPositionEmpty(c, false);
         setPositionShip(c, ship);
      });
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
