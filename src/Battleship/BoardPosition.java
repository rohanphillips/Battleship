package Battleship;

public class BoardPosition {
   private boolean isEmpty;
   private boolean isHit;
   private boolean isGuessed;

   public BoardPosition(){
      this.isEmpty = false;
      this.isHit = false;
      this.isGuessed = false;
   }

   public BoardPosition(boolean isEmpty, boolean isHit, boolean isGuessed){
      this.isEmpty = isEmpty;
      this.isHit = isHit;
      this.isGuessed = isGuessed;
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
   }

   public boolean getIsGuessed(){
      return isGuessed;
   }
}
