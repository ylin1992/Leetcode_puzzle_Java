package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _120_Triangle {
   public int minimumTotal(List<List<Integer>> triangle) {
      if (triangle.size() == 1) return triangle.get(0).get(0);
      if (triangle.size() == 2) return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));

      List<Integer> dp = new ArrayList<>();
      dp.add(triangle.get(0).get(0) + triangle.get(1).get(0));
      dp.add(triangle.get(0).get(0) + triangle.get(1).get(1));

      int num1 = dp.get(0);
      int num2 = dp.get(1);

      for (int i = 2; i < triangle.size(); i++) {
         List<Integer> nextDp = new ArrayList<>();
         for (int j = 0; j < triangle.get(i).size(); j++) {
            List<Integer> t = triangle.get(i);
            if (j == 0) nextDp.add(dp.get(0) + t.get(0));
            else if (j == t.size() - 1)
               nextDp.add(dp.get(dp.size()-1) + t.get(t.size() - 1));
            else
               nextDp.add(Math.min(dp.get(j-1), dp.get(j)) + t.get(j));
         }
         dp = nextDp;
      }

      int min = Collections.min(dp);
      return min;
   }
}
