package LinkedList;

import java.util.PriorityQueue;

public class _023_MergeKSortedListBruteForce {
   // Create a root
   // Create an array indicating pointers[]
   // Add all ele in PQ, each ele is represented as an entry pair <ListNode, index> sorted by ListNode.val
   public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNodeIndex> pq = new PriorityQueue<>();
      int[] pointers = new int[lists.length];
      for (int i = 0; i < lists.length; i++) {
         if (lists[i] != null) {
            pq.add(new ListNodeIndex(lists[i], i));
            pointers[i]++;
         }
      }

      if (pq.isEmpty()) return null;
      ListNode root = new ListNode(-1);
      ListNode walking = root;
      while (!pq.isEmpty()) {
         ListNodeIndex cur = pq.poll();
         if (cur.node.next != null) {
            walking.next = cur.node;
            walking = walking.next;
            pq.offer(new ListNodeIndex(cur.node.next, cur.index));
         } else {
            walking.next = cur.node;
            walking = walking.next;
         }

      }
      return root.next;
   }

   class ListNodeIndex implements Comparable<ListNodeIndex> {
      ListNode node;
      int index;
      ListNodeIndex(ListNode node, int index) {
         this.node = node;
         this.index = index;
      }

      @Override
      public int compareTo(ListNodeIndex other) {
         return this.node.val - other.node.val;
      }
   }
}
