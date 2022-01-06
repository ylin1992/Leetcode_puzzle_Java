package BFS;
import java.util.*;
public class _210_CourseScheduleIIBFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int [] res = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++; // get indegree tables
        }

        int idx = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                res[idx++] = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            int size = graph.get(cur).size();
            list.add(cur);
            for (int neighbor : graph.get(cur)) {
                if (--indegree[neighbor] == 0) {
                    q.offer(neighbor);
                    res[idx++] = neighbor;
                }
            }
        }

        if (idx != numCourses) return new int[0];
        return res;
    }

    public static void main(String[] args) {
        _210_CourseScheduleIIBFS cs = new _210_CourseScheduleIIBFS();
        cs.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
    }
}
