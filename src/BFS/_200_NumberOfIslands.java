package BFS;

public class _200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '0') continue;
                count += 1;
                dfs(grid, x, y);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length) {
            return;
        }
        if (grid[y][x] == '0') {
            return;
        }

        grid[y][x] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

}
