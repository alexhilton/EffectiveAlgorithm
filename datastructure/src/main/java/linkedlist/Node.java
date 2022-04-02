package linkedlist;

import java.util.ArrayList;

// simple double linked list
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    // for testing purpose
    public static int[] toArray(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Node current = head; current != null; current = current.next) {
            list.add(current.val);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // For testing purpose
    // Dummy node cannot be applied to double linked list
    // will become a head in the list.
    public static Node fromArray(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        Node head = new Node(nums[0]);
        Node curr = head;
        for (int i = 1; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            curr.next = node;
            node.prev = curr;
            curr = curr.next;
        }

        return head;
    }
}
