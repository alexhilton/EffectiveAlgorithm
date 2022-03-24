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

    // For testing purpose.
    public static ListNode fromArray(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int n : nums) {
            current.next = new ListNode(n);
            current = current.next;
        }

        return dummy.next;
    }
}
