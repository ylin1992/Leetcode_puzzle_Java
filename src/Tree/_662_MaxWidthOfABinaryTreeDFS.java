package Tree;
import java.util.*;
public class _662_MaxWidthOfABinaryTreeDFS {
    /**
     * Heap representation:
     * starts from index = 1
     * left nodes: index = parent_index * 2
     * right nodes: index = parent_index * 2 + 1
     */
    int max;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        dfs(root, new ArrayList<>(), 0, 1);
        return max;
    }
    private void dfs(TreeNode root, List<Integer> lefts, int level, int index) {
        if (root == null) return;

        // add the leftmost node's index into the lefts list (heap representation)
        if (lefts.size() == level) {
            lefts.add(index);
        }

        max = Math.max(max, index - lefts.get(level) + 1); // +1 converts distance to width
        dfs(root.left, lefts, level + 1, index * 2);
        dfs(root.right, lefts, level + 1, index * 2 + 1);

    }

    public static void main(String[] args) {
        TreeNodeHelper helper = new TreeNodeHelper();
        TreeNode root = helper.levelOrderTree(new Integer[]{1,3,2,5,3,null,9});
        _662_MaxWidthOfABinaryTreeDFS mwobt = new _662_MaxWidthOfABinaryTreeDFS();
        int res = mwobt.widthOfBinaryTree(root);
    }
}
