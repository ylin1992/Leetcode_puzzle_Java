package Tree;

import java.util.*;

public class _314_BinaryTreeVerticalOrderTraversalOtherSol {
   private int min;
   private int max;
   public List<List<Integer>> verticalOrder(TreeNode root) {
      if (root == null) return new ArrayList<>();
      min = 0;
      HashMap<TreeNode, Integer> map = new HashMap<>();
      tag(root, map, 0);
      List<List<Integer>> res = new ArrayList<>();
      initList(res);
      bfs(root, res, map);
      return res;
   }

   private void initList(List<List<Integer>> list) {
      for (int i = 0;i < max - min + 1; i++) {
         list.add(new ArrayList<>());
      }
   }

   private void tag(TreeNode root, HashMap<TreeNode, Integer> map, int hLevel) {
      if (root == null)
         return;
      map.put(root, hLevel);
      min = Math.min(min, hLevel);
      max = Math.max(max, hLevel);
      tag(root.left, map, hLevel - 1);
      tag(root.right, map, hLevel + 1);
   }

   private void bfs(TreeNode root, List<List<Integer>> res, HashMap<TreeNode, Integer> map) {
      if (root == null)
         return;
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
         int size = q.size();
         for (int i = 0; i < size; i++) {
            TreeNode cur = q.poll();
            int hLevel = map.get(cur);
            int listIndex = hLevel - min;
            res.get(listIndex).add(cur.val);

            if (cur.left != null)
               q.offer(cur.left);
            if (cur.right != null)
               q.offer(cur.right);
         }
      }
   }

}
