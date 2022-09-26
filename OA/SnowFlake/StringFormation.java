package OA.SnowFlake;
// n = words.length
// m = words[0].length()
// dp[i][j]: construct target[0:i] using word[0:j]
// i from 1 to target.length(), j from 0 to word[0].length
// 1. do not pick word[j] => dp[i][j] = dp[i][j-1]
// 2. pick word[j]:
//    if (target[i] exists in word[j])
//       dp[i][j] += dp[i-1][j-1] * count, where count is the number of word[j] in words
//       example:
//       acca
//       bbbb
//       caca
//       when j = 2, then count of 'c' is 2

public class StringFormation {
   public static int M = (int)1e9 + 7;
   public int numWays(String[] words, String target) {
      int n = target.length(), m = words[0].length();
      long[][] counts = new long[m+1][26];
      long[][] dp = new long[n+1][m+1];

      // construct counts    a  b  c  ....  z
      //       acca        0 1  1  1
      //       bbbb   ==>  1 1  1  1
      //       caca        2 0  1  2
      //                   3 2  1  0
      for (String word : words) {
         char[] chs = word.toCharArray();
         for (int i = 0; i < chs.length; i++)
            counts[i+1][chs[i] - 'a']++;
      }
      // dp[0][j] should all be 1 (do not pick any word[j] to form target[0:0])
      for (int j = 0; j < m; j++) {
         dp[0][j] = 1;
      }

      target = "-" + target;
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= m; j++) {
            dp[i][j] = dp[i][j-1]; // do not pick word[j]
            char c = target.charAt(i);
            if (counts[j][c - 'a'] > 0) {
               dp[i][j] += dp[i-1][j-1] * counts[j][c - 'a'] % M;
            }
            dp[i][j] %= M;
         }
      }
      return (int)dp[n][m];
   }
}
