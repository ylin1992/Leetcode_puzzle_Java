package Design;

import java.util.HashSet;

public class _1570_SparseVector {
}
class SparseVector {
   HashSet<Integer> nonZeroIndex;
   int[] nums;
   SparseVector(int[] nums) {
      this.nums = nums;
      nonZeroIndex = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] != 0)
            nonZeroIndex.add(i);
      }
   }

   // Return the dotProduct of two sparse vectors
   public int dotProduct(SparseVector vec) {
      int sum = 0;
      for (int nonZ : nonZeroIndex) {
         if (vec.nonZeroIndex.contains(nonZ)) {
            sum += nums[nonZ] * vec.nums[nonZ];
         }
      }
      return sum;
   }
}
