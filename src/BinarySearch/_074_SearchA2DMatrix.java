package BinarySearch;

public class _074_SearchA2DMatrix {
   public boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length;
      int cols = matrix[0].length;

      int l = 0;
      int r = rows * cols - 1;
      int m = 0;
      while (l+1 < r) {
         m = (r - l) / 2 + l;
         System.out.println(m);
         int val = matrix[m/cols][m%cols];
         if (val == target) return true;
         if (val > target) {
            r = m;
         } else {
            l = m;
         }
      }
      return matrix[l/cols][l%cols] == target || matrix[r/cols][r%cols] == target;
   }
}
