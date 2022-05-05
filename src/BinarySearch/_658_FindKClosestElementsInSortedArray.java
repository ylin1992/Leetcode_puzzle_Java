package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * First run BS and find the closest index
 * then add the closest k element adjacent to the closest index
 * sort the array
 */
public class _658_FindKClosestElementsInSortedArray {
   public List<Integer> findClosestElements(int[] arr, int k, int x) {
      List<Integer> res = new ArrayList<>();

      int n = arr.length;
      int l = 0;
      int r = n - 1;
      int m = 0;
      while (l + 1 < r) {
         m = (r - l) / 2 + l;
         if (arr[m] == x) break;
         if (arr[m] > x) r = m;
         else l = m;
      }
      int idx = 0;
      if (arr[m] == x) idx = m;
      else idx = Math.abs(arr[l] - x) <= Math.abs(arr[r] - x) ? l : r;
      System.out.println(idx + " " + l + " " + r);
      System.out.println(idx);
      res.add(arr[idx]);
      k -= 1;
      int i = idx - 1;
      int j = idx + 1;
      while (k > 0) {
         // System.out.println(i + " " + j );
         // System.out.println("di: " + (x - arr[i]) + " dj: "  + (arr[j] - x));
         if (i >= 0 && j < n) {
            if (x - arr[i] <= arr[j] - x) {
               res.add(arr[i]);
               i--;
            } else {
               res.add(arr[j]);
               j++;
            }
         } else if (i >= 0 && j >= n) {
            res.add(arr[i]);
            i--;
         } else if (j < n && i < 0) {
            res.add(arr[j]);
            j++;
         }
         k--;
      }

      Collections.sort(res);
      return res;
   }

}
