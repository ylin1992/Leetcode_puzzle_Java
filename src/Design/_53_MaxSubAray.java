package Design;

public class _53_MaxSubAray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = nums[i] + Math.max(0, curSum);
            max = Math.max(curSum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        _53_MaxSubAray msb = new _53_MaxSubAray();
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] arr = new int[]{1,2};
        System.out.println(msb.maxSubArray(arr));
    }
}
