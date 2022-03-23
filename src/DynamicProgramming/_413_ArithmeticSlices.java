package DynamicProgramming;

/**
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 *     For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 *
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 5000
 *     -1000 <= nums[i] <= 1000
 */
public class _413_ArithmeticSlices {
   // Observation
   // 0 1 2 3 4 5

   // i = 2: 012 --> 1
   // i = 3: 012, 123, 0123 --> 1 + (1+1)
   // i = 4: 012, 123, 0123, 234, 1234, 01234 --> 1 + (1+1) + (1+1+1)
   // i = 5: 012, 123, 0123, 234, 1234, 01234, 345, 2345, 12345, 012345 --> 1 + (1+1) + (1+1+1) + (1+1+1+1+1)
   public int numberOfArithmeticSlices(int[] nums) {
      if (nums.length < 3) return 0;
      int res = 0;
      int curConsecutive = 0;
      for (int i = 2; i < nums.length; i++) {
         if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
            curConsecutive++;
            res += curConsecutive;
         } else {
            curConsecutive = 0;
         }
      }
      return res;
   }

}
