package DynamicProgramming;

import java.util.Arrays;

public class _256_PaintHouse {
   // dp[i][j]: min cost for painting {0~i} houses with the i-th house painted with j-th color
   // dp[i][j] = min(dp[i-1][k]) + costs[i][j] for k other than j
   // initialization
   // dp[n][3]
   // dp[0][0] = nums[0][0]
   // dp[0][1] = nums[0][1]
   // dp[0][2] = nums[0][2]
   // return min(dp[n-1][:])
   public int minCost(int[][] costs) {
      int n = costs.length;
      int[][] dp = new int[n][3];
      for (int i = 0; i < n; i++) {
         Arrays.fill(dp[i], Integer.MAX_VALUE);
      }

      dp[0][0] = costs[0][0];
      dp[0][1] = costs[0][1];
      dp[0][2] = costs[0][2];

      for (int i = 1; i < n; i++) {
         for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
               if (k == j)
                  continue;
               dp[i][j] = Math.min(dp[i-1][k] + costs[i][j], dp[i][j]);
            }
         }
      }
      return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
   }
}
