package linkedlist;

public class DoubleLinkedList {
    // Question 29
    // Handling circle linked list.
    // The list must be a circle, so if there is only one node, its next should point to itself.
    public static ListNode insertInCircle(ListNode head, int insertVal) {
        ListNode node = new ListNode(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            // The list must be a circle, so if there is only one node,
            // its next points to itself, which is the condition of single node.
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    private static void insertCore(ListNode head, ListNode node) {
        ListNode cur = head;
        ListNode next = head.next;
        ListNode biggest = head;
        // Biggest is the tail, actually.
        // The terminal of circle linked list is when reach the head again.
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }

        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }

    // Question 28
    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    private Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            // DFS, so keep next for list iteration
            Node next = node.next;
            if (node.child != null) {
                // DFS
                Node child = node.child;
                Node childTail = flattenGetTail(child);

                // Break the sub list
                node.child = null;

                // connect the head of child list as the next
                node.next = child;
                child.prev = node;

                // connect the tail of the child as the prev of the next
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }

                tail = childTail;
            } else {
                tail = node;
            }

            node = next;
        }
        return tail;
    }

    // Exercises for double linked list
    public static Node append(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node node = new Node(val);
        curr.next = node;
        node.prev = curr;
        return head;
    }

    public static Node insertAt(Node head, int val, int index) {
        Node node = new Node(val);
        if (head == null) {
            return node;
        }
        if (index == 0) {
            // Head will be refreshed, so must deal with it specially.
            node.next = head;
            head.prev = node;
            return node;
        }
        Node curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }
        // Insert node between curr and its next.
        Node next = curr.next;
        node.next = next;
        node.prev = curr;
        curr.next = node;
        if (next != null) {
            next.prev = node;
        }
        return head;
    }
}
