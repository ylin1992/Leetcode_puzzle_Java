package Tree;

public class _814_BinaryTreePruning {
   public TreeNode pruneTree(TreeNode root) {
      boolean contains = containsOnes(root);
      return contains == false ? null : root;
   }

   private boolean containsOnes(TreeNode root) {
      if (root == null) return false;

      boolean left = containsOnes(root.left);
      boolean right = containsOnes(root.right);
      if (!left)
         root.left = null;
      if (!right)
         root.right = null;
      return left || right || root.val == 1;
   }

}
