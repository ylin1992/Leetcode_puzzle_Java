package UnionFind;

/**
 *  id  0 1 2 3 4 5 6 7 8 9
 *  val 1 1 1 8 3 0 5 1 8 8
 *  find(5) = id[id[id[5]]]: 5->0->1->1->1
 *  when we find the parent, it should be parent[node] == node
 */
public class BasicUnionFind {
   private int[] rank;
   private int[] parent;

   public BasicUnionFind(int[][] sets) {
      rank = new int[sets.length];
      parent = new int[sets.length];
      for (int i = 0; i < sets.length; i++) {
         parent[i] = i;
      }
   }

   private int find(int node) {
      while (node != parent[node]) {
         // path suppression
         parent[node] = parent[parent[node]];
         node = parent[node];
      }
      return node;
   }

   private void union(int node1, int node2) {
      int root1 = find(node1);
      int root2 = find(node2);

      if (rank[root1] > rank[root2]) {
         // put root2 under root1
         parent[root2] = root1;
      } else if (rank[root2] > rank[root1]) {
         // put root1 under root2
         parent[root1] = root2;
      } else {
         // if ranks are the same, put either one under another
         // increase the new root's rank by 1
         parent[root1] = root2;
         rank[root2]++;
      }
   }

}
