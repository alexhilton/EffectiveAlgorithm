package linkedlist;

public class DoublePointers {
    // Question 21
    public static ListNode deleteRearKth(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        ListNode front = head, back = dummy;
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
