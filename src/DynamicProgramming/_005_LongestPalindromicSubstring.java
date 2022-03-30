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

    // dp[i][j] means whether substring(i, j) is a palindrome
    // dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
    // explanation: b a a a b -> dp[0,4] = dp[1,3] && (b == b)
    // if substring of (0,4) is a palindrome, it must be that substring(1,3) is palindrome
    // and s[0] == s[4]


    // initially:
    //   0 1 2 3 4 5
    // 0 T x
    // 1   T x
    // 2     T x
    // 3       T x
    // 4         T x
    // 5           T

    // x: s[i] == s[i+1]
    public String longestPalindromeVer2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1) {
                dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            }
        }

        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }

        int minI = 0;
        int maxI = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) {
                    int diff = j - i;
                    max = Math.max(diff, max);
                    if (max == diff) {
                        minI = i;
                        maxI = j;
                    }
                }
            }
        }

        return s.substring(minI,maxI+1);
    }
}
