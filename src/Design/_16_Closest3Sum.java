package Design;

import java.util.Arrays;

public class _16_Closest3Sum {
    // -4 -1 -1 1 2 3 5 8, t = 1
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int ans = target;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rem = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) { // TODO: binray search optimization
                int diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                if (diff < closestSum) {
                    closestSum = diff;
                    ans = nums[i] + nums[j] + nums[k];
                }
                closestSum = Math.min(Math.abs(nums[i] + nums[j] + nums[k] - target), closestSum);
                if (nums[j] + nums[k] == rem) {
                    return target;
                } else if (nums[j] + nums[k] < rem) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _16_Closest3Sum c3s = new _16_Closest3Sum();
        System.out.println(c3s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println();
    }
}
