package Tree;
import java .util.*;
public class _107_LevelOrderTraversal2BFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(0, tmp);
        }

        return res;
    }

}
