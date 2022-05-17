package Battleship;

public class Player {
   private int playerNumber;
   private Board pieceBoard;
   private Board guessBoard;

   public Player(int gridsize){
      this.pieceBoard = new Board(gridsize);
      this.guessBoard = new Board(gridsize);
      this.playerNumber = 0;
   }

   public void setPlayerNumber(int num){
      this.playerNumber = num;
   }

   public int getPlayerNumber(){
      return this.playerNumber;
   }

   public Board getPieceBoard(){
      return this.pieceBoard;
   }

   public Board getGuessboard(){
      return this.guessBoard;
   }
}
