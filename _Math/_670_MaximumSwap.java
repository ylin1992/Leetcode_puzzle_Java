package _Math;

import java.util.ArrayList;
import java.util.List;
// build a bucket [0 1 2 3 4 5 6 7 8 9], this bucket records the last position of each digit in num.
// loop through the entire num, if there exists a digit that is greater than the current digit and
// is lying behind the cur position, then swap these two and return
public class _670_MaximumSwap {
   public int maximumSwap(int num) {
      List<Integer> digits = new ArrayList<>();
      int n = num;
      while (n != 0) {
         digits.add(0, n % 10);
         n /= 10;
      }
      int[] lastPosition = new int[10];
      for (int i = 0; i < digits.size(); i++) {
         lastPosition[digits.get(i)] = i;
      }
      int idxToBeSwapped = -1;
      int idxToBeSwapped2 = -1;
      for (int i = 0; i < digits.size(); i++) {
         int digit = digits.get(i);
         for (int k = 9; k > digit; k--) {
            if (lastPosition[k] > i) {
               idxToBeSwapped = lastPosition[k];
               idxToBeSwapped2 = i;
               break;
            }
         }
         if (idxToBeSwapped != -1)
            break;
      }
      // System.out.println(idxToBeSwapped + ", " + idxToBeSwapped2);
      if (idxToBeSwapped != -1) {
         int temp = digits.get(idxToBeSwapped);
         digits.set(idxToBeSwapped, digits.get(idxToBeSwapped2));
         digits.set(idxToBeSwapped2, temp);
      }
      int res = 0;
      for (int i = 0; i < digits.size(); i++)
         res = res * 10 + digits.get(i);
      return res;
   }

}
