package DynamicProgramming;

public class _005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;
        if (n == 2) return s.charAt(0) == s.charAt(1) ? s : s.substring(0,1);

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j - i < 3) || dp[i+1][j-1];
                }
            }
        }

        int start = 0;
        int end = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) {
                    if (j - i > maxLength) {
                        maxLength = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
