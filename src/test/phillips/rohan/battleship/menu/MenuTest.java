package test.phillips.rohan.battleship.menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.*;

import main.phillips.rohan.battleship.menu.Menu;

public class MenuTest {
   private InputStream sysInBackup = System.in;

   public void modifyStream(String str){      
      ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
      System.setIn(in);
   }

   public void resetStream(){
      System.setIn(sysInBackup);
   }
   
   @Test
   @DisplayName("Test Menu")
   public void testMenu(){
      Menu menu = new Menu();
      menu.addMenuItem("Exit");
      modifyStream("1");
      assertEquals(1, menu.getSelection());
      resetStream();
   }
}
