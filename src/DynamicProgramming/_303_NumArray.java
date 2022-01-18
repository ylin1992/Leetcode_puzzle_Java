package DynamicProgramming;

public class _303_NumArray {
    private int[] arr;
    public _303_NumArray(int[] nums) {
        arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int len = right - left + 1;
        if (left == 0) return arr[right];
        return arr[right] - arr[right - len];
    }

}
