package BFS;
import Tree.TreeNode;

public class _230_KthSmallestElementInABST {
   public int kthSmallest(TreeNode root, int k) {
      Count c = new Count(k);
      dfs(root, c);
      return c.getNum();
   }

   private void dfs(TreeNode root, Count c) {
      if (root == null) return;
      if (root.left != null) dfs(root.left, c);
      c.decreaseCount();
      if (c.getCount() == 0) {
         c.setNum(root.val);
         return;
      }
      if (root.right != null) dfs(root.right, c);
   }
}
class Count {
   private int count;
   private int num;
   public Count(int c) {
      count = c;
      num = 0;
   }
   public int getCount() { return count; }
   public int getNum() { return num; }
   public void decreaseCount() { count--; }
   public void setNum(int n) { num = n; }
}
