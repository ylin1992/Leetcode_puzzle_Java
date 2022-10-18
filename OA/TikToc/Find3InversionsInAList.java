package OA.TikToc;
//Inversion is a strictly decreasing subsequence of length 3. More formally, given an array, p, an inversion in the array is any time some p[i] > p[j] > p[k] and i < j < k. Given an array of length n, find the number of inversions.
//
//      Example)
//      n = 5, arr = [5, 3, 4, 2, 1]
//      Array inversions are [5, 3, 2], [5,3,1], [5,4,2], [5,4,1], [5,2,1], [3,2,1], [4,2,1]
//
//      n = 4, arr = [4,2,2,1]
//      The only inversion is [4,2,1] and we do not count the duplicate inversion.
public class Find3InversionsInAList {
   public static int solve(int[] array) {
      int sum = 0;
      for (int i = 1; i < array.length - 1; i++) {
         int leftGreater = 0;
         int rightSmaller = 0;
         for (int left = 0; left < i; left++) {
            if (array[left] > array[i])
               leftGreater++;
         }

         for (int right = array.length - 1; right > i; right--) {
            if (array[right] < array[i])
               rightSmaller++;
         }
//         System.out.println(leftGreater + " " + rightSmaller);
         sum += leftGreater * rightSmaller;
      }
      return sum;
   }

   public static void main(String[] args) {
      System.out.println(solve(new int[] {5,3,4,2,1}));
   }
}
