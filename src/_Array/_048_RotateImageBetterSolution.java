package _Array;

/**
 * First swap and the flip
 * Swapping is pretty simple, just swap m[i][j] and m[j][i]
 * Note that for swapping, the index should be like this:
 * for(int i = 0; i<matrix.length; i++)
 *          for(int j = i; j<matrix[0].length; j++)
 * otherwise the entire array will be swapped twice, then become the original
 */
public class _048_RotateImageBetterSolution {
   public void rotate(int[][] matrix) {
      for(int i = 0; i<matrix.length; i++){
         for(int j = i; j<matrix[0].length; j++){
            int temp = 0;
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
      }
      for(int i =0 ; i<matrix.length; i++){
         for(int j = 0; j<matrix.length/2; j++){
            int temp = 0;
            temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix.length-1-j];
            matrix[i][matrix.length-1-j] = temp;
         }
      }
   }
}
