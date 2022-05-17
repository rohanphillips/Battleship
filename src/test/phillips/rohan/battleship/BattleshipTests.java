package test.phillips.rohan.battleship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.BattleshipGame;

public class BattleshipTests {
   
   @Test
   @DisplayName("Init fails with grid size < 7")
   public void gridLow(){
      BattleshipGame game = new BattleshipGame();
      assertEquals(false, game.isGridSizeValid(6));
   }

   @Test
   @DisplayName("Init fails with grid size > 10")
   public void gridHigh(){
      BattleshipGame game = new BattleshipGame();
      assertEquals(false, game.isGridSizeValid(11));
   }
   
   @Test
   @DisplayName("Game Initializes with in range grid")
   public void gridInRange(){
      BattleshipGame game = new BattleshipGame();
      assertEquals(true, game.isGridSizeValid(7));
   }

}

