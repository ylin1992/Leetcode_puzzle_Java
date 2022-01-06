package Tree;
import java.util.*;
public class _863_AllNodesDistanceKinBinaryTreeBFS {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(graph, root, null);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while (!q.isEmpty()) {
            if (k == 0) {
                while(!q.isEmpty()) {
                    res.add(q.poll().val);
                }
                return res;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                for (TreeNode nei : graph.get(cur)) {
                    if (visited.contains(nei)) continue;
                    visited.add(nei);
                    q.offer(nei);
                }
            }
            k--;
        }
        return res;

    }

    private void buildGraph(HashMap<TreeNode, List<TreeNode>> graph, TreeNode root, TreeNode parent) {
        if (root == null) return;

        if (!graph.containsKey(root)) {
            graph.put(root, new ArrayList<>());
            if (parent != null) {
                graph.get(root).add(parent);
                graph.get(parent).add(root);
            }
            buildGraph(graph, root.left, root);
            buildGraph(graph, root.right, root);
        }
    }
}
