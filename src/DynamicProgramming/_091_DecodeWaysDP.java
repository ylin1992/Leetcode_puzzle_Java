package DynamicProgramming;

public class _091_DecodeWaysDP {
    /**
     *  1 1 1 0 6
     *        i
     *  if i = 2
     *      it can be
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            int prefix = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if (prefix <= 26 && prefix >= 10) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

}
