package hot100;

import linkedlist.ListNode;

public class P021MergeList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null || list2 != null) {
            int v1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int v2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            ListNode node = new ListNode(Math.min(v1, v2));
            current.next = node;
            current = current.next;
            if (list2 == null || v1 <= v2) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        return dummy.next;
    }
}
