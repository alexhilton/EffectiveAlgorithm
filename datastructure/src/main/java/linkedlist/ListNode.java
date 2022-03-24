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
    public int[] toArray() {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode current = this; current != null; current = current.next) {
            list.add(current.val);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static ListNode fromArray(int[] nums) {
        ListNode head = null;
        ListNode current = null;
        for (int n : nums) {
            ListNode node = new ListNode(n);
            if (head == null) {
                head = node;
            }
            if (current != null) {
                current.next = node;
            }
            current = node;
        }

        return head;
    }
}
