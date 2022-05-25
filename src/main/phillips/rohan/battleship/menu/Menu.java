package main.phillips.rohan.battleship.menu;

import java.util.*;

public class Menu {

   private Scanner userInput;
   String menuHeader;
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
      menuHeader = "";
      menuItems = new ArrayList<>();
   }

   public Menu(Scanner input, List<String> list, String exitString){
      userInput = input;
      menuHeader = "";
      menuItems = new ArrayList<>(list);
      menuItems.add(exitString);
   }

   public int getSelection(){
      int input = -1;
      
      while(input < 1 || input > menuItems.size()){
         System.out.println(menuHeader);
         menuItems.forEach(s -> System.out.println((menuItems.indexOf(s) + 1) + ": " + s));
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

   public void setMenuHeader(String header){
      menuHeader = header;
   }

   public String getMenuHeader(){
      return menuHeader;
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
