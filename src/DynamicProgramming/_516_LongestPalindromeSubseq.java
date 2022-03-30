package DynamicProgramming;

public class _516_LongestPalindromeSubseq {
   // dp[i][j] means length of the longeest palidromic subsequence in substring(i,j)
   // initially dp[i][i] = 1 (itself is a palindrome)
   // x = s[i] == s[i+1] ? 2 : 1
   // recurrence formula
   // dp[i][j] = dp[i+1][j-1] + 2, if s[i] == s[j]
   // dp[i][j] = max(dp[i+1][j], dp[i-1],[j]), otherwis
   // example for case 2:
   // consider (1, 6), s[1] != s[6]
   // the longest p. subsequence from 1 to 6 is max of (1, 5) or (2, 6) since s[1] != s[6]
   //   a b c c d a c b
   //   0 1 2 3 4 5 6 7
   // 0 1 x
   // 1   1 x
   // 2     1 x
   // 3       1 x
   // 4         1 x
   // 5           1 x
   // 6             1 x
   // 7               1

   // traverse bottom-up

   public int longestPalindromeSubseq(String s) {
      int n = s.length();
      int[][] dp = new int[n][n];

      int max = 1;
      for (int i = 0; i < n; i++) {
         dp[i][i] = 1;
         if (i + 1 < n) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 2 : 1;
            max = Math.max(dp[i][i+1], max);
         }
      }

      for (int i = n - 3; i >= 0; i--) {
         for (int j = i + 2; j < n; j++) {
            if (s.charAt(i) == s.charAt(j)) {
               dp[i][j] = dp[i+1][j-1] + 2;
            } else {
               dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
            max = Math.max(dp[i][j], max);
         }
      }
      return max;
   }
}
