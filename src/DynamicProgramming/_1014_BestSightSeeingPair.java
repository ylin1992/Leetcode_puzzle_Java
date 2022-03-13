package DynamicProgramming;

public class _1014_BestSightSeeingPair {
   // s1 = spot1
   // s2 = spot2
   // the best score formula can be represented as:
   // v[s1] + s1 + v[s2] - s2,
   // so we can keep tracking the max index of s1
   // such that v[s1] + s1 is maximum.
   // As we know v[s1] + s1 is max, we only need to
   // take care of v[s2] - s2 in each iteration
   public int maxScoreSightseeingPair(int[] values) {
      int s1 = 0; // i
      int res = values[0];

      for (int s2 = 1; s2 < values.length; s2++) {
         res = Math.max(res, values[s1] + s1 + values[s2] - s2);
         if (values[s1] + s1 < values[s2] + s2) {
            s1 = s2;
         }
      }
      return res;
   }

}
