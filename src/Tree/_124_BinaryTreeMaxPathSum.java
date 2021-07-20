package Tree;

//import javax.swing.tree.TreeNode;

public class _124_BinaryTreeMaxPathSum {


    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        int sum = helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftVal = maxPathSum(root.left);
        int rightVal = maxPathSum(root.right);

        int sum = leftVal + rightVal + root.val;
        max = Math.max(sum, max);
        return sum;
    }

    public int reverseNum(int num) {
        int res = 0;
        int digit = 0;
        int k = num;
        while (k != 0) {
            k = k / 10;
            digit++;
        }
        while (num != 0) {
            int rem = num % 10;
            num /= 10;
            res += rem * Math.pow(10, digit--);
        }
        return res;
    }

    public static void main(String[] args) {
        _124_BinaryTreeMaxPathSum btmps = new _124_BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        //btmps.maxPathSum(root);
        System.out.println(btmps.reverseNum(54321));
    }
}

