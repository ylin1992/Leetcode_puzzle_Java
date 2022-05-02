package _Array;

/**
 * Strategy: use the first row and first cols as flags
 * 1. check matrix[1~n-1][1~m-1], if matrix[i][j] is 0, set matrix[i][0] and matrix[0][j] as zeros
 * 2. traverse the first row and the first col, if matrix[i][0] is 0, set all i-th row to zero
 *    if matrix[0][j] is 0, set all j-th col to zero
 * 3. We need to check if the first row and the first col contains zero, if so, set a flag before step 1 and 2
 * 4. if there are zeroes in the first row and col, we flip all 0-th row or 0-th col to zero
 * https://www.youtube.com/watch?v=5LU0pv0-ZtI
 */

public class _073_SetMatrixZeroes {
   public void setZeroes(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;

      boolean frowContainsZero = false;
      boolean fcolContainsZero = false;

      // check if the first row and the first col contains zero
      for (int i = 0; i < rows; i++) {
         if (matrix[i][0] == 0) {
            fcolContainsZero = true;
         }
      }

      for (int i = 0; i < cols; i++) {
         if (matrix[0][i] == 0) {
            frowContainsZero = true;
         }
      }

      // check the whole matrix other than the first row and col
      // set a marker to the first row and first col if the cell contains zero
      // 1 1 2 3         1  1 [0] 3
      // 4 5 6 7         4  5  6  7
      // 1 2 0 1    ==> [0] 2 [0] 1
      // 0 3 4 3         0  3  4  3
      for (int i = 1; i < rows; i++) {
         for (int j = 1; j < cols; j++) {
            if (matrix[i][j] == 0) {
               matrix[i][0] = 0;
               matrix[0][j] = 0;
            }
         }
      }

      // traverse the first row and the first col
      // if there is a cell being zero, flip all the row/col to zero
      // 1  1 [0] 3        1 1 0 3
      // 4  5  6  7        4 5 0 7
      //[0] 2 [0] 1   ==>  0 0 0 0
      // 0  3  4  3        0 0 0 0
      for (int i = 1; i < rows; i++) {
         if (matrix[i][0] == 0) {
            for (int j = 1; j < cols; j++) {
               matrix[i][j] = 0;
            }
         }
      }

      for (int i = 1; i < cols; i++) {
         if (matrix[0][i] == 0) {
            for (int j = 0; j < rows; j++) {
               matrix[j][i] = 0;
            }
         }
      }

      if (frowContainsZero) {
         for (int i = 0; i < cols; i++) {
            matrix[0][i] = 0;
         }
      }

      if (fcolContainsZero) {
         for (int i = 0; i < rows; i++) {
            matrix[i][0] = 0;
         }
      }
   }
}
