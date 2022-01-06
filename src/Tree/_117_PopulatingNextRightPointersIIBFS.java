package Tree;

public class _117_PopulatingNextRightPointersIIBFS {
    public Node connect(Node root) {
        if (root == null) return root;

        Node cur = root; // current level node
        Node head = null; // head of next level, which will be the next cur when this level is done
        Node leading = null; // the traveling node at the next level

        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        // cur.left is the first non-null Node found, so as leading
                        head = cur.left;
                        leading = cur.left;
                    } else {
                        // cur.left is not the first non-null node, we can assign leading.next to this node
                        leading.next = cur.left;
                        leading = leading.next;
                    }
                }
                if (cur.right != null) {
                    if (head == null) {
                        // cur.right is the first node at the next level, so as leading
                        head = cur.right;
                        leading = cur.right;
                    } else {
                        leading.next = cur.right;
                        leading = leading.next;
                    }
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            leading = null;
        }
        return root;
    }
}
