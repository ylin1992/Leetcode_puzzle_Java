package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _023_MergeKSortedListsConciseVersion {
   public ListNode mergeKLists(ListNode[] lists) {
      if (lists.length == 0) return null;

      PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
         @Override
         public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
         }
      });

      for (int i = 0; i < lists.length; i++) {
         if (lists[i] != null) {
            pq.add(lists[i]);
         }
      }

      if (pq.isEmpty()) return null;
      ListNode root = new ListNode(-1);
      ListNode walking = root;
      while (!pq.isEmpty()) {
         ListNode cur = pq.poll();
         if (cur.next != null) {
            walking.next = cur;
            walking = walking.next;
            pq.offer(cur.next);
         } else {
            walking.next = cur;
            walking = walking.next;
         }

      }
      return root.next;
   }
}
