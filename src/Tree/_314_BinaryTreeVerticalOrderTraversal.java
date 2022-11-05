package Tree;

import java.util.*;

public class _314_BinaryTreeVerticalOrderTraversal {
   // Same Strategy for BFS, for each node the is being visited,
   // encode its node and its col index
   public List<List<Integer>> verticalOrder(TreeNode root) {
      // HashMap<Integer, List<Integer>> map = new HashMap<>();
      if (root == null) return new ArrayList<>();
      List<Integer>[] arr = new List[200];
      Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();

      q.offer(Map.entry(root, 100));

      arr[100] = new ArrayList<>();
      arr[100].add(root.val);

      int minCol = 100;

      while (!q.isEmpty()) {
         int size = q.size();
         for (int i = 0; i < size; i++) {
            Map.Entry<TreeNode, Integer> cur = q.poll();
            int col = cur.getValue();
            if (cur.getKey().left != null) {
               q.offer(Map.entry(cur.getKey().left, col - 1));
               if (arr[col - 1] == null) {
                  arr[col - 1] = new ArrayList<>();
               }
               arr[col - 1].add(cur.getKey().left.val);
               minCol = Math.min(col - 1, minCol);
            }
            if (cur.getKey().right != null) {
               q.offer(Map.entry(cur.getKey().right, col + 1));
               if (arr[col + 1] == null) {
                  arr[col + 1] = new ArrayList<>();
               }
               arr[col + 1].add(cur.getKey().right.val);
               minCol = Math.min(col + 1, minCol);
            }
         }
      }
      List<List<Integer>> res = new ArrayList<>();
      for (int i = minCol; i < arr.length; i++) {
         if (arr[i] != null)
            res.add(arr[i]);
      }
      return res;
   }
}
