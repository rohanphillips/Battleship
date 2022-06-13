package main.phillips.rohan.battleship.menu;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import main.phillips.rohan.battleship.ships.Ship.ShipType;

public class ShipMenu extends Menu {

   public ShipMenu(){
      super();
   }
   
   public ShipMenu(Scanner userInput, List<String> list, String exitString){
      super(userInput, list, exitString);
   }

   @Override
   public int getSelection(){
      int input = -1;
      
      while(input < 1 || input > menuItems.size()){
         System.out.println(menuHeader);         
         IntStream.range(0, menuItems.size()).forEach(i -> System.out.println((i + 1) + ": " + menuItems.get(i) + (i < menuItems.size() - 1 ? " (Length: " + ShipType.valueOf(menuItems.get(i)).getLength() + ")"  : "")));
         try{
            input = Integer.parseInt(userInput.nextLine());
         }
         catch(NumberFormatException ex){
            input = -1;
            System.out.println("Invalid Input.");
         }
         finally{
            isExitSelected = input == menuItems.size();
         }
      }
      return input;
   }
   
}
