package test.phillips.rohan.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.BoardPosition;

public class BoardPositionTests {

   @Test
   @DisplayName("Verify isEmpty")
   public void setIsEmpty(){
      BoardPosition position = new BoardPosition();
      position.setIsEmpty(false);
      assertEquals(false, position.getIsEmpty());

      position.setIsEmpty(true);
      assertEquals(true, position.getIsEmpty());
   }

   @Test
   @DisplayName("Verify isHit")
   public void setIsHit(){
      BoardPosition position = new BoardPosition();
      position.setIsHit(false);
      assertEquals(false, position.getIsHit());

      position.setIsHit(true);
      assertEquals(true, position.getIsHit());
   }

   @Test
   @DisplayName("Verify isGuessed")
   public void setIsGuessed(){
      BoardPosition position = new BoardPosition();
      position.setIsGuessed(false);
      assertEquals(false, position.getIsGuessed());

      position.setIsGuessed(true);
      assertEquals(true, position.getIsGuessed());
   }

   @Test
   @DisplayName("Verify Constructor init")
   public void verifyConstructor(){
      BoardPosition position = new BoardPosition(false, false, false);
      
      assertEquals(false, position.getIsEmpty());
      assertEquals(false, position.getIsHit());
      assertEquals(false, position.getIsGuessed());

      position = new BoardPosition(true, true, true);

      assertEquals(true, position.getIsEmpty());
      assertEquals(true, position.getIsHit());
      assertEquals(true, position.getIsGuessed());
   }
   
}
