package BFS;
import java.util.*;
public class _310_MinimunHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                res.add(cur);
                for (int nei : graph.get(cur)) {
                    if (--indegree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(0);
        return res;
    }

}
