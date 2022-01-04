package BFS;
import java.util.*;
public class _207_CourseScheduleDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        // initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // append directional info into the graph
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        int[] states = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, states)) return false;
        }

        return true;
    }

    private boolean dfs(int cur, List<List<Integer>> graph, int[] states) {
        // topological sort states:
        // 0 = pending, 1 = visiting, 2 = visited

        if (states[cur] == 1) return false;
        if (states[cur] == 2) return true;

        states[cur] = 1;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            if (!dfs(graph.get(cur).get(i), graph, states)) {
                return false;
            }
        }
        states[cur] = 2;
        return true;
    }

}
