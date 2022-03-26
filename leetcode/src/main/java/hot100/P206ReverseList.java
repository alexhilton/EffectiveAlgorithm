package hot100;

import linkedlist.ListNode;

public class P206ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy.next;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = tmp;
        }
        if (head != null) {
            head.next = null;
        }
        return dummy.next;
    }
}
