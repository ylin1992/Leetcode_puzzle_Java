package DynamicProgramming;

/**
 * dp[i][j] means the maximum length of the square whose bottom right corner is i, j
 * [1,1,1]
 * [1,1,1]
 * [1,1,1]
 * then, dp[i,j] =
 * [1,1,1]
 * [1,2,2]
 * [1,2,3]
 *
 * recurrence formula: dp[i][j] = min(dp[i-1][j], dp[i][j-1, dp[i-1][j-1]) + 1 if matrix[i][j] == '1'
 *                      else: dp[i][j] = 0
 */
public class _221_MaximalSquare {
   public int maximalSquare(char[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] dp = new int[m][n];
      int max = 0;
      for (int i = 0; i < m; i++) {
         dp[i][0] = matrix[i][0] - '0';
         max = Math.max(dp[i][0], max);
      }

      for (int i = 0; i < n; i++) {
         dp[0][i] = matrix[0][i] - '0';
         max = Math.max(dp[0][i], max);
      }

      for (int i = 1; i < m; i++) {
         for (int j = 1; j < n; j++) {
            if (matrix[i][j] == '1') {
               dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
               max = Math.max(dp[i][j], max);
            }
         }
      }
      return max * max;
   }
}
