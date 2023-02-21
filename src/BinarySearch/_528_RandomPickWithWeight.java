package BinarySearch;

public class _528_RandomPickWithWeight {
   int[] interval;
   // w:        [2,3,4]
   // interval: [0 2 5 9]
   // Generate a random number from 0 to 9 (9 is not included).
   // Suppose the number we generate is [5,8] then we know we should return index 2.
   // or if the number is [0, 1] then we should return index 0.
   // Use binary search to get the position, and then the problem becomes leetcode 35, insertion position
   public _528_RandomPickWithWeight(int[] w) {
      interval = new int[w.length + 1];
      interval[0] = 0;
      for (int i = 1; i <= w.length; i++) {
         interval[i] = interval[i - 1] + w[i - 1];
      }
//      for (int i : interval)
//         System.out.print(i + " ");
   }

   public int pickIndex() {
      int rand = (int)(Math.random() * interval[interval.length - 1]);
      int i = 0;
      int j = interval.length - 1;
      while (i <= j) {
         int mid = (j - i) / 2 + i;
         if (rand == interval[mid]) {
            return mid;
         } else if (rand < interval[mid]) {
            j = mid - 1;
         } else {
            i = mid + 1;
         }
      }
      // for (int i = 0; i < interval.length - 1; i++) {
      //     if (rand >= interval[i] && rand < interval[i+1]) {
      //         return i;
      //     }
      // }
      return i - 1;
   }

}
// [2,3,4]
// interval: 0 2 5 9