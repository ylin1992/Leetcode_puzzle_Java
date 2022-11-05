package Tree;

public class _270_ClosestBinarySearchTreeValue {
   public int closestValue(TreeNode root, double target) {
      double diff = 10e9;
      int res = root.val;
      while (root != null) {
         double curDiff = Math.abs(root.val - target);
         if (curDiff < diff) {
            diff = curDiff;
            res = root.val;
         }

         if (root.val > target)
            root = root.left;
         else
            root = root.right;
      }
      return res;
   }

}
