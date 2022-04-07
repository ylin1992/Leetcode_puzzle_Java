package LinkedList;

import java.util.HashMap;

public class _138_CopyListWithRandomPointer {
   class Node {
      int val;
      Node next;
      Node random;

      public Node(int val) {
         this.val = val;
         this.next = null;
         this.random = null;
      }
   }
   // O(n)
   public Node copyRandomList(Node head) {
      if (head == null) return null;
      HashMap<Node, Node> map = new HashMap<>(); // Key: nodes in the original chain, Value: the new chain

      for (Node ptr = head; ptr != null; ptr = ptr.next) {
         map.put(ptr, new Node(ptr.val));
      }

      for (Node ptr = head; ptr != null; ptr = ptr.next) {
         map.get(ptr).next = map.get(ptr.next);
         map.get(ptr).random = map.get(ptr.random);
      }

      return map.get(head);
   }
}
