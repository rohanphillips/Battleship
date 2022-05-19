package main.phillips.rohan.battleship.board;

public class OrientationInfo{
   private String col1;
   private String col2;
   private int row1;
   private int row2;
   private boolean isValid;

   public OrientationInfo(boolean isValid, String col1, int row1, String col2, int row2){
     this.isValid = isValid;
      this.col1 = col1;
     this.row1 = row1;
     this.col2 = col2;
     this.row2 = row2;
   }

   public String getColumn(int num){
      switch(num){
         case 2:
            return col2;
         default:
            return col1;
      }
   }

   public int getRow(int num){
      switch(num){
         case 2:
            return row2;
         default:
            return row1;
      }
   }

   public boolean getIsValid(){
      return isValid;
   }
}
