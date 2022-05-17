package Battleship;

public class Player {
   private int playerNumber;
   private boolean isComputer;
   private Board pieceBoard;
   private Board guessBoard;

   public Player(int gridsize, int playerNumber, boolean isComputer){
      this.pieceBoard = new Board(gridsize);
      this.guessBoard = new Board(gridsize);
      this.playerNumber = playerNumber;
      this.isComputer = isComputer;
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

   public void setIsComputer(boolean isComputer){
      this.isComputer = isComputer;
   }

   public boolean getIsComputer(){
      return this.isComputer;
   }

}
