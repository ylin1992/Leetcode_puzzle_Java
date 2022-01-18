package DynamicProgramming;

public class _198_HouseRobber {
    public int rob(int[] nums) {
        int dp[][] = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            dp[0][i] = dp[1][i-1] + nums[i];
        }

        return Math.max(dp[0][nums.length-1], dp[1][nums.length-1]);
    }

}
