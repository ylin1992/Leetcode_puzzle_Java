package _Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Concept: split the process into four cases
 * update the boundaries when an edge is done
 */
public class _054_SprialMatrix {
   public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> res = new ArrayList<>();

      int rows = matrix.length;
      int cols = matrix[0].length;

      int left = 0;
      int right = cols - 1;
      int top = 0;
      int bottom = rows - 1;

      int state = 0;

      while (right >= left && bottom >= top) {
         //System.out.println("right: " + right + ", left: " + left + ", top: " + top + ", bottom: " + bottom);
         if (state % 4 == 0) { // go right at the top-th row
            for (int i = left; i <= right; i++) {
               res.add(matrix[top][i]);
            }
            state++;
            top++;
         } else if (state % 4 == 1) { // go down at the right-th col
            for (int i = top; i <= bottom; i++) {
               res.add(matrix[i][right]);
            }
            state++;
            right--;
         } else if (state % 4 == 2) { // go left at the bottom-th row
            for (int i = right; i >= left; i--) {
               res.add(matrix[bottom][i]);
            }
            state++;
            bottom--;
         } else { // go up at the left-th row
            for (int i = bottom; i >= top; i--) {
               res.add(matrix[i][left]);
            }
            state++;
            left++;
         }
      }
      return res;
   }
}
