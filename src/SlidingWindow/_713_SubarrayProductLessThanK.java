package SlidingWindow;

/**
 * Using sliding window
 * Keep monitoring a current product, which is the product within a valid sub-array
 * If the product >= k, keep moving the back pointer toward the front one
 * 10 5 2 5, k = 100
 *        i
 * j -->
 * Import note: it is necessary to have ending condition as i <= j instead of i < j
 * otherwise the result would be at least nums.length
 */
public class _713_SubarrayProductLessThanK {
   public int numSubarrayProductLessThanK(int[] nums, int k) {
      if (k == 0) return 0;
      int count = 0;
      int j = 0; // the back pointer
      int curProd = 1;

      // i: front pointer
      for (int i = 0; i < nums.length; i++) {
         curProd = curProd * nums[i];
         while (j <= i && curProd >= k) { // important for <=, for cases like [1,1,1] 1
            curProd = curProd / nums[j];
            j++;
         }
         count = count + (i - j + 1);
      }
      return count;
   }

}
