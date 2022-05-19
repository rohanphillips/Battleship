package test.phillips.rohan.battleship.ships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;
import java.util.stream.Collectors;

import main.phillips.rohan.battleship.ships.Ship;
import main.phillips.rohan.battleship.ships.Ship.ShipType;
import main.phillips.rohan.battleship.ships.Carrier;
import main.phillips.rohan.battleship.ships.Battleship;
import main.phillips.rohan.battleship.ships.Cruiser;
import main.phillips.rohan.battleship.ships.Submarine;
import main.phillips.rohan.battleship.ships.Destroyer;

public class ShipTests {

   @Test
   @DisplayName("Test Ship enum")
   public void testEnum(){
      assertEquals(5, ShipType.CARRIER.getLength());
      assertEquals(4, ShipType.BATTLESHIP.getLength());
      assertEquals(3, ShipType.CRUISER.getLength());
      assertEquals(3, ShipType.SUBMARINE.getLength());
      assertEquals(2, ShipType.DESTROYER.getLength());
   }

   @Test
   @DisplayName("Test Ship on initiated")
   public void notInitiated(){
      Ship ship = new Ship();

      assertEquals(true, ship.getShipLength() == -1);
   }

   @Test
   @DisplayName("Test Carrier")
   public void testCarrier(){
      Carrier ship = new Carrier();
      assertEquals(ShipType.CARRIER, ship.getShipType());
   }

   @Test
   @DisplayName("Test Battleship")
   public void testBattleship(){
      Battleship ship = new Battleship();
      assertEquals(ShipType.BATTLESHIP, ship.getShipType());
   }

   @Test
   @DisplayName("Test Cruiser")
   public void testCruiser(){
      Cruiser ship = new Cruiser();
      assertEquals(ShipType.CRUISER, ship.getShipType());
   }

   @Test
   @DisplayName("Test Submarine")
   public void testSubmarine(){
      Submarine ship = new Submarine();
      assertEquals(ShipType.SUBMARINE, ship.getShipType());
   }

   @Test
   @DisplayName("Test Destroyer")
   public void testDestroyer(){
      Destroyer ship = new Destroyer();
      assertEquals(ShipType.DESTROYER, ship.getShipType());
   }
   
   @Test
   @DisplayName("Ship functionality")
   public void testShip(){
      Ship ship = new Ship();

      ship.setShipType(Ship.ShipType.BATTLESHIP);

      assertEquals(Ship.ShipType.BATTLESHIP, ship.getShipType());
   }

   @Test
   @DisplayName("Ship List available")
   public void getShipList(){
      List<String> ships = new ArrayList<>();
      ships.add("BATTLESHIP");
      ships.add("CARRIER");      
      ships.add("CRUISER");
      ships.add("DESTROYER");
      ships.add("SUBMARINE");
      
      assertEquals(ships, Ship.ShipType.getList());
   }

}
