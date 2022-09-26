package SnowFlake;

import java.util.Arrays;

// perfect pair:
// min(|x-y|, |x+y|) <= min(|x|, |y|)
// max(|x-y|, |x+y|) >= max(|x|, |y|)
// the second condition will always hold true,
// and we don't need to care about the signs for x and y as they don't
// affect the final result.
// Thus the condition becomes y - x <= x --> y <= 2x, assuming x <= y.
// We can safely assume x <= y because (x, y) and (y, x) will always
// lead to the same result.

// We then can determine the result using a binary search for each visiting index,
// searching the index that is greater than y / 2.
// Suppose that the index we found is 2, and the visiting index is 4,
// in this case index 2 and 3 are can be paired up with 4, so we get (2,4), (3,4), 2 pairs.
// We keep iterating through the entire array and return the summation of all number of pairs we found.
public class PerfectPairs {
   public static int getPerfectPairsCount(int[] arr) {
      int sum = 0;
      int[] absArr = new int[arr.length];
      for (int i = 0; i < absArr.length; i++)
         absArr[i] = Math.abs(arr[i]);
      Arrays.sort(absArr);
      for (int i = 0; i < arr.length; i++) {
         int idx = binarySearch(absArr, i);
         sum += (i - idx);
      }
      return sum;
   }

   // returns the closest index i where arr[i] >= arr[visiting] / 2
   public static int binarySearch(int[] arr, int visitingIndex) {
      int i = 0, j = arr.length - 1;
      int target = arr[visitingIndex] / 2;
      while (i <= j) {
         int mid = (j - i) / 2 + i;
         if (arr[mid] == target) {
            return mid;
         } else if (arr[mid] > target) {
            j = mid - 1;
         } else {
            i = mid + 1;
         }
      }
      return i;
   }

   public static void main(String[] args) {
      System.out.println(getPerfectPairsCount(new int[]{2, 5, -3}));
   }
}
