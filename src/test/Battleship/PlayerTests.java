package test.Battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import Battleship.Player;

public class PlayerTests {
   
   @Test
   @DisplayName("Create Player")
   public void createPlayer(){
      Player player = new Player(10);

      assertEquals(player.getPieceBoard().getClass(), Battleship.Board.class);
      assertEquals(player.getGuessboard().getClass(), Battleship.Board.class);
   }

   @Test
   @DisplayName("Test PlayerNumber")
   public void testPlayerNumber(){
      Player player = new Player(10);

      assertEquals(true, player.getPlayerNumber() == 0);

      player.setPlayerNumber((1));
      assertEquals(true, player.getPlayerNumber() == 1);

   }


}
