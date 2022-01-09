package Tree;

public class _98_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root.left, root.val, null) && dfs(root.right, null, root.val);
    }

    private boolean dfs(TreeNode root, Integer upper, Integer lower) {
        if (root == null) return true;

        if (upper != null && root.val >= upper) return false;
        if (lower != null && root.val <= lower) return false;

        return dfs(root.left, root.val, lower) && dfs(root.right, upper, root.val);
    }

}
