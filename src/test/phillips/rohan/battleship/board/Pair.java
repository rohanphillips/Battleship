package test.phillips.rohan.battleship.board;

import java.util.ArrayList;
import java.util.List;

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

   public static List<String> createMenuPairList(List<Pair> pairs){
      List<String> menu = new ArrayList<>();
         pairs.forEach(p -> menu.add(p.getStart() + ".." + p.getEnd()));
      return menu;
   }
}
