package _Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Use a hash map to record each element
 * and the length with which the element is boundary
 *
 * Three cases:
 *    if num-1 and num+1 both have value > 0, num is a bridge connecting left and right bound
 *       we need to update num-l and num+r to r - l + 1
 *    if num-1 has value > 0 but num + 1 does not, num is an extension from the left neighbor
 *    if num+1 has value > 0 but num - 1 does not, num is an extension from the right neighbor
 *    https://www.youtube.com/watch?v=rc2QdQ7U78I
 */
public class _128_LongestConsecutiveSequence {
   public int longestConsecutive(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
         if (map.containsKey(num))
            continue;
         int left = map.getOrDefault(num-1, 0);
         int right = map.getOrDefault(num+1, 0);

         if (left > 0 && right > 0) {
            int len = left + right + 1;
            map.put(num, len);
            map.put(num-left, len);
            map.put(num+right, len);
         } else if (left > 0 && right == 0) {
            map.put(num ,left+1);
            map.put(num-left, left+1);
         } else if (right > 0 && left == 0) {
            map.put(num, right+1);
            map.put(num+right, right+1);
         } else {
            map.put(num, 1);
         }
      }

      int max = 0;
      for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
         max = Math.max(max, entry.getValue());
      }
      return max;
   }
}
