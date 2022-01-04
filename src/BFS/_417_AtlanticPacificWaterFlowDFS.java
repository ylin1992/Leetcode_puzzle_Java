package BFS;
import java.util.*;
public class _417_AtlanticPacificWaterFlowDFS {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pConnected = new boolean[rows][cols];
        boolean[][] aConnected = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            // traverse all reachable blocks starting from left pacific boarder
            dfs(heights, i, 0, pConnected, Integer.MIN_VALUE);
            // traverse all reachable blocks starting from right atlantic boarder
            dfs(heights, i, cols - 1, aConnected, Integer.MIN_VALUE);
        }

        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, pConnected, Integer.MIN_VALUE);
            dfs(heights, rows - 1, i, aConnected, Integer.MIN_VALUE);
        }
        // dfs(heights, 0, 0, aConnected, Integer.MIN_VALUE);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (aConnected[r][c] && pConnected[r][c]) {
                    res.add(Arrays.asList(new Integer[]{r,c}));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] connected, int preHeight) {
        int rows = heights.length;
        int cols = heights[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || connected[row][col] || preHeight > heights[row][col]) {
            return;
        }
        connected[row][col] = true;
        dfs(heights, row + 1, col, connected, heights[row][col]);
        dfs(heights, row - 1, col, connected, heights[row][col]);
        dfs(heights, row, col + 1, connected, heights[row][col]);
        dfs(heights, row, col - 1, connected, heights[row][col]);
    }
}
