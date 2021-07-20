package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_BinaryTreeSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (root.right != null) queue.offer(root.right);
                if (root.left != null) queue.offer(root.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _199_BinaryTreeSideView btsv = new _199_BinaryTreeSideView();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        btsv.rightSideView(root);
    }
}
