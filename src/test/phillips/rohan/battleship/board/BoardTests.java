package test.phillips.rohan.battleship.board;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.board.Board;

public class BoardTests {

   @Test
   @DisplayName("Test Board")
   public void testBoard(){
      Board board = new Board(10);

      assertEquals(10, board.getGridSize());

   }
   
}
