package test.phillips.rohan.battleship.ships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.ships.Carrier;
import main.phillips.rohan.battleship.ships.Ship.ShipType;

public class CarrierTests {
   
   @Test
   @DisplayName("Verify Carrier set")
   public void isCarrier(){
      Carrier ship = new Carrier();

      assertEquals(ShipType.CARRIER, ship.getShipType());
   }
}
