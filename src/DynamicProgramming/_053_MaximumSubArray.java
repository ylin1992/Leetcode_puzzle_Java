package DynamicProgramming;

public class _053_MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(0, dp[i-1]);
            max = Math.max(dp[i], max);
        }
        return Math.max(dp[nums.length-1], max);
    }
}
