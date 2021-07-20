package Sorting;

public class _300_LIS {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++){
            int index = bisectLeft(dp, size, nums[i]);
            if (index == size) {
                dp[size] = nums[i];
                size++;
            } else {
                dp[index] = nums[i];
            }
        }
        return size;
    }

    private static int bisectLeft(int[] dp, int size, int target) {
        /*if (target >= dp[size]) {
            return size;
        }*/
        int start = 0;
        int end = size;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int abs = lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
