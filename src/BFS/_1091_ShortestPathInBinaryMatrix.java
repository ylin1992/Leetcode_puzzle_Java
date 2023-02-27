package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _1091_ShortestPathInBinaryMatrix {
   private static final int[][] DIRs = {{-1, -1}, {-1, 0}, {-1, 1},
         {0 , -1}, { 0, 0}, { 0, 1},
         {1,  -1}, { 1, 0}, { 1, 1}};
   public int shortestPathBinaryMatrix(int[][] grid) {
      int n = grid.length;
      if (n == 0)
         return 0;
      if (n == 1)
         return grid[0][0] == 0 ? 1 : -1;
      if (grid[0][0] == 1)
         return -1;
      if (grid[n-1][n-1] == 1)
         return -1;

      Queue<int[]> q = new LinkedList<>();
      HashSet<String> visited = new HashSet<>();

      int[][] shortestDist = new int[n][n];
      shortestDist[0][0] = 1;

      q.offer(new int[] {0, 0});
      while (!q.isEmpty()) {
         int size = q.size();
         for (int i = 0; i < size; i++) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (visited.contains(cur[0]+""+cur[1]))
               continue;
            for (int[] dir : DIRs) {
               int dr = dir[0];
               int dc = dir[1];
               if (dr + r >= n || dr + r < 0 || dc + c >= n || dc + c < 0 || grid[dr+r][dc+c] != 0)
                  continue;
               if (shortestDist[dr+r][dc+c] == 0) {
                  shortestDist[dr+r][dc+c] = shortestDist[r][c] + 1;
               } else {
                  shortestDist[dr+r][dc+c] = Math.min(shortestDist[r][c] + 1, shortestDist[dr+r][dc+c]);
               }
               q.offer(new int[] {dr+r, dc+c});
            }

            visited.add(cur[0]+""+cur[1]);
         }
      }
      return shortestDist[n-1][n-1] == 0 ? -1 : shortestDist[n-1][n-1];
   }

}
