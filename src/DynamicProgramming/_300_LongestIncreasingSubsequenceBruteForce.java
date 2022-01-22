package DynamicProgramming;
import java.util.Arrays;

/**
 * Brute force DP solution
 * Spends O(n^2) time and O(n) space
 */
public class _300_LongestIncreasingSubsequenceBruteForce {
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
