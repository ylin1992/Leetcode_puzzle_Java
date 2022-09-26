package SnowFlake;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// O(n^2) solution
public class SplitTheArray {
   static int MOD = (int) 1e9 +7;
   public static int countWays(List<Integer> nums) {
      int sum = 0;
      int[] leftSum = new int[nums.size()];
      int[] rightSum = new int[nums.size()];
      leftSum[0] = nums.get(0);
      rightSum[nums.size() - 1] = nums.get(nums.size() - 1);
      for (int i = 1; i < nums.size(); i++) {
         leftSum[i] = leftSum[i-1] + nums.get(i);
      }
      for (int i = nums.size() - 2; i >= 0; i--) {
         rightSum[i] = rightSum[i+1] + nums.get(i);
      }
      for (int num : nums)
         sum += num;

      int res = 0;
      for (int i = 0; i < nums.size() - 1; i++) {
         int j = nums.size() - 1;
         while (j > i + 1 && (leftSum[i] + rightSum[j] >= sum - leftSum[i] - rightSum[j])) {
            j--;
         }
         j++;
         res += ((nums.size() - j)) % MOD;
         res %= MOD;
      }
      return res;
   }

   public static void main(String[] args) {
      System.out.println(countWays(Arrays.asList(new Integer[]{1,2,3,4})));
   }
}
