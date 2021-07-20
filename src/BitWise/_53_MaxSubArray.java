package BitwiseOperation;

public class _53_MaxSubArray {
    public int maxSubArrayDP(int[] nums) {
        // in: -2, 1, -3, 4, -1, 2, 1, -5, 4
        // dp: -2, 1, -2, 4, 3,  5, 6, 1, 5
        //ans: -2, 1, 1,  4, 4,  5, 6, 6, 6 -> output 6
        int[] dp = new int[nums.length];
        int ans = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]); // if thr previous dp value is < 0, skip it.
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public int maxSubArrayDP2(int[] nums) {
        // in: -2, 1, -3, 4, -1, 2, 1, -5, 4
        //sum: -2, 1, -2, 4, 3, 5,  6,  1, 5
        //ans: -2, 1,  1, 4, 4, 5,  6,  6, 6
        int ans = nums[0];
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + Math.max(sum, 0);
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        _53_MaxSubArray msa = new _53_MaxSubArray();
        System.out.println(msa.maxSubArrayDP2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
