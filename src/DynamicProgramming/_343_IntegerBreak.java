package DynamicProgramming;

public class _343_IntegerBreak {
   // dp[i] means the max product we can get for number i
   // dp[i] = max(dp[i-k] * k, (i-j) * j, dp[i]) for k from 1 to i - 1
   // for example:
   // suppose we've already got: 6 = 3 + 3 -> dp[6] = 9
   // then, when it comes to dp[8], we can get the maximum of dp[8] as:
   // max(dp[1] * 7, dp[2] * 6 ..., dp[6] * 2, dp[7] * 1), whose product
   // peaks at 3 + 3 + 2 => dp[6] * 2 = 18
   // or in another case, dp[8] can also be (1 * 7, 2 * 6, ..., 7 * 1)
   // which peaks at 2 * 6 = 12
   // We need to compare both cases

   // initialization:
   // dp[n+1]
   // dp[0] = 0
   // dp[1] = 1
   public int integerBreak(int n) {
      int[] dp = new int[n+1];
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
         for (int j = 1; j < i; j++) {
            int max = Math.max(dp[i-j] * j, (i-j) * j);
            dp[i] = Math.max(max, dp[i]);
         }
      }
      return dp[n];
   }
}
