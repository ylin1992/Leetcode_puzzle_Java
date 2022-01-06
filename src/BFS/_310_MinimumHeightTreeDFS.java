package BFS;
import java.util.*;
public class _310_MinimumHeightTreeDFS {
    int min;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0;i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int d = dfs(graph, i, visited);
            if (d < min) {
                res = new ArrayList<>();
                res.add(i);
                min = d;
            }
            if (d == min) {
                res.add(i);
            }
        }

        return res;
    }

    private int dfs(List<List<Integer>> graph, int cur, boolean[] visited) {
        if (visited[cur]) return 0;
        if (graph.get(cur).size() == 0) {
            return 0;
        }
        System.out.println(cur);
        visited[cur] = true;
        int depth = 0;
        int maxDepth = Integer.MIN_VALUE;
        for (int nei : graph.get(cur)) {
            depth += Math.max(maxDepth ,dfs(graph, nei, visited));
            if (depth > min) return depth;
        }
        return depth + 1;
    }

    public static void main(String[] args) {
        _310_MinimumHeightTreeDFS mht = new _310_MinimumHeightTreeDFS();
        List<Integer> res = mht.findMinHeightTrees(4, new int[][]{{1,0}, {1,2},{1,3}});
    }
}
