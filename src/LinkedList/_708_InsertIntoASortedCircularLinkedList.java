package LinkedList;
/*
    first pass: records where the min and max nodes are

    cases:
    1. new node inserted in the cycle
        while (!(cur.val < insertVal && next.val > insertVal))
            cur = cur.next;
            next = next.next;
        cur -> new node -> next
    2. new node <= min node
        same as (3)
    3. new node >= max node
        if (insertVal > maxNode)
            maxNode -> newNode -> minNode
    4. if min == max
        insert it into anywhere
        head -> newNode -> head.next

    5. edge cases:
        a. head == null
        b. list.size() == 1 (head.next = head)
*/
public class _708_InsertIntoASortedCircularLinkedList {
   public Node insert(Node head, int insertVal) {
      if (head == null) {
         Node n = new Node(insertVal);
         n.next = n;
         return n;
      }
      if (head.next == head) {
         Node n = new Node(insertVal, head);
         head.next = n;
         return head;
      }

      // first pass
      Node minNode = head;
      Node maxNode = head;
      Node cur = head;
      boolean isSecondRound = false;
      while (true) {
         if (cur.val >= maxNode.val)
            maxNode = cur;
         if (cur.val < minNode.val)
            minNode = cur;
         cur = cur.next;
         if (isSecondRound && cur == head)
            break;
         isSecondRound = true;
      }
      // System.out.print("min: " + minNode.val + ", max: " + maxNode.val);

      // min == max
      if (minNode.val == maxNode.val) {
         Node nnext = head.next;
         Node n = new Node(insertVal);
         head.next = n;
         n.next = nnext;
         return head;
      }

      // if insertVal >= max || insertVal <= min
      // max -> n -> maxNext
      // we should not insert in this way: max -> n -> min
      // [3, 5, 6, 3], insertVal = 3
      //  ^min  ^max
      // reseult would be [3, 5, 6, 3]
      // so we should insert whatever it is after max, independent to min
      if (insertVal >= maxNode.val || insertVal <= minNode.val) {
         Node maxNext = maxNode.next;
         Node n = new Node(insertVal, maxNext);
         maxNode.next = n;
         return head;
      }

      cur = head;
      Node next = head.next;
      while (!(cur.val <= insertVal && next.val >= insertVal)) {
         cur = cur.next;
         next = next.next;
      }
      // System.out.print("cur: " + cur.val + ", next: " + next.val);
      Node n = new Node(insertVal, next);
      cur.next = n;
      return head;
   }

}
class Node {
   public int val;
   public Node next;

   public Node() {}

   public Node(int _val) {
      val = _val;
   }

   public Node(int _val, Node _next) {
      val = _val;
      next = _next;
   }
};

