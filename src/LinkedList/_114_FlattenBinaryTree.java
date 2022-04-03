package LinkedList;
import Tree.TreeNode;

public class _114_FlattenBinaryTree {
   // in each recursion, we do the following:
   // 1. set root.left.right as root.right
   // 2. connect the right-most child of root.left to root.right
   //     a. traverse all the way down to the right most node, call it "tempRoot"
   //     b. connect tempRoot.right = root.right
   //     c. replace root.right with root.left
   //     d. right now, root.right should be a chain of flattened tree
   // 3. set root.left = null, so that the dangling part will be discarded
   // so far, the root will only have right child, which is a chain of its children.
   // Besides, this approach should be done with post-order traversal, since we need to do it bottom-up
   public void flatten(TreeNode root) {
      if (root == null) return;

      flatten(root.left);
      flatten(root.right);

      if (root.left == null) return;
      TreeNode tempRoot = root.left;
      while (tempRoot.right != null) {
         tempRoot = tempRoot.right;
      }
      tempRoot.right = root.right;
      root.right = root.left;
      root.left = null;
   }
}
