package Tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeNodeHelper {
    public TreeNodeHelper() {
    }

    public TreeNode levelOrderTree(Integer[] arr) {
        Queue<TreeNode> q = new LinkedList<>();
        int state = 0; // 0: left 1: right
//        q.offer(new TreeNode(arr[0]));
        TreeNode root = null;
        TreeNode curr = null;
        for (Integer val : arr) {
            if (root == null) {
                root = new TreeNode(val);
                q.offer(root);
                curr = root;
            } else {
                if (val == null) {
                    if (state == 0) {
                        state = 1;
                    } else {
                        q.poll();
                        curr = q.peek();
                        state = 0;
                    }
                } else if (state == 0) {
                    curr.left = new TreeNode(val);
                    q.offer(curr.left);
                    state = 1;
                } else if (state == 1) {
                    curr.right = new TreeNode(val);
                    q.offer(curr.right);
                    q.poll();
                    curr = q.peek();
                    state = 0;
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNodeHelper helper = new TreeNodeHelper();
        TreeNode node = helper.levelOrderTree(new Integer[]{5,3,6,2,4,null,null,1});
        System.out.println();
    }
}
