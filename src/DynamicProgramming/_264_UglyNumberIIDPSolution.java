package DynamicProgramming;

public class _264_UglyNumberIIDPSolution {
   // dp[p] means the p-th ugly number
   // observing the sequence, we can get:
   // sequence of 2 : [2x1, 2x2, 2x3, 2x4, 2x5 ....]
   // sequence of 3 : [3x1, 3x2, 3x3, 3x4, 3x5 ....]
   // sequence of 5 : [5x1, 5x2, 5x3, 5x4, 5x5 ....]
   // And what we want to do is to sort the sequence and pick the n-th element as the returned value
   // In every loop, we pick the smallest value among the three sequences (the head of the three sequences)
   // , insert the smallest one into our dp array, finally return dp[n]
   //
   // We also need 3 indices keeping track of where the heads of the subsequnces are (i, j, k)
   // Recurrence Formula: dp[p] = min(dp[i]*2, dp[j]*3, dp[k]*5), i j k are the heads of the 3 sequences
   // Increase the index if the sequence is picked in this iteration.
   public int nthUglyNumber(int n) {
      int[] dp = new int[n + 1];
      if (n == 1) return 1;

      dp[1] = 1;
      int i = 1;
      int j = 1;
      int k = 1;
      for (int p = 2; p <= n; p++) {
         dp[p] = Math.min(Math.min(dp[i] * 2, dp[j] * 3), dp[k] * 5);
         if (dp[p] == dp[i] * 2)
            i++;
         if (dp[p] == dp[j] * 3)
            j++;
         if (dp[p] == dp[k] * 5)
            k++;
      }
      return dp[n];
   }

}
