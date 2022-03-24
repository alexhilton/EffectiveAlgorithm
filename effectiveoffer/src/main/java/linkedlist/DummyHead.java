package linkedlist;

// Show the tricks of dummy head.
public class DummyHead {
    public static ListNode normalAppend(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    // Add new node to a list with the trick of dummy head.
    // Which can simplify the code pretty much.
    public static ListNode append(ListNode head, int value) {
        ListNode dummy = new ListNode(0, head);

        ListNode current = dummy;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(value);
        return dummy.next;
    }

    public static ListNode normalDelete(ListNode head, int value) {
        if (head == null) {
            return null;
        }

        if (head.val == value) {
            return head.next;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == value) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        return head;
    }

    public static ListNode delete(ListNode head, int value) {
        ListNode dummy = new ListNode(0, head);

        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == value) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        return dummy.next;
    }
}
