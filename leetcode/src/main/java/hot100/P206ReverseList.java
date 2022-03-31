package hot100;

import linkedlist.ListNode;

public class P206ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = tmp;
        }
        return dummy.next;
    }

    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = recursion(head.next);

        // new head is the reversed list [head.next to the end], but that is the head
        // we need to append old head to the tail of the reversed list.
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;

        return newHead;
    }

    public static ListNode reverseWithRecursion(ListNode head) {
        return recursivelyReverse(head, null);
    }

    private static ListNode recursivelyReverse(ListNode current, ListNode prev) {
        if (current == null) {
            return prev;
        }
        ListNode next = current.next;
        current.next = prev;
        return recursivelyReverse(next, current);
    }
}
