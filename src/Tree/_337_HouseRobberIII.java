package Tree;

public class _337_HouseRobberIII {
   public int rob(TreeNode root) {
      int[] res = postOrder(root);
      return Math.max(res[0], res[1]);
   }

   private int[] postOrder(TreeNode root) {
      if (root == null) return new int[2];

      int[] leftRet = postOrder(root.left);
      int[] rightRet = postOrder(root.right);

      return new int[] {
            // if we don't rob the current node, the child node can either be robbed or not robbed
            // pick the largest combination outcome
            Math.max(leftRet[0], leftRet[1]) + Math.max(rightRet[0], rightRet[1]),
            // if we rob the current node, the child should not be robbed
            root.val + leftRet[0] + rightRet[0]
      };
   }
}
