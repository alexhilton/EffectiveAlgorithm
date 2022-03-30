package linkedlist;

public class ReverseList {
    // Question 27
    public static boolean isPalindromeList(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow starts from [0], step is 1, and stops at [n/2 - 1]
        // fast starts from [1], step is 2, and stops at n-1, if n is even, or n - 2 if it is odd
        ListNode secondHalf = slow.next;
        if (fast.next != null) {
            // n is odd, skip central item
            secondHalf = slow.next.next;
        }
        // break the list into two parts.
        slow.next = null;
        return listsEqual(head, reverseList(secondHalf));
    }

    private static boolean listsEqual(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }

    // Question 26
    public static ListNode reorderList(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        ListNode temp = slow.next;
        slow.next = null;
        crossLink(head, reverseList(temp), dummy);
        return dummy.next;
    }

    private static void crossLink(ListNode node1, ListNode node2, ListNode head) {
        ListNode prev = head;
        while (node1 != null && node2 != null) {
            ListNode temp = node1.next;
            prev.next = node1;
            node1.next = node2;
            prev = node2;

            node1 = temp;
            node2 = node2.next;
        }

        // first half is always longer.
        if (node1 != null) {
            prev.next = node1;
        }
    }

    // Question 25
    public static ListNode addTwoNumbersAgain(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        return addReversedAgain(head1, head2);
    }

    // When construct the result list
    // we can prepend the node, which can save a reversion.
    private static ListNode addReversedAgain(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;

            // Prepend the node, so we do not have to reverse again.
            ListNode node = new ListNode(sum, dummy.next);
            dummy.next = node;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry, dummy.next);
            dummy.next = node;
        }

        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode reversedSum = addReversed(head1, head2);
        return reverseList(reversedSum);
    }

    private static ListNode addReversed(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode node = new ListNode(sum);

            sumNode.next = node;
            sumNode = sumNode.next;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }

        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }

        return dummy.next;
    }

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
