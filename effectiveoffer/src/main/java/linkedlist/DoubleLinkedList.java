package linkedlist;

public class DoubleLinkedList {
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
}
