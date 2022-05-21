package main.phillips.rohan.battleship.menu;

import java.util.*;

public class Menu {

   private Scanner userInput;
   private List<String> menuItems;
   private boolean isExitSelected;
   public static void main(String[] args) {
      Menu menu = new Menu();
      menu.addMenuItem("Test");
      menu.addMenuItem("Exit");
      System.out.println(menu.getSelection() + " was selected");
   }

   public Menu(){
      userInput = new Scanner(System.in);
      menuItems = new ArrayList<>();
   }

   public Menu(Scanner input, List<String> list, String exitString){
      userInput = input;
      menuItems = new ArrayList<>(list);
      menuItems.add(exitString);
   }

   public int getSelection(){
      int input = -1;
      menuItems.forEach(s -> System.out.println((menuItems.indexOf(s) + 1) + ": " + s));
      while(input == -1){
         try{
            input = Integer.parseInt(userInput.nextLine());
         }
         finally{
            isExitSelected = input == menuItems.size();
         }
      }
      return input;
   }

   public void addMenuItem(String str){
      menuItems.add(str);
   }   

   public boolean isExitSelected(){
      return isExitSelected;
   }

   public void setIsExitSelected(boolean set){
      isExitSelected = set;
   }

}
