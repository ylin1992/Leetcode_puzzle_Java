package SnowFlake;

import java.util.Arrays;

public class ShrinkingNumberLine {
   public static int minimize(int[] points, int k) {
      Arrays.sort(points);
      int res = points[points.length - 1] - points[0];
      int lastDec = points[points.length - 1] - k;
      int firstInc = points[0] + k;
      for (int i = 0; i < points.length - 1; i++) {
         int curInc = points[i] + k;
         int nextDec = points[i+1] - k;
         int diff = Math.max(curInc, lastDec) - Math.min(nextDec, firstInc);
         res = Math.min(diff, res);
      }
      return res;
   }

   public static void main(String[] args) {
      System.out.println(minimize(new int[]{0,1,2,3}, 2));
   }
}
