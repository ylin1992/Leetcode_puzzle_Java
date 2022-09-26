package SnowFlake;

import java.util.ArrayList;
import java.util.List;

public class SortedArrangment {
   public static int solve(int[] arr) {
      List<Integer> list = new ArrayList<>();
      int res = 0;
      for (int num : arr) {
         if (list.size() == 0) {
            res += 1;
            list.add(num);
            continue;
         }
         int insertingIndex = findInsertingIndex(list, num) ;
         int left = 0;
         int right = 0;
         if (list.get(insertingIndex) == num) {
            left = insertingIndex;
            right = list.size() - insertingIndex - 1;
         } else {
            left = insertingIndex;
            right = list.size() - insertingIndex;
         }
         if (left <= right) {
            res += left * 2 + 1;
         } else {
            res += right * 2 + 1;
         }
      }
      return res;
   }
   // return the bigger index (the inserting index is returned - 1)
   public static int findInsertingIndex(List<Integer> list, int ele) {
      int i = 0, j = list.size() - 1;
      while (i <= j) {
         int mid = (j - i) / 2 + i;
         if (list.get(mid) == ele)
            return mid;
         else if (list.get(mid) > ele)
            j = mid - 1;
         else
            i = mid + 1;
      }
      return i;
   }

   public static void main(String[] args) {
      System.out.println(solve(new int[]{2,4,1,3}));
   }
}
