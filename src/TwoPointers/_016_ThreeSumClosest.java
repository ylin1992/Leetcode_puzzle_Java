package TwoPointers;

import java.util.Arrays;

public class _016_ThreeSumClosest {
   public int threeSumClosest(int[] nums, int target) {
      int min = Integer.MAX_VALUE;
      int res = 0;
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++) {
         int j = i + 1;
         int k = nums.length - 1;
         while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (Math.abs(sum - target) < min) {
               res = sum;
               min = Math.abs(sum - target);
            }
            if (sum > target) {
               k--;
            } else if (sum < target) {
               j++;
            } else {
               return target;
            }
         }
      }
      return res;
   }

}
