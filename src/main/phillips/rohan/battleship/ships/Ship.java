package main.phillips.rohan.battleship.ships;

import java.util.*;
import java.util.stream.Collectors;

import main.phillips.rohan.battleship.CoordinateInput;
import main.phillips.rohan.battleship.Player;
import main.phillips.rohan.battleship.board.Board;

public class Ship {
   private ShipType shipType;
   private List<String> coordinateList;
   private CoordinateInput coordinates;
   private Player player;

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
      coordinates = new CoordinateInput();
   } 
   
   public void setPlayer(Player player){
      this.player = player;
   }

   public void setShipType(ShipType type){
      this.shipType = type;
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

   public String getShipAbbreviation(){
      return shipType.name().substring(0, 3);
   }

   public void setStartCoordinate(String start){
      coordinates.getPair().setStart(start);
   }

   public String getStartCoordinate(){
      return coordinates.getPair().getStart();
   }

   public void setEndCoordinate(String end){
      coordinates.getPair().setEnd(end);
   }

   public String getEndCoordinate(){
      return coordinates.getPair().getEnd();
   }

   public void setCoordinateList(List<String> list){
      coordinateList = list;
   }

   public List<String> getCoordinateList(){
      return coordinateList;
   }

   public void setCoordinates(CoordinateInput input){
      coordinates = input;
   }

   public CoordinateInput getShipCoordinates(){
      return coordinates;
   }

   public Player getShipPlayer(){
      return player;
   }

   public boolean isSunk(Board board){
      for(var i = 0; i < coordinateList.size(); i++){
         if(!board.getPosition(coordinateList.get(i)).getIsHit()){
            return false;
         }
      }
      return true;
   }

}
