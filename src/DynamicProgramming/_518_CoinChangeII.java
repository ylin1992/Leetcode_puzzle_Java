package DynamicProgramming;

public class _518_CoinChangeII {
   // dp[i][j] means the number of ways that the amount j can be added up by coins[0~i]
   // dp[i][j] = dp[i-1][j] (coins[i] is not selected) + dp[i][j-coins[i]] (coins[j] is selected)
   //                                if (j < coins[i]) + 0
   // Note that for the case where coin[i] is selected, the recurrence formula is + dp[i][j-coins[i]] instead of + dp[i-1][j-coins[i]]
   // because this is an unbounded 0/1 knapsack poblem, where we can pick the same coin several times

   // initialization:
   // dp[:][0] = 1 way to make up any amount by "not picking any coin"
   // dp[0][:] = dp[0][i-coins[0]] or 0 if coins[0] > i (only using the first coin)
   //   0 1 2 3 4 5
   // 1 1 1 1 1 1 1
   // 2 1
   // 5 1
   public int change(int amount, int[] coins) {
      int[][] dp = new int[coins.length][amount+1];
      for (int i = 0; i < coins.length; i++)
         dp[i][0] = 1;
      for (int i = 1; i <= amount; i++) {
         if (coins[0] <= i) {
            dp[0][i] = dp[0][i - coins[0]];
         }
      }

      for (int j = 1; j <= amount; j++) {
         for (int i = 1; i < coins.length; i++) {
            if (coins[i] <= j) {
               dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
            } else {
               dp[i][j] = dp[i-1][j];
            }
         }
      }

      return dp[coins.length-1][amount];
   }
}
