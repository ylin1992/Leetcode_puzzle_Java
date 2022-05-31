package _Array;

/**
 * Use an indicator to show previous state (increasing or decreasing)
 * if prev is increasing, and nums[i] and nums[i+1] is increasing too, we need to swap i and i+1
 * the same, if prev is decreasingand nums[i] and nums[i+1] is decreasing too, we need to swap them as well
 * after each iteration, we move i forward and alter the state
 */
public class _280_WiggleSort {
   public void wiggleSort(int[] nums) {
      int i = 0;
      boolean prevIncreasing = true;
      while (i < nums.length - 1) {
         if ((nums[i] > nums[i+1] && prevIncreasing) || (nums[i] < nums[i+1] && !prevIncreasing)) {
            // violates wiggling condition
            swap(nums, i, i+1);
         }
         i++;
         prevIncreasing = !prevIncreasing;
      }
   }

   private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

}
