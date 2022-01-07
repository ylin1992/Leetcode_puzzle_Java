package Tree;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode levelOrderTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[1]);
        TreeNode head = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int k = q.size();
        for (int i = 0; i < arr.length; i+=k) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode cur = q.poll();
                if (arr[i+size*2] != null) {
                    cur.left = new TreeNode(arr[i+size*2]);
                } else {
                    cur.left = null;
                }

                if (arr[i+size*2+1] != null) {
                    cur.right = new TreeNode(arr[i+size*2+1]);
                } else {
                    cur.right = null;
                }

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);

            }
            k = q.size();
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.levelOrderTree(new Integer[]{3,1,4,null,2});
        System.out.println();
    }
}
