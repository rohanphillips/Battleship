package test.phillips.rohan.battleship.ships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.ships.Ship;
import main.phillips.rohan.battleship.ships.Ship.ShipType;

public class ShipTests {

   @Test
   @DisplayName("Test Ship on initiated")
   public void notInitiated(){
      Ship ship = new Ship();

      assertEquals(true, ship.getShipLength() == -1);
   }
   
   @Test
   @DisplayName("Ship functionality")
   public void testShip(){
      Ship ship = new Ship();

      ship.setShipType(Ship.ShipType.BATTLESHIP);

      assertEquals(Ship.ShipType.BATTLESHIP, ship.getShipType());
   }

   @Test
   @DisplayName("Test Ship enum")
   public void testEnum(){
      assertEquals(5, ShipType.CARRIER.getLength());
      assertEquals(4, ShipType.BATTLESHIP.getLength());
      assertEquals(3, ShipType.CRUISER.getLength());
      assertEquals(3, ShipType.SUBMARINE.getLength());
      assertEquals(2, ShipType.DESTROYER.getLength());
   }

}
