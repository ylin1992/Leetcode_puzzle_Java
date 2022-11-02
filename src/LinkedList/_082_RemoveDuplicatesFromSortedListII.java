package LinkedList;

public class _082_RemoveDuplicatesFromSortedListII {
   public ListNode deleteDuplicates(ListNode head) {
      ListNode dummy = new ListNode(-101, head);
      ListNode cur = dummy;
      ListNode prev = cur;
      while (cur != null && cur.next != null) {
         if (cur.val != cur.next.val) {
            prev = cur;
            cur = cur.next;
         } else {
            ListNode running = cur;
            while (running.next != null && running.val == running.next.val)
               running = running.next;
            prev.next = running.next;
            cur = prev.next;
         }
      }
      return dummy.next;
   }
}
