package test.phillips.rohan.battleship.board;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.phillips.rohan.battleship.CoordinateInput;
import main.phillips.rohan.battleship.board.Coordinates;
import main.phillips.rohan.battleship.board.OrientationInfo;

public class CoordinatesTests {

   public static <E, A> void assertListEquals(BiConsumer<E, A> asserter, List<E> expected, List<A> actual) throws AssertionError {
      assertEquals(expected.size(),
              actual.size());
  
      for (int i = 0; i < expected.size(); i++) {
          try {
              asserter.accept(expected.get(i), actual.get(i));
          } catch (AssertionError e) {
              throw e;
          }
      }
  }

   private void assertPairEqual(Pair expected, Pair actual){
      assertEquals(expected.getStart(), actual.getStart());
      assertEquals(expected.getEnd(), actual.getEnd());
   }
   
   @Test
   @DisplayName("Get column letter")   
   public void getLetter(){
      
     String col = Coordinates.Column.get(1);
      assertEquals("B" , col);
   }

   @Test
   @DisplayName("Check Valid Input Length")
   public void checkInputLength(){
      assertEquals(true, Coordinates.isValidLength("A1"));
      assertEquals(false, Coordinates.isValidLength("t"));
   }

   @Test
   @DisplayName("Check if valid coordinate pair")
   public void checkValidInputPair(){
      assertEquals(false, Coordinates.isValidPair("11", 10));
      assertEquals(false, Coordinates.isValidPair("111", 10));
      assertEquals(false, Coordinates.isValidPair("A11", 10));
      assertEquals(false, Coordinates.isValidPair("A0", 10));
      assertEquals(false, Coordinates.isValidPair("K1", 10));

      assertEquals(true, Coordinates.isValidPair("A1", 10));
      assertEquals(true, Coordinates.isValidPair("J1", 10));
   }

   @Test
   @DisplayName("Get Coordinates")
   public void getCoordinates(){
      int[] expect = new int[] {0, 0};
      assertArrayEquals(expect, Coordinates.getCoordinates("A1", 10));
      assertArrayEquals(expect, Coordinates.getCoordinates("a1", 10));

      int[] expect1 = new int[] {0, 9};
      assertArrayEquals(expect1, Coordinates.getCoordinates("A10", 10));
      
      int[] expect2 = new int[] {-1, -1};
      assertArrayEquals(expect2, Coordinates.getCoordinates("10", 10));
   }

   @Test
   @DisplayName("Test Orientation")
   public void testOrientation(){
      assertEquals(true, Coordinates.isValidOrientation("A1", "A4", 10).getIsValid());
      assertEquals(true, Coordinates.isValidOrientation("A1", "D1", 10).getIsValid());

      assertEquals(false, Coordinates.isValidOrientation("A1", "b4", 10).getIsValid());

      assertEquals(false, Coordinates.isValidOrientation("A7", "a11", 10).getIsValid());
      assertEquals(false, Coordinates.isValidOrientation("A0", "a4", 10).getIsValid());
      assertEquals(false, Coordinates.isValidOrientation("F7", "l7", 10).getIsValid());
   }

   @Test
   @DisplayName("Verify Orientation Info")
   public void testOrientationInfo(){
      OrientationInfo info = new OrientationInfo(false, "A", 1, "B", 2);
      assertEquals("A", info.getColumn(1));
      assertEquals(1, info.getRow(1));
      assertEquals("B", info.getColumn(2));
      assertEquals(2, info.getRow(2));

      assertEquals(false, info.getIsValid());
      
   }

   @Test
   @DisplayName("Test get Coordinate Pair")
   public void testCoordinatePair(){
      assertEquals("A1", Coordinates.getCoordinatePair(0, 0));
      assertEquals("C5", Coordinates.getCoordinatePair(4, 2));
   }

   @Test
   @DisplayName("test getrow")
   public void testGetRow(){
      assertEquals(0, Coordinates.getRow("a1"));
      assertEquals(0, Coordinates.getRow("11"));
      assertEquals(119, Coordinates.getRow("a120"));

      assertEquals(-1, Coordinates.getRow("aa"));
   }

   @Test
   @DisplayName("test getcolumn")
   public void testGetColumn(){
      assertEquals("A", Coordinates.getColumn("A1"));

      assertEquals("1", Coordinates.getColumn("11"));
   }

   @Test
   @DisplayName("Test Orientation Lengths")
   public void testOrientationLengths(){
      
      assertEquals(4, Coordinates.getOrientationLength(new Pair("A1", "A4")));

      assertEquals(4, Coordinates.getOrientationLength(new Pair("A1", "D1")));
   }

   /**
    * Test that two pairs are returned for a valid starting location, one for horizontal, one for vertical
    */
   @Test
   @DisplayName("Test getCoordinateFromSingle Valid")
   public void testGetCoordinateFromSingleValid(){
      String  loc = "A1";
      
      InputStream stdin = System.in;
      ByteArrayInputStream stream = new ByteArrayInputStream(loc.getBytes());
      List<Pair> list = new ArrayList<>();      

      System.setIn(stream);
      Scanner scanner = new Scanner(System.in);
      CoordinateInput c = new CoordinateInput(scanner);
      
      list.add(new Pair("A1", "A4"));
      list.add(new Pair("A1", "D1"));

      List<Pair> result = c.getCoordinatesFromSingle(10, 4);

      assertListEquals(this::assertPairEqual, list, result);
      scanner.close();
            
      System.setIn(stdin);

   }

   /**
    * Test that only one pair is returned, a valid horizontal location without a vertical
    */
   @Test
   @DisplayName("Test getCoordinateFromSingle InValid Vertical")
   public void testGetCoordinateFromSingleInvalidV(){
      String  loc = "A8";
      
      InputStream stdin = System.in;
      ByteArrayInputStream stream = new ByteArrayInputStream(loc.getBytes());
      List<Pair> list = new ArrayList<>();      

      System.setIn(stream);
      Scanner scanner = new Scanner(System.in);
      CoordinateInput c = new CoordinateInput(scanner);
      
      list.add(new Pair("A8", "D8"));

      List<Pair> result = c.getCoordinatesFromSingle(10, 4);

      assertListEquals(this::assertPairEqual, list, result);
      scanner.close();
            
      System.setIn(stdin);
   }

   /**
    * Test that only one pair is returned, a valid vertical location without a vertical
    */
    @Test
    @DisplayName("Test getCoordinateFromSingle InValid Horizontal")
    public void testGetCoordinateFromSingleInvalidH(){
       String  loc = "H3";
       
       InputStream stdin = System.in;
       ByteArrayInputStream stream = new ByteArrayInputStream(loc.getBytes());
       List<Pair> list = new ArrayList<>();      
 
       System.setIn(stream);
       Scanner scanner = new Scanner(System.in);
       CoordinateInput c = new CoordinateInput(scanner);
       
       list.add(new Pair("H3", "H6"));
 
       List<Pair> result = c.getCoordinatesFromSingle(10, 4);
 
       assertListEquals(this::assertPairEqual, list, result);
       scanner.close();
             
       System.setIn(stdin);
    }

}
