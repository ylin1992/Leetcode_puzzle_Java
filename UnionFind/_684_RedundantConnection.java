package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class _684_RedundantConnection {
   private List<Integer> parent;
   private List<Integer> rank;

   // returns the root of a given node, and suppresses the tree
   private int find(int node) {
      while (node != parent.get(node)) {
         // parent[node] = node;
         // node = parent[node];

         parent.set(node, parent.get(node));
         node = parent.get(node);
      }
      return node;
   }
   // returns false if node1 and node2 share the same root
   private boolean union(int node1, int node2) {
      int root1 = find(node1);
      int root2 = find(node2);

      if (root1 != root2) {
         if (rank.get(root1) > rank.get(root2)) {
            parent.set(root2, root1);
         } else if (rank.get(root2) > rank.get(root1)) {
            parent.set(root1, root2);
         } else {
            // parent[root2] = root1
            // set root1 as root2's root
            parent.set(root2, root1);
            rank.set(root1, rank.get(root1) + 1);
         }
      } else {
         return false;
      }
      return true;
   }

   public int[] findRedundantConnection(int[][] edges) {
      parent = new ArrayList<>();
      rank = new ArrayList<>();
      for (int i = 0; i <= edges.length; i++) {
         parent.add(i);
         rank.add(0);
      }

      for (int i = 0; i < edges.length; i++) {
         int node1 = edges[i][0], node2 = edges[i][1];
         if (!union(node1, node2)) {
            return new int[] {node1, node2};
         }
      }
      return new int[]{-1,-1};
   }
}
