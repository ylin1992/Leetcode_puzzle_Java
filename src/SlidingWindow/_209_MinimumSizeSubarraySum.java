package SlidingWindow;

// use two pointers
// keep increasing right boundary
// if sum >= target, keep shrinking left boundary
public class _209_MinimumSizeSubarraySum {
   public int minSubArrayLen(int target, int[] nums) {
      int min = Integer.MAX_VALUE;
      int i = 0;
      int j = 0;
      int sum = 0;
      while (j < nums.length) {
         sum += nums[j];
         j++;
         while (sum >= target) {
            min = Math.min(min, j-i);
            sum -= nums[i];
            i++;
         }
      }
      return min == Integer.MAX_VALUE ? 0 : min;
   }
}
