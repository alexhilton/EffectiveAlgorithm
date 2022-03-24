package linkedlist;

public class DoublePointers {
    // Question 21
    // head has N nodes.
    // 1 <= k <= N
    public static ListNode deleteRearKth(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right = dummy.next;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
