package Tree;

import java.util.ArrayList;
import java.util.List;

public class _366_FindLeavesOfABinaryTree {
   public List<List<Integer>> findLeaves(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      int level = heightOf(root, res);
      return res;
   }
   private int heightOf(TreeNode root, List<List<Integer>> res) {
      if (root == null) return 0;

      int heightLeft = heightOf(root.left, res);
      int heightRight = heightOf(root.right, res);
      int h = Math.max(heightLeft, heightRight) + 1;

      // append the nodes inside of res list (with 0-indexed)
      if (res.size() < h-1+1)
         res.add(new ArrayList<>());
      res.get(h-1).add(root.val);
      return h;
   }

}
