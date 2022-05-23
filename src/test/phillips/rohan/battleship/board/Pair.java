package test.phillips.rohan.battleship.board;

public class Pair {
   private String start;
   private String end;

   public Pair(){
      this.start = "";
      this.end = "";
   }

   public Pair(String start, String end){
      this.start = start.toUpperCase();
      this.end = end.toUpperCase();
   }

   public void setStart(String start){
      this.start = start;
   }

   public String getStart(){
      return start;
   }

   public void setEnd(String end){
      this.end = end;
   }

   public String getEnd(){
      return end;
   }
}
