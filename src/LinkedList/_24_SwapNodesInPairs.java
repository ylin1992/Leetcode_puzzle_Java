package LinedList;

public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode l1 = dummy;
        ListNode l2 = dummy.next; // head
        /**
         * l2 == null ==> 1 -> 2
         * l2.next == null ==> 1 -> 2 -> 3
         **/
        while (l2 != null && l2.next != null) {
            ListNode nextHead = l2.next.next; // l2.next.next is always valid, since l2.next can never be null
            l1.next = l2.next;
            l1.next.next = l2;
            l2.next = nextHead;
            l1 = l2;
            l2 = nextHead;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        _24_SwapNodesInPairs swip = new _24_SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = swip.swapPairs(head);
        System.out.println();
    }
}
