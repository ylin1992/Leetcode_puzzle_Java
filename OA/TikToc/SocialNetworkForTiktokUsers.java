package OA.TikToc;

import java.util.HashMap;
import java.util.Scanner;

public class SocialNetworkForTiktokUsers {

   public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int numTotal = sc.nextInt();
         UnionFind uf = new UnionFind(numTotal);
         for (int i = 0; i < numTotal; i++) {
            String nextLine = sc.nextLine();
            String[] strs = nextLine.split(" ");
            if (strs.length != 2) {
               i--;
               continue;
            }
            try {
               int num1 = Integer.parseInt(strs[0]);
               int num2 = Integer.parseInt(strs[1]);
               uf.union(num1, num2);
               System.out.println(uf.getMaxNum());
            } catch (Exception e) {
               System.out.println(e);
            }
         }
   }
}

class UnionFind {
   private int[] parent;
   private int[] rank;
   private HashMap<Integer, Integer> map;
   private int maxNum;
   public UnionFind(int totalNum) {
      parent = new int[totalNum];
      rank = new int[totalNum];
      map = new HashMap<>();
      maxNum = 0;
      for (int i = 0; i < parent.length;i++) {
         parent[i] = i;
         map.put(i,1);
      }
   }
   public int find(int node) {
      while (node != parent[node]) {
         node = parent[node];
      }
      return node;
   }
   public void union(int node1, int node2) {
      int root1 = find(node1);
      int root2 = find(node2);

      if (root1 == root2)
         return;
      if (rank[root1] > rank[root2]) {
         parent[root2] = root1;
         map.put(root1, map.get(root2) + map.get(root1));
      } else if (rank[root1] < rank[root2]) {
         parent[root1] = root2;
         map.put(root2, map.get(root1) + map.get(root2));
      } else {
         parent[root1] = root2;
         rank[root2]++;
         map.put(root2, map.get(root1) + map.get(root2));
      }
      maxNum = Math.max(maxNum, map.get(root1));
      maxNum = Math.max(maxNum, map.get(root2));
   }
   public int getMaxNum() {
      return maxNum;
   }
}
