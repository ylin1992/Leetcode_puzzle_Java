package BFS;
import java.util.*;
// [[1,0],[0,1]]
// 0 -> 1
// 1 -> 0
// states[n], 0->unvisited, 1->visiting, 2->visited

// dfs(adj, cur):
// cur: visiting -> return false;
// cur: visited -> return true;

// mark cur as visiting
// dfs()
// mark cur as visited
public class _207_CourseScheduleDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) { adj.add(new ArrayList<>()); }
        for (int[] pre : prerequisites) { adj.get(pre[0]).add(pre[1]); }
        int[] states = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean possible = dfs(adj, states, i);
            if (!possible) return false;
        }
        return true;
    }

    private boolean dfs(List<ArrayList<Integer>> adj, int[] states, int cur) {
        if (states[cur] == 1) return false; // cycle found
        if (states[cur] == 2) return true; // already visited

        states[cur] = 1; // mark it as visiting and do DFS starting from cur
        for (int neighbor : adj.get(cur)) {
            boolean res = dfs(adj, states, neighbor);
            if (!res) return false;
        }
        states[cur] = 2;
        return true;
    }



}
