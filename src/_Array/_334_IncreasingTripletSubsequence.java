package _Array;

/**
 * dp solution: time = O(n^2), space = O(n)
 * greedy: time = O(n), space = O(1)
 * Keep monitoring the smallest and second smallest element
 * if nums[i] greater than the second smallest element, we find the triplet
 */
public class _334_IncreasingTripletSubsequence {
   public boolean increasingTriplet(int[] nums) {
      int smallest = Integer.MAX_VALUE;
      int second = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] < smallest) {
            smallest = nums[i];
         } else if (nums[i] < second && nums[i] > smallest) {
            second = nums[i];
         } else if (nums[i] > second){
            return true;
         }
      }
      return false;
   }
}
