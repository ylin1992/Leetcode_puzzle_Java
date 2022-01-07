package Tree;

public class _230_KthSmallestElementInABST {
    int k;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        this.result = 0;
        this.k = k;
        inOrder(root);
        return result;
    }
    private void inOrder(TreeNode root) {
        if (root == null || k < 0) return;

        inOrder(root.left);
        if (--k == 0) {
            result = root.val;
            return;
        }
        inOrder(root.right);

    }

    public static void main(String[] args) {
        TreeNodeHelper helper = new TreeNodeHelper();
        TreeNode root = helper.levelOrderTree(new Integer[]{3,1,4,null,2});
        _230_KthSmallestElementInABST seb = new _230_KthSmallestElementInABST();
        int res = seb.kthSmallest(root, 1);
        System.out.println();
    }

}
