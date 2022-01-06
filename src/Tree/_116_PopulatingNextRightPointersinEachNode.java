package Tree;
import java.util.*;
public class _116_PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        // Space O(1)
        // Without queue
        if (root == null) return null;

        Node p = root;
        while (p != null) {
            Node cur = p;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            p = p.left;
        }
        return root;
    }

}
