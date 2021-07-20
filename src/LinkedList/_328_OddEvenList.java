package LinkedList;

public class _328_OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode(-1);
        ListNode oddPtr = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode evenPtr = evenHead;
        ListNode ptr = head;
        int flag = 0;
        while (ptr != null) {
            if (flag == 0) {
                oddPtr.next = ptr;
                oddPtr = oddPtr.next;
                flag++;
            } else if (flag == 1) {
                evenPtr.next = ptr;
                evenPtr = evenPtr.next;
                flag = 0;
            }
            ptr = ptr.next;
        }
        evenPtr.next = null;
        oddPtr.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        _328_OddEvenList oel = new _328_OddEvenList();
        ListNode head = new ListNode(1);
        ListNode ptr = head;
        for (int i = 2; i < 7; i++) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }
        ListNode ans = oel.oddEvenList(head);
        System.out.println();
    }
}
