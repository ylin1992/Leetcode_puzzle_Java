package DynamicProgramming;
import java.util.Arrays;

/**
 * Brute force DP solution
 * Spends O(n^2) time and O(n) space
 */
public class _300_LongestIncreasingSubsequenceBruteForce {
    // dp[i] means length of an increasing subsequence ending at i
    // in other words, if we find an element before i that is smaller than nums[i]
    // dp[i] should be dp[such_index] + 1
    //
    // initialization: dp[:] = 1 (all elements are themselves a subsequence with length 1)
    // for i from 1 to n
    //      for j from 0 to i
    //         if nums[i] > nums[j], then nums[i] is an extension of subsequence ending at j
    //              dp[i] = dp[j] + 1
    //         max = max(max, dp[i])
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // O(n^2)
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // return spends O(n)
        return Arrays.stream(dp).max().orElse(0);
    }
}
