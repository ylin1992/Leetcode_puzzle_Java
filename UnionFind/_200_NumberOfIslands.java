package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class _200_NumberOfIslands {
   class UnionFind {
      private List<Integer> parent;
      private List<Integer> rank; // path compression
      private int count;
      private int rows;
      private int cols;

      public UnionFind(char[][] grid) {
         count = 0;
         rows = grid.length;
         cols = grid[0].length;
         parent = new ArrayList<>();
         rank = new ArrayList<>();
         // initially, all '1' nodes' parent are themself
         // example, node#1, 2, 4 are '1's
         // idx: 0  1  2  3  4  5  6  7  8  9
         // val: -1 1  2  -1 4 ...
         for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               if (grid[i][j] == '1') {
                  parent.add(two2one(i,j));
                  count++;
               } else {
                  parent.add(-1);
               }
               rank.add(0);
            }
         }
      }

      public int two2one(int row, int col) {
         return row * cols + col;
      }

      // returns the root of a given node
      public int find(int node) {
         while (node != parent.get(node)) {
            // parent[node] = parent[parent[node]] -> path compression
            parent.set(node, parent.get(parent.get(node)));
            node = parent.get(node);
         }
         return node;
      }

      public void union(int node1, int node2) {
         int root1 = find(node1);
         int root2 = find(node2);

         if (root1 == root2) {
            return;
         }

         if (rank.get(root1) > rank.get(root2)) {
            //put root2 under root1
            parent.set(root2, root1);
         } else if (rank.get(root2) > rank.get(root1)) {
            parent.set(root1, root2);
         } else {
            parent.set(root1, root2);
            // rank[root2]++
            rank.set(root2, rank.get(root2) + 1);
         }
         // since two trees are merged, the count of unions should decrease by 1
         count--;
      }
      public int getCount() {
         return count;
      }
   }

   public int numIslands(char[][] grid) {
      UnionFind uf = new UnionFind(grid);
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
               grid[i][j] = '0';
               if (i-1>=0 && grid[i-1][j  ] == '1')
                  uf.union(uf.two2one(i,j), uf.two2one(i-1,j));
               if (j-1>=0 && grid[i  ][j-1] == '1')
                  uf.union(uf.two2one(i,j), uf.two2one(i,j-1));
               if (i+1<grid.length    && grid[i+1][j  ] == '1')
                  uf.union(uf.two2one(i,j), uf.two2one(i+1,j));
               if (j+1<grid[0].length && grid[i  ][j+1] == '1')
                  uf.union(uf.two2one(i,j), uf.two2one(i,j+1));
            }
         }
      }
      return uf.getCount();
   }

   public static void main(String[] args) {
      _200_NumberOfIslands solution = new _200_NumberOfIslands();
      solution.numIslands(new char[][] {
         {'1','1','1','1','0'},
         {'1','1','0','1','0'},
         {'1','1','0','0','0'},
         {'0','0','0','0','0'}
      });
   }
}
