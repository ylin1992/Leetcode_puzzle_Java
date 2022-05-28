package Intervals;

import java.util.Arrays;

// sort by ending time, the problem is equivalent to the "maximum interval problem"
// given several requests, pick the maximum number of requests that don't overlap

// [1,2] [1,3] [2,3] [3,4]
// pick the earliest ending time first
// if new la >= current max ra, count + 1, else skip it
// at then end, the count represents the number of non-overlapping intervals we pick
// and intervals.length - count is the number of intervals we should remove

public class _435_NonOverlappingIntervals {
   public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> (Integer.compare(a[1], b[1])));
      int count = 0;
      int r = Integer.MIN_VALUE;

      for (int i = 0; i < intervals.length; i++) {
         int[] interval = intervals[i];
         if (interval[0] < r) continue;
         count++;
         r = interval[1];
      }
      return intervals.length - count;
   }
}
