package Tree;

public class _236_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // case 1: p and q are on the oppsite
        // p <- root -> q
        if (left != null && right != null) return root;

        // case 2: if one of the nodes is LCA
        // which means that there should be one null node returned

        if (left == null) return right;
        if (right == null) return left;
        return null;
    }

}
