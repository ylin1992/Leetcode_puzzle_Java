package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * for every iteration:
 * 1. if there is no intersection: which means either la > rb or ra < lb
 *    -> pick one of them move forward,
 *       if a is fallen behind, move a forward, if (ra < lb) i++
 *       else, move b forward, else j++
 * 2. otherwise, there is definitely an interval:
 *    add the interval into the result by picking [max(la, lb), min(ra, rb)]
 *    and pick one of them to move forward by their right index
 */
public class _986_IntervalListIntersections {
   public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      Arrays.sort(firstList, (a, b) -> Integer.compare(a[0], b[0]));
      Arrays.sort(secondList, (a, b) -> Integer.compare(a[0], b[0]));

      int i = 0; // index for a
      int j = 0; // index for b

      int lena = firstList.length;
      int lenb = secondList.length;

      List<int[]> list = new ArrayList<>();

      while (i < lena && j < lenb) {
         int ra = firstList[i][1];
         int rb = secondList[j][1];
         int la = firstList[i][0];
         int lb = secondList[j][0];
         // no intersections a: [0, 1], b: [2, 3] or a: [2, 3], b:[0, 1]
         if (ra < lb || la > rb) {
            if (ra < lb) i++;
            else j++;
         } else {
            list.add(new int[]{Math.max(la, lb), Math.min(ra, rb)});
            if (ra > rb) j++;
            else i++;
         }
      }
      int[][] res = new int[list.size()][2];
      for (int k = 0; k < list.size(); k++) {
         res[k] = list.get(k);
      }
      return res;
   }

}
