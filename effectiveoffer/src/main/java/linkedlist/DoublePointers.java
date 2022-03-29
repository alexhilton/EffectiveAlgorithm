package linkedlist;

public class DoublePointers {
    // Question 23
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final int count1 = countList(headA);
        final int count2 = countList(headB);
        int delta = Math.abs(count1 - count2);
        ListNode longer = count1 > count2 ? headA : headB;
        ListNode shorter = count1 < count1 ? headA : headB;

        ListNode right = longer;
        for (int i = 0; i < delta; i++) {
            right = right.next;
        }

        ListNode left = shorter;
        while (left != right) {
            left = left.next;
            right = right.next;
        }

        return left;
    }

    private int countList(ListNode head) {
        int count = 0;
        for (ListNode current = head; current != null; current = current.next) {
            count++;
        }

        return count;
    }

    // Question 22
    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }

        return node;
    }

    public static ListNode detectCycleWithCount(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        int loopCount = 1;
        for (ListNode n = inLoop; n.next != inLoop; n = n.next) {
            loopCount++;
        }

        ListNode fast = head;
        for (int i = 0; i < loopCount; i++) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    private static ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // Will it be a valid cycle, if there is only one node, to which its next points.
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return null;
    }

    // Question 21
    // head has N nodes.
    // 1 <= k <= N
    public static ListNode deleteRearKth(ListNode head, int k) {
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
