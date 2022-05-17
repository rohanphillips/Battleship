package main.phillips.rohan.battleship.ships;

public class Ship {
   private ShipType shipType;

   public enum ShipType {
      CARRIER(5), BATTLESHIP(4), CRUISER(3), SUBMARINE(3), DESTROYER(2);

      private int length;

      private ShipType(int length){
         this.length = length;
      }

      public int getLength(){
         return length;
      }
   }

   public void setShipType(ShipType shiptype){
      this.shipType = shiptype;
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
}
