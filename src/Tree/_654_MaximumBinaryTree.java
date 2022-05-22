package Tree;

public class _654_MaximumBinaryTree {
   public TreeNode constructMaximumBinaryTree(int[] nums) {
      return helper(nums, 0, nums.length - 1);
   }

   private TreeNode helper(int[] nums, int start, int end) {
      if (start > end) return null;

      int maxIdx = start;
      int max = Integer.MIN_VALUE;
      for (int i = start; i <= end; i++) {
         if (max < nums[i]) {
            max = nums[i];
            maxIdx = i;
         }
      }
      // System.out.println("max: " + max);
      TreeNode root = new TreeNode(max);
      TreeNode left = helper(nums, start, maxIdx - 1);
      TreeNode right = helper(nums, maxIdx + 1, end);
      root.left = left;
      root.right = right;
      return root;
   }

}
