package OA.SnowFlake;

public class PathToAGoal {
   static int MOD = 1000000007;
   public static int solve(char[] s, int n, int x, int y) {
      // Prevent duplicates
      // i.e. r  r  l r l r
      //      -1 0 -1 1 2 3
      // since r@0 and r@1 is actually the same, when performing dp without taking care
      // of this, duplicates will be counted.
      // Tp prevent, we need to subtract the previous one's dp value
      // dp[i][j] -= dp[ prevSame[i-1][j-1 or j+1] ][j-1 or j+1]
      int[] prevSame = new int[s.length];
      int idxL = -1;
      int idxR = -1;
      for (int i = 0; i < prevSame.length; i++) {
         if (s[i] == 'l') {
            prevSame[i] = idxL;
            idxL = i;
         } else {
            prevSame[i] = idxR;
            idxR = i;
         }
      }

      // dp[i][j] is number of distinct subsequences of length i to end up at j
      // dp[i-1][j] means we don't take current character into account
      long[][] dp = new long[s.length+1][n+1];
      dp[0][x] = 1;
      for (int i = 1; i <= s.length; i++) {
         for (int j = 0; j <= n; j++) {
            dp[i][j] = dp[i-1][j];
            if (s[i-1] == 'l') {
               if (j+1 <= n) dp[i][j] += dp[i-1][j+1];
               if (j+1 <= n && prevSame[i-1] >= 0) dp[i][j] -= dp[prevSame[i-1]+1-1][j+1];
            } else {
               if (j-1 >= 0) dp[i][j] += dp[i-1][j-1];
               if (j-1 >= 0 && prevSame[i-1] >= 0) dp[i][j] -= dp[prevSame[i-1]+1-1][j-1];
            }
            dp[i][j] = (dp[i][j] + MOD) % MOD;
         }
      }
      return (int) dp[s.length][y];
   }

   public static void main(String[] args) {
      System.out.println(solve(new char[]{'r','r', 'l', 'r', 'l', 'r'}, 6, 1, 4));
   }
}
