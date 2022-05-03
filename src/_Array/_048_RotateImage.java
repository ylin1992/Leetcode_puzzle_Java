package _Array;

/**
 * Strategy:
 * 1. Flip image vertically
 * 2. Swap image diagonally
 */
//  ori  ==> vSwap ==> dSwap
// 1 2 3     3 2 1     7 4 1
// 4 5 6 ==> 6 5 4 ==> 8 5 2
// 7 8 9     9 8 7     9 6 3

// 4 -> 0 1
// 3 -> 0
// 5 -> 0 1
// 6 -> 0 1 2
// i -> 0 ~ i/2 - 1


// 1  2  3  4  5
// 6  7  8  9  10
// 11 12 13 14 15
// 16 17 18 19 20
// 21 22 23 24 25

// (0,0) => (4,4), (1,1) => (3,3)
// (0,1) => (3,4), (1,2) => (2,3)
// (0,2)

// (i,j) => (n-j-1, n-i-1)
public class _048_RotateImage {
   public void rotate(int[][] matrix) {
      int n = matrix.length;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n/2; j++) {
            swap(matrix, i, j, i, n-j-1);
         }
      }
      // printMatrix(matrix);
      // swap the first row
      for (int i = 0; i < n; i++) {
         int r1 = 0;
         int c1 = i;
         for (int j = 0; j < (n-i)/2; j++) {
            swap(matrix, r1, c1, n-c1-1, n-r1-1);
            r1++;
            c1++;
         }
      }
      // printMatrix(matrix);
      // swap the first col
      for (int i = 1; i < n; i++) {
         int r1 = i;
         int c1 = 0;
         for (int j = 0; j < (n-i)/2; j++) {
            swap(matrix, r1, c1, n-c1-1, n-r1-1);
            r1++;
            c1++;
         }
      }

   }

   public void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
      int tmp = matrix[r1][c1];
      matrix[r1][c1] = matrix[r2][c2];
      matrix[r2][c2] = tmp;
   }

   public void printMatrix(int[][] matrix) {
      System.out.println("[");
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(matrix[i][j] + ", ");
         }
         System.out.print("\n");
      }
      System.out.println("]");
   }
}
