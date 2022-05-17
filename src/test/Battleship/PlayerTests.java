package test.Battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import Battleship.Player;

public class PlayerTests {
   
   @Test
   @DisplayName("Create Player")
   public void createPlayer(){
      Player player = new Player(10, 1, true);

      assertEquals(player.getPieceBoard().getClass(), Battleship.Board.class);
      assertEquals(player.getGuessboard().getClass(), Battleship.Board.class);
   }

   @Test
   @DisplayName("Test PlayerNumber")
   public void testPlayerNumber(){
      Player player = new Player(10, 1, true);

      assertEquals(true, player.getPlayerNumber() == 1);

      player.setPlayerNumber((2));
      assertEquals(true, player.getPlayerNumber() == 2);

   }


}
