package main.phillips.rohan.battleship.board;

import main.phillips.rohan.battleship.ships.Carrier;
import main.phillips.rohan.battleship.ships.Ship;

public class BoardPosition {
   private boolean isEmpty;
   private boolean isHit;
   private boolean isGuessed;
   private Ship ship;

   public BoardPosition(){
      this.isEmpty = false;
      this.isHit = false;
      this.isGuessed = false;
   }

   public BoardPosition(boolean isEmpty, boolean isHit, boolean isGuessed){
      this.isEmpty = isEmpty;
      this.isHit = isHit;
      this.isGuessed = isGuessed;
      this.ship = new Carrier();
   }

   public void setIsEmpty(boolean setEmpty){
      this.isEmpty = setEmpty;
   }

   public boolean getIsEmpty(){
      return isEmpty;
   }

   public void setIsHit(boolean setIsHit){
      this.isHit = setIsHit;
   }

   public boolean getIsHit(){
      return isHit;
   }

   public void setIsGuessed(boolean setIsGuessed){
      this.isGuessed = setIsGuessed;
      this.isEmpty = !setIsGuessed;
   }

   public boolean getIsGuessed(){
      return isGuessed;
   }

   public void setShip(Ship ship){
      this.ship = ship;
   }

   public Ship getShip(){
      return ship;
   }
}
