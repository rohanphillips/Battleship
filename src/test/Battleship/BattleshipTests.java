package test.Battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Battleship.BattleshipGame;

public class BattleshipTests {
   
   @Test
   public void test(){
      BattleshipGame game = new BattleshipGame();
      game.initGame(7);
      assertEquals(true, game.getInitialized());
   }
}
