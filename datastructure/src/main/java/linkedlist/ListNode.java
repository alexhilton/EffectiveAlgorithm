package linkedlist;

import java.util.ArrayList;

// singly-linked list
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // For testing purpose
    public static ListNode tail(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        return curr;
    }

    // For testing purpose
    public static boolean isCircle(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode curr = head;
        while (curr.next != null && curr.next != head) {
            curr = curr.next;
        }

        return curr.next != null;
    }

    // For testing purpose
    public static ListNode forgeCircle(ListNode head) {
        ListNode tail = tail(head);
        if (tail != null) {
            tail.next = head;
        }

        return head;
    }

    // for testing purpose.
    public static ListNode breakCircle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    // For testing purpose
    public static int[] toArray(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode current = head; current != null; current = current.next) {
            list.add(current.val);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // For testing purpose.
    public static ListNode fromArray(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int n : nums) {
            current.next = new ListNode(n);
            current = current.next;
        }

        return dummy.next;
    }
}
