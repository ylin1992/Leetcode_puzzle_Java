package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _200_GraphValidTree {
   public boolean validTree(int n, int[][] edges) {
      List<ArrayList<Integer>> adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) { adjList.add(new ArrayList<>()); }
      for (int[] edge : edges) {
         int from = edge[0];
         int to = edge[1];
         adjList.get(from).add(to);
         adjList.get(to).add(from);
      }
      printAdj(adjList);
      HashSet<Integer> visited = new HashSet<>();
      boolean res = false;
      visited.add(0);
      for (int to : adjList.get(0)) {
         // if (visited.contains(to)) continue;
         if (!dfs(adjList, visited, to, 0)) return false;
      }
      System.out.println(visited.size());
      return visited.size() == n;

   }

   private boolean dfs(List<ArrayList<Integer>> list, HashSet<Integer> visited, int cur, int from) {
      if (visited.contains(cur)) {
         System.out.println("cur: " + cur + " returns false");
         return false;
      }

      visited.add(cur);
      for (int to : list.get(cur)) {
         if (to == from) continue;
         if (!dfs(list, visited, to, cur)) {
            System.out.println("cur: " + cur + "and to: " + to + " returns false");
            return false;
         }
      }
      System.out.println("cur: " + cur + " returns true");
      return true;
   }

   private void printSet(HashSet<Integer> set) {
      for (int visited : set) {
         System.out.print(visited + " ");
      }
      System.out.print("\n");
   }

   private void printAdj(List<ArrayList<Integer>> list) {
      for (int i = 0; i < list.size(); i++) {
         System.out.print(i + ": ");
         for (int nei : list.get(i)) {
            System.out.print(nei + " ");
         }
         System.out.print("\n");
      }
   }

}
