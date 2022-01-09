package Tree;
import java.util.*;
public class _113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, res, new ArrayList<>());
        return res;
    }
    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        dfs(root.left, targetSum - root.val, res, path);
        dfs(root.right, targetSum - root.val, res, path);
        path.remove(path.size() - 1);
    }
    // [5 4 11 7]
    // 17 13 2
    public static void main(String[] args) {
        TreeNodeHelper helper = new TreeNodeHelper();
        TreeNode root = helper.levelOrderTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        _113_PathSumII ps = new _113_PathSumII();
        ps.pathSum(root, 22);
    }
}
