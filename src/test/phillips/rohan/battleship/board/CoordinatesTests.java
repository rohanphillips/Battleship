package test.phillips.rohan.battleship.board;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import main.phillips.rohan.battleship.board.Coordinates;
import main.phillips.rohan.battleship.board.Coordinates.Column;

public class CoordinatesTests {
   
   @Test
   @DisplayName("Get column letter")
   public void getLetter(){
      
      Optional<Column> col = Coordinates.Column.get(1);
      assertEquals("B" , col.get().toString());
   }

   @Test
   @DisplayName("Check Valid Input Length")
   public void checkInputLength(){
      assertEquals(true, Coordinates.isValidLength("A1"));
      assertEquals(false, Coordinates.isValidLength("t"));
   }

   @Test
   @DisplayName("Check if valid coordinate pair")
   public void checkValidInputPair(){
      assertEquals(false, Coordinates.isValidPair("11", 10));
      assertEquals(false, Coordinates.isValidPair("111", 10));
      assertEquals(false, Coordinates.isValidPair("A11", 10));
      assertEquals(false, Coordinates.isValidPair("A0", 10));
      assertEquals(false, Coordinates.isValidPair("K1", 10));

      assertEquals(true, Coordinates.isValidPair("A1", 10));
      assertEquals(true, Coordinates.isValidPair("J1", 10));
   }

   @Test
   @DisplayName("Get Coordinates")
   public void getCoordinates(){
      int[] expect = new int[] {0, 0};
      assertArrayEquals(expect, Coordinates.getCoordinates("A1", 10));
      assertArrayEquals(expect, Coordinates.getCoordinates("a1", 10));

      int[] expect1 = new int[] {0, 9};
      assertArrayEquals(expect1, Coordinates.getCoordinates("A10", 10));
   }
}
