package SnowFlake;

public class LargestSubGrid {
   public static int getRegionSumAt(int[][] preSum, int r1, int c1, int r2, int c2) {
      int n = preSum.length;
      return getPreSumAt(preSum, r2, c2, n) - getPreSumAt(preSum, r1-1, c2, n)
         - getPreSumAt(preSum, r2, c1-1, n) + getPreSumAt(preSum, r1-1, c1-1, n);
   }
   public static int getPreSumAt(int[][] preSum, int row, int col, int n) {
      if (row < 0 || col < 0) return 0;
      return preSum[row][col];
   }
   public static void updatePreSum(int[][] preSum, int n, int[][] grid) {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            preSum[i][j] = getPreSumAt(preSum, i-1, j, n) + getPreSumAt(preSum, i-1, j-1, n)
                           + getPreSumAt(preSum, i, j-1, n) + grid[i][j];
         }
      }
   }
   public static int largestSubgrid(int[][] grid, int k) {
      int n = grid.length;
      int[][] preSum = new int[n][n];
      updatePreSum(preSum, n, grid);
      int l = 0, r = n;
      int res = 0;
      while (l <= r) {
         int m = (r - l) / 2 + l;
         if (m == 0) return 0;

         boolean flag = false;
         for (int i = m-1; i < n; i++) {
            for (int j = m-1; j < n; j++) {
//               int tempSum = getPreSumAt(preSum, i, j, n) - getPreSumAt(preSum, i-m+1-1, j, n)
//                           - getPreSumAt(preSum, i, j-m+1-1, n) + getPreSumAt(preSum, i-m+1-1, j-m+1-1, n);
               int tempSum = getRegionSumAt(preSum, i-m+1, j-m+1, i, j);
               if (tempSum > k) {
                  flag = true;
                  break;
               }
            }
            if (flag) break;
         }

         if (flag) {
            r = m - 1;
         } else {
            res = m;
            l = m + 1;
         }
      }
      return res;
   }

   public static void main(String[] args) {
      int[][] in = new int[][]{{4,5}, {6,7}};
      System.out.println(largestSubgrid(in, 2));
   }
}
