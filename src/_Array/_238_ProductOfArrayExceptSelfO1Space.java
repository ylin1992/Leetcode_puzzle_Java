package _Array;

public class _238_ProductOfArrayExceptSelfO1Space {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        // res[i] contains the product from nums[0] to nums[i - 1]
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // r keeps tracking the product from nums[n-1] to n[i+1]
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }
}
