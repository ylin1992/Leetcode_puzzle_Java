package DynamicProgramming;
import java.util.*;
public class _139_WordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] means whether substring(0,i) can be segmented by words in the dict
        // dp[i] = dp[j] && dict contains substring(j, i) for any j from 0 to i
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0] = true;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if (dp[i]) break;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _139_WordBreakDP wbdp = new _139_WordBreakDP();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean res = wbdp.wordBreak("leetcode", list);
    }
}
