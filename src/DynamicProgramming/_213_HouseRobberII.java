package DynamicProgramming;

public class _213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return nums[0];
        if (nums.length == 1) return Math.max(nums[0], nums[1]);

        int rob1 = rob(nums, 0, nums.length - 2);
        int rob2 = rob(nums, 1, nums.length - 1);
        return Math.max(rob1, rob2);
    }

    private int rob(int[] nums, int start, int end) {
        int[][] dp = new int[2][nums.length];
        dp[0][start] = 0;
        dp[1][start] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            dp[1][i] = dp[0][i-1] + nums[i];
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
        }
        return Math.max(dp[0][end], dp[1][end]);
    }

    public static void main(String[] args) {
        _213_HouseRobberII hrII = new _213_HouseRobberII();
        int rob = hrII.rob(new int[]{1,2,1,1});
    }
}
