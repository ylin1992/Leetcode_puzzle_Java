package DynamicProgramming;

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]));

            max = Math.max(dpMax[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        _152_MaximumProductSubarray maximumProductSubarray = new _152_MaximumProductSubarray();
        int ans = maximumProductSubarray.maxProduct(new int[]{2,-3,2,4});
    }
}
