package TwoPointers;

public class _283_MoveZeros {
   public void moveZeroes(int[] nums) {
      int offset = 0; // elements before this index are already addressed (no zeros, and sorted in the original order)
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] != 0) {
            int temp = nums[i];
            nums[i] = nums[offset];
            nums[offset++] = temp;
         }
      }
   }
}
