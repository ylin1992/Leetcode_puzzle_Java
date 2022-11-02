package LinkedList;

public class _086_PartitionList {
   public ListNode partition(ListNode head, int x) {
      ListNode less = new ListNode(-1);
      ListNode greater = new ListNode(-1);

      ListNode lessRunning = less;
      ListNode greaterRunning = greater;
      ListNode running = head;
      while (running != null) {
         if (running.val < x) {
            lessRunning.next = new ListNode(running.val);
            lessRunning = lessRunning.next;
         } else {
            greaterRunning.next = new ListNode(running.val);
            greaterRunning = greaterRunning.next;
         }
         running = running.next;
      }
      if (less.next == null) return greater.next;
      lessRunning.next = greater.next;
      return less.next;
   }
}
