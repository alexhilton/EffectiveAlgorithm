package linkedlist;

public class ReverseList {
    // Question 24
    public static ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = reversedHead;
            reversedHead = current;
            current = next;
        }

        return reversedHead;
    }
}
