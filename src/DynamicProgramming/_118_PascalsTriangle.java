package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
   public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res = new ArrayList<>();

      for (int i = 1; i <= numRows; i++) {
         res.add(new ArrayList<>());

         for (int j = 1; j <= i; j++) {
            if (j == 1 || j == i) {
               res.get(i-1).add(1);
               continue;
            }
            res.get(i-1).add(res.get(i-2).get(j-2) + res.get(i-2).get(j-1));
         }
      }
      return res;
   }
}
