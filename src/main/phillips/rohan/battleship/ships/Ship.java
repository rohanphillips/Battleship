package main.phillips.rohan.battleship.ships;

import main.phillips.rohan.battleship.board.BoardPosition;

public class Ship {
   private ShipType shipType;
   private BoardPosition[] positions;

   public enum ShipType {
      CARRIER(5), BATTLESHIP(4), CRUISER(3), SUBMARINE(3), DESTROYER(2), NOTSET(-1);

      private int length;

      private ShipType(int length){
         this.length = length;         
      }

      public int getLength(){
         return length;
      }
   }

   public Ship(){
      this.shipType = Ship.ShipType.NOTSET;
   }

   public void setShipType(ShipType shiptype){
      this.shipType = shiptype;
      this.positions = new BoardPosition[this.shipType.length];
   }

   public ShipType getShipType(){
      return shipType;
   }

   public int getShipLength(){
      if(shipType != null){
         return shipType.length;
      }
      return -1;
   }

   public BoardPosition[] getPositions(){
      return positions;
   }
}
