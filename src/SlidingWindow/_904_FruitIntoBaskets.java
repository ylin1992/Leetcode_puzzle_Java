package SlidingWindow;

import java.util.Collections;
import java.util.HashMap;

// Use a HashMap to record:
// fruit type and the last index where it shows up
// [1,1,1,2,3]
// 1 -> 2
// 2 -> 3
// when the map size is over 2, means we encounter a new type of fruit
// pop the fruit with the min element out
// visit: 3 -> pop 1 out since in the map, 1 has the smallest index "2"
// In each iteration, update the max length by previous minIndex + 1 and current visiting index
public class _904_FruitIntoBaskets {
   public int totalFruit(int[] fruits) {
      HashMap<Integer, Integer> map = new HashMap<>();

      int max = 0;
      int start = 0;
      for (int end = 0; end < fruits.length; end++) {
         map.put(fruits[end], end);
         if (map.size() > 2) {
            int minIndex = Collections.min(map.values());
            map.remove(fruits[minIndex]);
            start = minIndex + 1;
         }
         max = Math.max(max, end - start + 1);
      }
      return max;
   }

}
