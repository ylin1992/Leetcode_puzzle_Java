package Tree;
// in a BST, if there is a node whose value between p.val and q.val, that node is a common ancestor of p and q
// if p.val or q.val = root, then root is the "lowest" common ancestor
public class _235_LowestCommonAncestorInBST {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return helper(root, p, q);
   }
   private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) return null;

      TreeNode lca = null;
      if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)) {
         lca = root;
         return lca;
      }
      TreeNode leftRet = helper(root.left, p, q);
      TreeNode rightRet = helper(root.right, p, q);
      if (leftRet != null) lca = leftRet;
      if (rightRet != null) lca = rightRet;
      return lca;
   }

}
