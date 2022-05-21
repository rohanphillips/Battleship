package main.phillips.rohan.battleship.menu;

public class MainMenu extends Menu {
   
   public MainMenu(){
      this.addMenuItem("Initialize Game");
      this.addMenuItem("Set Player1 Status");
      this.addMenuItem("Set Player2 Status");
      this.addMenuItem("Player 1 Choose Ships");
      this.addMenuItem("Player 2 Choose Ships");
      this.addMenuItem("Play!");
      this.addMenuItem("Quit");

   }
}
