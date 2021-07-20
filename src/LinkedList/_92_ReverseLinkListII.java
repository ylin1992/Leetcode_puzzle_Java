package LinkedList;

public class _92_ReverseLinkListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        ListNode returnNode = dummy;
        dummy.next = head;

        ListNode front = dummy;
        ListNode back = dummy;
        int i = 1;
        while (i <= right) {
            if (i == left) {
                front = dummy;
            }
            if (i == right) {
                back = dummy.next;
            }
            dummy = dummy.next;
            i++;
        }
        ListNode tail = back.next;
        ListNode newHead = reverse(front.next, back);
        front.next = newHead;
        while (front.next != null) {
            front = front.next;
        }
        front.next = tail;
        return returnNode.next;
    }
    private ListNode reverse(ListNode start, ListNode end) {
        if (start == end) {
            start.next = null;
            return start;
        }
        ListNode next = start.next;
        ListNode newHead = reverse(start.next, end);
        next.next = start;
        start.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        ListNode ptr = input;
        for (int i = 2; i < 6; i++) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }
        _92_ReverseLinkListII rllII = new _92_ReverseLinkListII();
        ListNode ans = rllII.reverseBetween(input, 2, 4);
        System.out.println();
    }
}
