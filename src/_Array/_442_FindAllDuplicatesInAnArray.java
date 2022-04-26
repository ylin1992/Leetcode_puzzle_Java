package _Array;

import java.util.ArrayList;
import java.util.List;

// In each iteration, flip the nums[idx] to negative
// If the nums[idx] is already negative, it means the same idx has already
// been visited, this is the duplicate
public class _442_FindAllDuplicatesInAnArray {
   public List<Integer> findDuplicates(int[] nums) {
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
         int idx = Math.abs(nums[i]) - 1;
         if (nums[idx] < 0) {
            list.add(idx + 1);
         }
         nums[idx] *= -1;
      }
      return list;
   }
}
