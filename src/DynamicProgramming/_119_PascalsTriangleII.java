package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangleII {
   public List<Integer> getRow(int rowIndex) {
      List<Integer> res = new ArrayList<>();
      res.add(1);
      if (rowIndex == 0) return res;
      res.add(1);
      if (rowIndex == 1) return res;
      for (int i = 2; i <= rowIndex; i++) {
         int num1 = res.get(0);
         int num2 = res.get(1);

         for (int j = 1; j < i; j++) {
            num2 = res.get(j);
            res.set(j, num1 + num2);
            num1 = num2;
         }
         res.add(1);
      }
      return res;
   }
}
