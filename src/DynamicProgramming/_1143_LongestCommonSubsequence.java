package DynamicProgramming;

public class _1143_LongestCommonSubsequence {
   // "" a c e d
   // "" a b c d e
   // dp[i,j] means given x.substring(0,i) and y.substring(0,j), dp[i,j] = longest common subsequance of the two substrings.
   // if x[i] == y[j]: dp[i,j] = dp[i-1, j-1] + 1, exclude the last element of both two substrings
   // if x[i] != y[j]: dp[i,j] = max(dp[i-1, j], dp[i, j-1]), exclude the last ele of one of the substrings
   // initialization:
   // dp[len(x+1)][len(y+1)]
   // dp[0,:] = 0, dp[:, 0] = 0
   // return dp[len(x), len(y)]
   public int longestCommonSubsequence(String text1, String text2) {
      int n1 = text1.length();
      int n2 = text2.length();
      int[][] dp = new int[n1+1][n2+1];

      for (int i = 0; i < n1; i++)
         dp[n1][0] = 0;
      for (int i = 0; i < n2; i++)
         dp[0][n2] = 0;

      for (int i = 1; i < n1 + 1; i++) {
         for (int j = 1; j < n2 + 1; j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1)) // string is 0-indexed, but dp is 1-indexed
               dp[i][j] = dp[i-1][j-1] + 1;
            else
               dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
         }
      }
      return dp[n1][n2];
   }
}
