package SnowFlake;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// O(n^2) solution
public class SplitTheArray {
   public static int waysToSplit(int[] nums) {
      int sz = nums.length, res = 0;
      for (int i = 1; i < sz; ++i)
         nums[i] += nums[i - 1];
      for (int i = 0, j = 0, k = 0; i < sz - 2; ++i) {
         while (j <= i || (j < sz - 1 && nums[j] < nums[i] * 2))
            ++j;
         while (k < j || ( k < sz - 1 && nums[k] - nums[i] <= nums[sz - 1] - nums[k]))
            ++k;
         res = (res + k - j) % 1000000007;
      }
      return res;
   }

   public static void main(String[] args) {
      System.out.println(waysToSplit(new int[]{1,2,3,4}));
   }
}
