package Tree;
// find the lowest common ancestor (lca)
// if (lca != s && lca != d)
//      res = reverse(path(lca->s)) + path(lca->d)
// if (lca == s)
//      res = path(lca->d)
// if (lca == d)
//      res = reverse(path(d->lca))
public class _2096_StepByStepDirectionsFromABinaryTreeNodeToAnother {
   public String getDirections(TreeNode root, int startValue, int destValue) {
      TreeNode lca = getLCA(root, startValue, destValue);
      if (lca != null)
         System.out.println(lca.val);

      if (lca.val != startValue && lca.val != destValue) {
         String lcaToStart = getPath(lca, lca.val, startValue, new StringBuilder());
         String lcaToDest = getPath(lca, lca.val, destValue, new StringBuilder());
         String reversed = reverse(lcaToStart);
         return reversed + lcaToDest;
      } else if (lca.val == startValue) {
         String lcaToDest = getPath(lca, lca.val, destValue, new StringBuilder());
         return lcaToDest;
      } else if (lca.val == destValue) {
         String lcaToStart = getPath(lca, lca.val, startValue, new StringBuilder());
         return reverse(lcaToStart);
      }
      return null;
   }
   private TreeNode getLCA(TreeNode root, int s, int d) {
      if (root == null) return null;
      if (root.val == s || root.val == d) return root;

      TreeNode left = getLCA(root.left, s, d);
      TreeNode right = getLCA(root.right, s, d);

      if (left != null && right != null) return root;
      if (left == null) return right;
      if (right == null) return left;
      return null;
   }
   private String getPath(TreeNode root, int from, int to, StringBuilder sb) {
      if (root == null) return null;
      if (root.val == to) return sb.toString();

      sb.append("L");
      String left = getPath(root.left, root.val, to, sb);
      sb.deleteCharAt(sb.length() - 1);
      sb.append("R");
      String right = getPath(root.right, root.val, to, sb);
      sb.deleteCharAt(sb.length() - 1);
      if (left != null) return left;
      if (right != null) return right;
      return null;
   }
   private String reverse(String path) {
      StringBuilder sb = new StringBuilder();
      for (char c : path.toCharArray()) {
         if (c == 'L' || c == 'R')
            sb.append('U');
         else
            sb.append(c);
      }
      return sb.toString();
   }

}
