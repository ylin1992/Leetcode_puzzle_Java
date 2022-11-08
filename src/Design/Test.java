package Design;

import java.awt.*;

public class Test {
   private int x ;
   private int y;

   public static void main(String[] args) {
      Point p1 = new Point(1,2);
      Point p2 = new Point(1,2);
      System.out.println(p1.hashCode() == p2.hashCode());
   }
}
