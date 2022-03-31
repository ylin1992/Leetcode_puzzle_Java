package DynamicProgramming;

import java.util.Arrays;

public class _279_PerfectSquares {
   //Optimized version
   // dp[i]: the least num of perfect sq nums that sum to i
   // dp[i] = min(dp[i], dp[i-j*j] + 1) for j from 1 to i-1
   // We only investigate numbers that are square and since
   // j*j itself is a square number, so length the sequence (i-j*j, j*j) is dp[i-j*j] + 1
   // hence dp[i-j*j] + 1   public int numSquaresOptimized(int n) {
   public int numSquares(int n) {
      int[] dp = new int[n+1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
         for (int j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
         }
      }
      return dp[n];
   }
   // Solution1: only beats 5%
   // dp[i]: the least num of perfect sq nums that sum to i
   // dp[i] = max(dp[i-j] + dp[j]) for j from 1 to i-1, if i is not a square
   // dp[i] = 1 if i is a square number
   // dp[6] = 1 + 1 + 4 => dp[5] + dp[1], dp[4] + dp[2]
   // dp[5] = 1 + 4
   // dp[4] = 4
   // dp[3] = 1 + 1 + 1

   // init:
   // dp[n+1]
   // dp[1] = 1
   public int numSquaresSol1(int n) {
      int[] dp = new int[n+1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
         int sqrt = (int) Math.sqrt(i);
         if (sqrt * sqrt == i) {
            dp[i] = 1;
            continue;
         }
         for (int j = 1; j <= i / 2; j++) {
            // avoid duplicate, so j < i / 2
            dp[i] = Math.min(dp[i-j] + dp[j], dp[i]);
         }
      }
      return dp[n];
   }
}
