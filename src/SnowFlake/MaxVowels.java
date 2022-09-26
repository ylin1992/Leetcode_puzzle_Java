package SnowFlake;

// dp[i][j] means the number of ways we can make a distinct word with length i, where the last j characters are vowels
// [cccccv] -> j = 0, i = 6
// if j == 0, which means the last character is a consonant
//    dp[i][j] = ( dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][k] ) * 21
// if j == i, which means all characters are vowels
//    dp[i][j] = 5^i
// if j > i, impossible
//    dp[i][j] = 0
// if j < i (else case): means to concatenate a vowel at the end, so we extend the result from [i-1][j-1]
//    dp[i][j] = dp[i-1][j-1] * 5;
// Initial states:
// dp[0][all js] = 0
// returns:
// sum = dp[n][0] + dp[n][1] + ... + dp[n][k]
public class MaxVowels {
   public static int MOD = (int) (1e9 + 7);
   public static int maxVowels(int wordLen, int maxVowels) {
      int[][] dp = new int[wordLen+1][maxVowels+1];
      int sum = 1;
      for (int i = 1; i <= wordLen; i++) {
         sum *= 21;
         dp[i][0] = sum;
         for (int j = 1; j <= maxVowels; j++) {
            if (j > i) {
               dp[i][j] = 0;
            } else if (j == i) {
               // all vowels
               dp[i][j] = (int) Math.pow(5, i);
            } else {
               dp[i][j] = dp[i - 1][j - 1] * 5;
            }
            dp[i][j] %= MOD;
            sum += dp[i][j];
         }
      }
      return sum;
   }

   public static void main(String[] args) {
      System.out.println(maxVowels(3,3));
   }
}
