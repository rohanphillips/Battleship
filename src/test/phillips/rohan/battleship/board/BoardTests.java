package test.phillips.rohan.battleship.board;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.board.Board;
import main.phillips.rohan.battleship.board.Board.Column;;

public class BoardTests {

   @Test
   @DisplayName("Test Board")
   public void testBoard(){
      Board board = new Board(10);

      assertEquals(10, board.getGridSize());

   }

   @Test
   @DisplayName("Get column letter")
   public void getLetter(){
      
      Optional<Column> col = Board.Column.get(1);
      assertEquals("B" , col.get().toString());
   }

   @Test
   @DisplayName("Get Coordinates")
   public void getCoordinates(){
      Board board = new Board(10);
      int[] expect = {0, 1};
      assertArrayEquals(expect, board.getCoordinates("A1"));
   }
   
}
