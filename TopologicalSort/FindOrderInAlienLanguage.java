package TopologicalSort;

import java.util.*;

public class FindOrderInAlienLanguage {

   // k means: the max length of string in the dict
   // n means: the length of the dict
   public String findOrder(String [] dict, int N, int K)
   {
      // Write your code here
      HashMap<Character, List<Character>> adjList = new HashMap<>();
      for (int i = 0; i < K; i++) {
         adjList.put((char)(i + 'a'), new ArrayList<>());
      }

      for (int i = 0; i < dict.length - 1; i++) {
         String str1 = dict[i];
         String str2 = dict[i+1];
         for (int k = 0; k < Math.min(str1.length(), str2.length()); k++) {
            char c1 = str1.charAt(k);
            char c2 = str2.charAt(k);
            if (c1 != c2) {
               if (!adjList.containsKey(c1)) {
                  adjList.put(c1, new ArrayList<>());
               }
               adjList.get(c1).add(c2);
               break;
            }
         }
      }

      // for (Map.Entry<Character, List<Character>> entry : adjList.entrySet()) {
      //     System.out.print(entry.getKey() + ": ");
      //     for (char c : entry.getValue()) {
      //         System.out.print(c + " ");
      //     }
      //     System.out.println();
      // }

      HashSet<Character> visited = new HashSet<>();
      Stack<Character> stk = new Stack<>();
      for (int i = 0; i < K; i++) {
         if (!visited.contains((char)(i + 'a')))
            dfs((char)(i + 'a'), adjList, visited, stk);
      }
      StringBuilder sb = new StringBuilder();
      while (!stk.isEmpty()) {
         sb.append(stk.pop());
      }
      //  System.out.println(sb.toString());
      return sb.toString();
   }

   private void dfs(char v, HashMap<Character, List<Character>> adjList, HashSet<Character> visited, Stack<Character> stk) {
      visited.add(v);
      for (char u : adjList.get(v)) {
         if (!visited.contains(u)) {
            dfs(u, adjList, visited, stk);
         }
      }
      // System.out.println(v);
      stk.push(v);
   }
}

// [""]