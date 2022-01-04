package BFS;
import java.util.*;
public class _417_PacificAtlanticWaterFlowBFS {
    private int[][] DIRs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] connectedP = new boolean[rows][cols];
        boolean[][] connectedA = new boolean[rows][cols];
        Queue<int[]> qP = new LinkedList<>();
        Queue<int[]> qA = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            // vertical
            connectedP[i][0] = true;
            connectedA[i][cols - 1] = true;
            qP.offer(new int[]{i, 0});
            qA.offer(new int[]{i, cols - 1});
        }
        for (int i = 0; i < cols; i++) {
            // horizontal
            connectedP[0][i] = true;
            connectedA[rows - 1][i] = true;
            qP.offer(new int[]{0, i});
            qA.offer(new int[]{rows - 1, i});
        }

        bfs(heights, qP, connectedP);
        bfs(heights, qA, connectedA);

        List<List<Integer>> res = new ArrayList<>();
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (connectedA[row][col] && connectedP[row][col]) {
                    List<Integer> tmp = Arrays.asList(new Integer[]{row, col});
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] isConnectedToOcean) {
        int rows = heights.length;
        int cols = heights[0].length;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : DIRs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || row >= rows || col < 0 || col >= cols || heights[cur[0]][cur[1]] > heights[row][col] || isConnectedToOcean[row][col]) {
                    continue;
                }
                System.out.println(row + " " + col + ", " + dir[0] + " " + dir[1]);
                isConnectedToOcean[row][col] = true;
                q.offer(new int[]{row, col});
            }
        }
    }

    public static void main(String[] args) {
        int[][] h = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        _417_PacificAtlanticWaterFlowBFS pawt = new _417_PacificAtlanticWaterFlowBFS();
        List<List<Integer>> res =  pawt.pacificAtlantic(h);
        System.out.println();
    }

}
