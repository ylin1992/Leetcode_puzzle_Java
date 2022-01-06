package Tree;
import java.util.*;
public class _103_BinaryTreeZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int state = 0; // even: 0, odd: 1
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (state == 0) {
                    tmp.add(cur.val);
                } else {
                    tmp.add(0, cur.val);
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            state = state == 0 ? 1 : 0;
            res.add(tmp);
        }
        return res;
    }

}
