package LinkedList;

public class _002_AddTwoNumbers {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = helper(l1, l2);
      carry(head);
      return head;
   }

   // recursively call carry
   // [18, 18, 18, 18, 18] -> [8,9,9,0,0,1]
   private void carry(ListNode head) {
      if (head.next == null) {
         if (head.val >= 10) {
            head.next = new ListNode(head.val / 10);
            head.val %= 10;
         }
         return;
      }

      if (head.val >= 10) {
         head.next.val += head.val / 10;
         head.val %= 10;
      }
      carry(head.next);
   }

   // if l1 == null and l2 == null -> both lists reach the end (the case that they are of the same length)
   // if l1 == null and l2 != null
   //    new a node for l2, and recursively call l2.next
   // same as l1 != null and l2 == null
   // if l1 != null and l2 != null -> they are not reaching the end
   //    new a node for l1 + l2, and recursively call (l1.next, l2.next)
   // if the returned node is null, it means they both reach the end, so the cur node can be returned (it is the end)
   // if not, cur.next = returned node
   // so far, the returned node is a list whose nodes are not digit
   // i.e.,
   // [9,9,9,9]
   // [9,9,9]
   // -> [18,18,18,18]
   // we need to deal with the carry with O(n) time, see carry()
   private ListNode helper(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
         return null;
      }
      ListNode cur = new ListNode(-1);
      ListNode returned = new ListNode(-1);
      if (l1 == null && l2 != null) {
         cur = new ListNode(l2.val);
         returned = helper(l1, l2.next);
      }
      if (l2 == null && l1 != null) {
         cur = new ListNode(l1.val);
         returned = helper(l1.next, l2);
      }
      if (l1 != null && l2 != null) {
         cur = new ListNode(l1.val + l2.val);
         returned = helper(l1.next, l2.next);
      }

      if (returned == null)
         return cur;

      cur.next = returned;
      return cur;

   }


   // the below helper method is used when nodes are stored in non-reversed order
   private ListNode helper2(ListNode l1, ListNode l2) {
      if (l1.next == null && l2.next == null) {
         return new ListNode(l1.val + l2.val);
      }

      if (l1.next == null && l2.next != null) {
         return helper2(l1, l2.next);
      }

      if (l1.next != null && l2.next == null) {
         return helper2(l1.next, l2);
      }

      ListNode returnedNode = helper(l1.next, l2.next);
      ListNode currNode = new ListNode(l1.val + l2.val + returnedNode.val / 10);
      returnedNode.val %= 10;
      currNode.next = returnedNode;
      return currNode;
   }
}
