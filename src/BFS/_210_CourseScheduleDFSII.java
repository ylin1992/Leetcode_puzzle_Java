package BFS;
import java.util.*;
public class _210_CourseScheduleDFSII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        List<Integer> res = new ArrayList<>();
        int[] states = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(res, graph, states, i)) {
                return new int[0];
            }
        }

        int[] resArr = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            resArr[j] = res.get(j);
        }
        return resArr;
    }
    //  i  e
    //  0  1. 2. 3
    //  1  2  3
    // ...
    private boolean dfs(List<Integer> res, List<List<Integer>> prer, int[] states, int cur) {
        if (states[cur] == 2) {
            return true;
        }

        if (states[cur] == 1) {
            return false; // visiting -> end up having a cycle in the graph
        }

        states[cur] = 1;
        for (int neighbor : prer.get(cur)) {
            if (!dfs(res, prer, states, neighbor)) {
                return false;
            }
        }
        res.add(cur);
        states[cur] = 2;
        return true;
    }

    public static void main(String[] args) {
        _210_CourseScheduleDFSII cs = new _210_CourseScheduleDFSII();
        int[] res = cs.findOrder(2, new int[][]{{1,0}});
    }
}
