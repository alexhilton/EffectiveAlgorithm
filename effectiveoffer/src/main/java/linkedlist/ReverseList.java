package linkedlist;

public class ReverseList {
    // Question 25
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
