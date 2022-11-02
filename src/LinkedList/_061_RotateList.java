package LinkedList;

public class _061_RotateList {
   public ListNode rotateRight(ListNode head, int k) {
      ListNode running = head;
      int length = 0;
      while (running != null) {
         running = running.next;
         length++;
      }
      if (k == 0) return head;
      if (length <= 1) return head;
      k = k % length;
      if (k == 0) return head;
      int splitting = length - k;
      // [1 2 3 4 5]
      //       ^^^
      //        splitting
      running = head;
      ListNode firstEnd = new ListNode(-1);
      while (splitting > 0) {
         if (splitting == 1) {
            firstEnd = running;
         }
         splitting--;
         running = running.next;
      }
      ListNode listTwo = running;
      while(running.next != null) {
         running = running.next;
      }
      running.next = head;
      firstEnd.next = null;
      // System.out.println(firstEnd.val);
      // System.out.println(firstEnd.next);
      return listTwo;
   }

}
