package Sorting;

import javax.lang.model.element.TypeElement;

public class _334_IncreasingTripletSubsequence {
   /*
   Solution 1
    */
   public boolean increasingTriplet(int[] nums) {
      int smallest = Integer.MAX_VALUE;
      int secondSmallest = Integer.MAX_VALUE;

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] < smallest) {
            smallest = nums[i];
         } else if (nums[i] > smallest && nums[i] < secondSmallest) {
            secondSmallest = nums[i];
         } else if (nums[i] > secondSmallest) {
            return true;
         }

      }
      return false;
   }
   /*
   Solution2:
   maintain 2 arrays
   left min: the min value we've found till i-th index (including i-th element)
   right max: the max value we've found till i-th index (including i-th element)
   if we find a triplet where leftMin[i-1] < nums[i] < rightMax[i+1], we found the triplet
    */
   public boolean increasingTripletSol2(int[] nums) {
      int[] leftMin = new int[nums.length];
      int[] rightMax = new int[nums.length];
      leftMin[0] = nums[0];
      rightMax[nums.length-1] = nums[nums.length-1];
      // fill in leftMin
      for (int i = 1; i < nums.length; i++) {

         leftMin[i] = Math.min(nums[i], leftMin[i-1]);
      }
      // fill in rightMax
      for (int i = nums.length-2; i >= 0; i--) {
         rightMax[i] = Math.max(nums[i], rightMax[i+1]);
      }

      for (int i = 1; i < nums.length - 1; i++) {
         if (nums[i] > leftMin[i] && nums[i] < rightMax[i]) {
            return true;
         }
      }
      return false;
   }

}
