package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _056_MergeIntervals {
   public int[][] merge(int[][] intervals) {
      List<int[]> list = new ArrayList<>();
      Arrays.sort(intervals, new Comparator<int[]>() {
         @Override
         public int compare(int[] a, int[] b) {
            return a[0] - b[0];
         }
      });
      // equivalent to:
      //Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
      int l = intervals[0][0];
      int r = intervals[0][1];
      for (int i = 1; i < intervals.length; i++) {
         int[] interval = intervals[i];
         if (interval[1] <= r) continue; // [1,8] [2,4], [4,6] => skip [2,4] [4,6]
         if (interval[0] <= r) {
            l = Math.min(l, interval[0]);
            r = Math.max(r, interval[1]); // actually don't need to compare because we already eliminate the case of interval[1] < r
         } else {
            list.add(new int[]{l, r});
            l = interval[0];
            r = interval[1];
         }
      }
      // take care of the last one
      list.add(new int[]{l, r});
      int[][] res = new int[list.size()][2];
      for (int i = 0; i < list.size(); i++) {
         res[i] = list.get(i);
      }

      return res;
   }
}
