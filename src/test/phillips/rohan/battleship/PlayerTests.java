package test.phillips.rohan.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

import main.phillips.rohan.battleship.Player;
import main.phillips.rohan.battleship.ships.Ship;
import main.phillips.rohan.battleship.ships.Carrier;
import main.phillips.rohan.battleship.ships.Destroyer;

public class PlayerTests {
   private int gridSize = 10;

   public Player setupPlayer(boolean isComputer){
      return new Player(10, 1, isComputer);
   }

   @Test
   @DisplayName("Create Player")
   public void testCreatePlayer(){

      assertEquals(setupPlayer(true).getPieceBoard().getClass(), main.phillips.rohan.battleship.board.Board.class);
      assertEquals(setupPlayer(true).getGuessboard().getClass(), main.phillips.rohan.battleship.board.Board.class);
   }

   @Test
   @DisplayName("Test PlayerNumber")
   public void getPlayerNumber(){
      Player player = setupPlayer(true);

      assertEquals(true, player.getPlayerNumber() == 1);

      player.setPlayerNumber((2));
      assertEquals(true, player.getPlayerNumber() == 2);
   }

   @Test
   @DisplayName("Test isComputer")
   public void testForIsComputer(){
      Player player = setupPlayer(false);

      assertEquals(false, player.getIsComputer());

      player.setIsComputer(true);
      assertEquals(true, player.getIsComputer());
   }

   @Test
   @DisplayName("Test ship exists")
   public void testForShip(){
      Carrier ship1 = new Carrier();
      Destroyer ship2 = new Destroyer();

      Player player = new Player(gridSize, 1, false);
      player.addShip(ship2);
      assertEquals(false, player.shipExists(ship1));

      player.addShip(ship1);
      assertEquals(true, player.shipExists(ship1));
   }

   @Test
   @DisplayName("Test getShip")
   public void testGetShip(){
      
      Carrier ship1 = new Carrier();
      Player player = new Player(gridSize, 1, false);      

      assertEquals(Ship.ShipType.NOTSET, player.getShip(Ship.ShipType.CARRIER).getShipType());

      player.addShip(ship1);
      assertEquals(Ship.ShipType.CARRIER, player.getShip(Ship.ShipType.CARRIER).getShipType());

   }

   @Test
   @DisplayName("Get player ship list")
   public void getPlayerShipList(){
      Player player = new Player(gridSize, 1, false); 
      Carrier ship1 = new Carrier();
      List<Ship.ShipType> ships = new ArrayList<>();

      assertEquals(ships, player.shipList());

      ships.add(Ship.ShipType.CARRIER);
      player.addShip(ship1);

      assertEquals(ships, player.shipList());
      
   }
}
