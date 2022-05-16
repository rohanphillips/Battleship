package Battleship;

public class BoardPosition {
   private static boolean isEmpty = true;
   private static boolean isHit = false;
   private static boolean isGuessed = false;

   public static void setIsEmpty(boolean setEmpty){
      BoardPosition.isEmpty = setEmpty;
   }

   public static void setIsHit(boolean setIsHit){
      BoardPosition.isHit = setIsHit;
   }

   public static void setIsGuessed(boolean setIsGuessed){
      BoardPosition.isGuessed = setIsGuessed;
   }
}
