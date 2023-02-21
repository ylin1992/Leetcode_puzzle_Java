package _Array;

import java.util.ArrayList;
import java.util.List;

public class _1762_BuildingsWithAnOcean {
   /*
      Start traversing from the right, and all the way to left.
      The rightmost building is garaunteed to be an answer.
      The idea here is that if the current building we are visiting is the highest building
      than all the buildings to the right, then this building has the ocean view.
      So we can maintain a maxSoFar and keep updating value.
      If we find a building that is higher than the maxSoFar, add it to the list.
      Notice that the result here is in the reversed order as we visited from right to left.
      We need to reverse the order of the answer and store this answer to an array.
    */
   public int[] findBuildings(int[] heights) {
      List<Integer> res = new ArrayList<>();
      int maxSoFar = heights[heights.length - 1];
      res.add(heights.length - 1);
      for (int i = heights.length - 2; i >= 0; i--) {
         if (heights[i] > maxSoFar) {
            res.add(i);
            maxSoFar = heights[i];
         }
      }
      // System.out.println(res);
      int[] ans = new int[res.size()];
      for (int i = 0; i < res.size(); i++) {
         ans[i] = res.get(res.size() - 1 - i);
      }
      return ans;
   }

}
