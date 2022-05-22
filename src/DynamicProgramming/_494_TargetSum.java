package DynamicProgramming;
// dp[i][j] means the ways we can sum up to j considering 0 ~ i elements
// return dp[nums.length-1][target]

// dp[0][0] = 1
// dp[i][j] += dp[i-1][j-nums[i]], dp[i-1][j+nums[i]]

//   -5 -4 -3 -2 -1  0  1  2  3  4  5
// 0'             0  1
// 0              1     1
// 1
// 2
// 3
// 4
// 5
public class _494_TargetSum {
   public int findTargetSumWays(int[] nums, int target) {
      int sum = 0;
      for (int num : nums) {
         sum += num;
      }

      if (Math.abs(target) > sum) return 0;

      int n = nums.length;
      int m = sum*2+1;
      int[][] dp = new int[n+1][m];
      dp[0][sum] = 1;
      for (int i = 1; i <= n; i++) {
         for (int j = 0; j < m; j++) {
            if (j+nums[i-1] < m) dp[i][j] += dp[i-1][j+nums[i-1]];
            if (j-nums[i-1] >= 0) dp[i][j] += dp[i-1][j-nums[i-1]];
         }
      }
      return dp[n][sum + target];
   }
}
