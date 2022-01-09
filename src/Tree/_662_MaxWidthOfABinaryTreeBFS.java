package Tree;
import java.util.*;
public class _662_MaxWidthOfABinaryTreeBFS {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int level = 0;
        List<Integer> lefts = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int max = Integer.MIN_VALUE;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (lefts.size() == level) {
                    lefts.add(map.get(cur));
                }
                int curIndex = map.get(cur);
                max = Math.max(max, curIndex - lefts.get(level) + 1);
                if (cur.left != null) {
                    q.offer(cur.left);
                    map.put(cur.left, curIndex * 2);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    map.put(cur.right, curIndex * 2 + 1);
                }
            }
            level++;
        }
        return max;
    }

}
