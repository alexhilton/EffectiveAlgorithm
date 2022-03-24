package hot100;

import linkedlist.ListNode;

// https://leetcode-cn.com/problems/add-two-numbers/
public class P002AddTwoNumbers {
    public static ListNode iterateList(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pr = result;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            if (result == null) {
                result = node;
            }
            if (pr != null) {
                pr.next = node;
            }
            pr = node;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            pr.next = node;
        }

        return result;
    }
}
