package BitWise;

/**
 * Since we can only use O(1) space, we cannot copy the entire 2D array and update the original array
 * based on the copy
 * By using two bits, we can record and extract the current state and the next state each cell should be
 * the two bits: [next state, current state]
 * // 10 means live <- dead
 * // 11 means live <- live
 * // 01 means dead <- live
 * // 00 means dead <- dead
 *
 * Extracting the current state: board[i][j] & 1 -> only get the first bit
 * Remove the current state for output: board[i][j] >>= 1 -> right shift one bit to eliminate current state
 */
public class _289_GameOfLife {
   public void gameOfLife(int[][] board) {
      int r = board.length;
      int c = board[0].length;
      for (int i = 0; i < r; i++) {
         for (int j = 0; j < c; j++) {
            int live = numberOfLiveCells(board, i, j);
            // System.out.println(i + " " + j + " " + live);
            if (live < 2 && (board[i][j] & 1) == 1) {
               // condition 1: live -> dead (01)
               board[i][j] = 1;
            } else if ((live == 2 || live == 3) && (board[i][j] & 1) == 1) {
               // condition 2: live -> live (11)
               board[i][j] = 3;
            } else if (live > 3 && (board[i][j] & 1) == 1) {
               // condition 3: live -> dead (01)
               board[i][j] = 1;
            } else if (live == 3 && (board[i][j] & 1) == 0) {
               // condition 4: dead -> live (10)
               board[i][j] = 2;
            }
         }
      }
      for (int i = 0; i < r; i++) {
         for (int j = 0; j < c ; j++) {
            board[i][j] = (board[i][j] >> 1);
         }
      }

   }

   private int numberOfLiveCells(int[][] board, int i, int j) {
      int count = 0;
      for (int p = Math.max(0, i-1); p < Math.min(i+2, board.length); p++) {
         for (int q = Math.max(0, j-1); q < Math.min(j+2, board[0].length); q++) {
            if ((board[p][q] & 1) == 1) {
               count++;
            }
         }
      }
      return count - (board[i][j] & 1);
   }


}
