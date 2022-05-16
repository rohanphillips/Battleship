

import Battleship.BattleshipGame;

public class App {
    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.initGame();
        if(game.getInitialized()){
			System.out.println("Game Initialized.... Let's play");
			while(game.getInProgress()){
				game.setInProgress(false);
			}
		} else {
			System.out.println("Game did not initialize");
		}
    }
}
