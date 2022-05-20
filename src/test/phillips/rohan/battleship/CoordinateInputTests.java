package test.phillips.rohan.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.CoordinateInput;

import java.util.*;

public class CoordinateInputTests {

   private CoordinateInput input;

   @Before  
   public void initInput(){
      this.input =  new CoordinateInput();
   }

   @Test
   @DisplayName("Test Initialized")
   public void testInitialized(){

      assertEquals(false, input.isComplete());
      assertEquals("", input.getStart());
      assertEquals("", input.getEnd());
   }

   @Test
   @DisplayName("Test setIsComplete")
   public void testSetIsComplete(){
      input.setIsComplete(false);
      assertEquals(false, input.isComplete());

      input.setIsComplete(true);
      assertEquals(true, input.isComplete());
   }
   
   @Test
   @DisplayName("Test getCoordinateList")
   public void testGetCoordinateList(){
      List<String> list = Arrays.asList("A1", "A2", "A3");
      input = new CoordinateInput("A1", "A3");

      assertEquals(list, input.getCoordinateList());

      List<String> list1 = Arrays.asList("A1", "B1", "C1");
      input = new CoordinateInput("A1", "C1");
      assertEquals(list1, input.getCoordinateList());
   }

  
}
