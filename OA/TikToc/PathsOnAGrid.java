package OA.TikToc;
// Given a grid, how many path are there from (0,0) to (n,m)
// In each step, only (x+1,y) and (x,y+1) are allowed
// 60% of data: n >= 1, m <= 10
// 100% fo dara: n >= 1, m <= 30

// DP
// DP[i,j] means the number of ways we can reach grid(i,j)
// DP[0,0] = 1 (don't go any step)
// DP[0,1] = 1, DP[0,2] = 1, DP[0,3] = 1, ... DP[0,j] = 1 (all the way right, only one way)
// DP[j,0] = 1 (all the way down, only one way)
// Transition:
//    DP[i,j] = DP[i-1,j] + DP[i,j-1]
// Return:
//    DP[n,m]
// Space: O(mn)
// Time: O(mn)
public class PathsOnAGrid {
   // suppose n : rows
   //         m : cols
   public static long solve(int n, int m) {
      long[][] dp = new long[n+1][m+1];

      // Initialized the dp array
      for (int i = 1; i < n + 1; i++) {
         dp[i][0] = 1;
      }
      for (int j = 1; j < m + 1; j++) {
         dp[0][j] = 1;
      }

      // Transition
      for (int i = 1; i < n + 1; i++) {
         for (int j = 1; j < m + 1; j++) {
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
         }
      }
      return dp[n][m];
   }

   public static void main(String[] args) {
      System.out.println(solve(30,30));
   }
}
