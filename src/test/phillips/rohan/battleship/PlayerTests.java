package test.phillips.rohan.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.Player;

public class PlayerTests {
   
   @Before
   public Player setupPlayer(boolean isComputer){
      return new Player(10, 1, isComputer);
   }

   @Test
   @DisplayName("Create Player")
   public void createPlayer(){

      assertEquals(setupPlayer(true).getPieceBoard().getClass(), main.phillips.rohan.battleship.board.Board.class);
      assertEquals(setupPlayer(true).getGuessboard().getClass(), main.phillips.rohan.battleship.board.Board.class);
   }

   @Test
   @DisplayName("Test PlayerNumber")
   public void testPlayerNumber(){
      Player player = setupPlayer(true);

      assertEquals(true, player.getPlayerNumber() == 1);

      player.setPlayerNumber((2));
      assertEquals(true, player.getPlayerNumber() == 2);
   }

   @Test
   @DisplayName("Test isComputer")
   public void testIsComputer(){
      Player player = setupPlayer(false);

      assertEquals(false, player.getIsComputer());

      player.setIsComputer(true);
      assertEquals(true, player.getIsComputer());
   }


}
