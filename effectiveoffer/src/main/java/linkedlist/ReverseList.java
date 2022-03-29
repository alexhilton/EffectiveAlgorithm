package linkedlist;

public class ReverseList {
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
