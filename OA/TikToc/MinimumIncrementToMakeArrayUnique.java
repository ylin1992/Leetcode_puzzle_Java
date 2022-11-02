package OA.TikToc;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumIncrementToMakeArrayUnique {
   // leetcode 945
   public int minIncrementForUniqueSlowerSolution(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      Arrays.sort(nums);
      int moves = 0;
      for (int i = 0; i < nums.length; i++) {
         int num = nums[i];
         if (set.contains(num)) {
            int prev = num;
            nums[i] = nums[i-1] + 1;
            moves += (nums[i] - prev);
            set.add(nums[i]);
         } else {
            set.add(num);
         }
      }
      return moves;
   }

   public int minIncrementForUniqueFaster(int[] nums) {
      // creating a freq array:
      // original nums has the following count for each number
      // idx: 0 1 2 3 4 5 6 7
      // cnt: 0 3 4 1 2 1 1 1
      // in this example, we found that 1 has freq of 3, which means
      // there are (3-1) of "1" should be added to 2
      // so we do moves += (3-1)
      // and then freq[2] should be increased by (3-1), we repeat this process
      // The reason why we need int[] freq = new int[max + nums.length]; is that the worst case
      // the maximum number would be maxVal + nums.length
      // consider the following:
      // [1,2,2], the maximum could be 3, which exceeds the upper limit, so we have to create the space in advance
      int max = Integer.MIN_VALUE;
      for (int num : nums)
         max = Math.max(num, max);

      int[] freq = new int[max + nums.length];
      for (int num : nums)
         freq[num]++;
      int moves = 0;
      for (int i = 0; i < freq.length-1; i++) {
         if (freq[i] <= 1)
            continue;

         int remain = freq[i] - 1;
         moves += remain;
         freq[i+1] += remain;
      }
      return moves;
   }

}
