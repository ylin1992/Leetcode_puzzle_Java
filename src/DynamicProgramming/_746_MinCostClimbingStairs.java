package DynamicProgramming;

public class _746_MinCostClimbingStairs {
   public int minCostClimbingStairs(int[] cost) {
      if (cost.length == 2) return Math.min(cost[0], cost[1]);
      int[] dp = new int[cost.length];
      dp[0] = 0;
      dp[1] = 0;

      for (int i = 2; i < cost.length; i++) {
         dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
      }
      return Math.min(dp[cost.length - 1] + cost[cost.length - 1], dp[cost.length - 2] + cost[cost.length - 2]);
   }
}
