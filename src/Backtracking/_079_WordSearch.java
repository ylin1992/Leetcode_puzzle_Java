package Backtracking;

public class _079_WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int x = 0; x < board[0].length; x++) {
            for (int y = 0; y < board.length; y++) {
                res = helper(board, word, x, y, 0);
                if (res) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int x, int y, int curWordIdx) {
        if (x < 0 || y < 0) return false;
        if (x >= board[0].length || y >= board.length) return false;
        if (curWordIdx == word.length() - 1 && board[y][x] == word.charAt(curWordIdx)) return true;
        if (curWordIdx >= word.length()) return false;
        if (board[y][x] == word.charAt(curWordIdx)) {
            board[y][x] = ' '; // mark this block as visited
            boolean res = helper(board, word, x + 1, y, curWordIdx + 1)
                    || helper(board, word, x, y + 1, curWordIdx + 1)
                    || helper(board, word, x - 1, y, curWordIdx + 1)
                    || helper(board, word, x, y - 1, curWordIdx + 1);
            board[y][x] = word.charAt(curWordIdx); // restore this block for future use
            return res;
        } else {
            return false;
        }
    }
    }
