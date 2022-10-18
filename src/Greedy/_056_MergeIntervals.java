package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _056_MergeIntervals {
   public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, new Comparator<int[]>() {
         @Override
         public int compare(int[] a, int[] b) {
            return a[0] - b[0];
         }
      });

      List<Integer[]> list = new ArrayList<>();

      // first starting time and first ending time
      int left = intervals[0][0];
      int right = intervals[0][1];
      for (int i = 1; i < intervals.length; i++) {
         // System.out.println(i + " " + left + " " + right);
         int nextLeft = intervals[i][0];
         if (nextLeft <= right)
            right = Math.max(right, intervals[i][1]);
         else {
            Integer[] interval = new Integer[] {left, right};
            list.add(interval);
            left = nextLeft;
            right = intervals[i][1];
         }
         // System.out.println(i + " " + left + " " + right);
      }
      list.add(new Integer[] {left, right});
      int[][] res = new int[list.size()][2];
      for (int i = 0; i < list.size(); i++) {
         res[i][0] = list.get(i)[0];
         res[i][1] = list.get(i)[1];
      }
      return res;
   }


}
