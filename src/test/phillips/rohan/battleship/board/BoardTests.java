package test.phillips.rohan.battleship.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.board.Board;
import main.phillips.rohan.battleship.board.OrientationInfo;
import main.phillips.rohan.battleship.board.Coordinates;

public class BoardTests {
   private Board board;
   private int gridSize = 10;
   @Before
   public void init(){
      board = new Board(gridSize);
   }

   @Test
   @DisplayName("Test Board")
   public void testBoard(){

      assertEquals(10, board.getGridSize());

   }

   @Test
   @DisplayName("Test can place")
   public void canPlace(){
      OrientationInfo info = Coordinates.isValidOrientation("A1", "A4", gridSize);
      assertEquals(true, board.canPlace(info));

      board.setPositionEmpty("A1", false);
      assertEquals(false, board.canPlace(info));
   }
   
}
