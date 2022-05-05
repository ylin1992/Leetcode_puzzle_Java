package BinarySearch;

/**
 * Binary search iterating along rows
 * Runtime: O(cols*log(rows))
 */
public class _240_SearchA2DMatrixII {
   public boolean searchMatrix(int[][] matrix, int target) {
      return helper(matrix, target, 0, matrix.length-1);
   }

   public boolean helper(int[][] matrix, int target, int row1, int row2) {
      if (row1 > row2) return false;
      int rows = matrix.length;
      int cols = matrix[0].length;
      int m = (row2 - row1) / 2 + row1;

      // binary search along col
      int l = 0;
      int r = cols - 1;
      int mc = 0;
      while (l <= r) {
         mc = (r - l) / 2 + l;
         int val = matrix[m][mc];
         // System.out.println(l + " " + mc + " " + r);
         if (val > target) r = mc - 1;
         else if (val < target) l = mc + 1;
         else return true;
      }
      return helper(matrix, target, m + 1, row2) || helper(matrix, target, row1, m - 1);
   }

}
