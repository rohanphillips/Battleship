package main.phillips.rohan.battleship.ships;

import java.util.*;
import java.util.stream.Collectors;

import main.phillips.rohan.battleship.board.BoardPosition;

public class Ship {
   private ShipType shipType;
   private BoardPosition[] positions;

   public enum ShipType {
      BATTLESHIP(4),CARRIER(5), CRUISER(3), DESTROYER(2), SUBMARINE(3), NOTSET(-1);

      private int length;

      private ShipType(int length){
         this.length = length;         
      }

      public int getLength(){
         return length;
      }

      public static List<String> getList(){
         return EnumSet.allOf(ShipType.class).stream().filter(type -> !type.name().equals("NOTSET")).map(ShipType::name).collect(Collectors.toList());
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
