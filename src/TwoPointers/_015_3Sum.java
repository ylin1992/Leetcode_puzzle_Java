package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015_3Sum {
   public List<List<Integer>> threeSum(int[] nums) {
      if (nums.length < 3) return new ArrayList<>();

      Arrays.sort(nums); // nlgn
      List<List<Integer>> res = new ArrayList<>();
      for (int i = 0; i < nums.length - 2; i++) {
         if (i > 0 && nums[i - 1] == nums[i]) continue;
         int j = i + 1;
         int k = nums.length - 1;
         while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum > 0) {
               // means nums[j] + nums[k] is too large, should move k backward
               k--;
            } else if (sum < 0) {
               // means nums[j] + nums[k] is too small, should move j forward
               j++;
            } else {
               // we find the result
               res.add(Arrays.asList(nums[i], nums[j], nums[k]));
               // avoid appending duplicates
               // if these tow lines are not present
               // [0,0,0,0] would fail
               while (j < k && nums[j] == nums[j + 1]) j++;
               while (j < k && nums[k] == nums[k - 1]) k--;
               j++;
               k--;
            }
         }
      }
      return res;
   }

}
