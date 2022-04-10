package hash;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final ListNode head;
    private final ListNode tail;
    private final Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.val = value;
            moveToTail(node);
        } else {
            if (cache.size() == capacity) {
                ListNode toDelete = head.next;
                deleteNode(toDelete);
                cache.remove(toDelete.key);
            }

            ListNode node = new ListNode(key, value);
            appendNode(node);
            cache.put(key, node);
        }
    }

    private void moveToTail(ListNode node) {
        // Delete node
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // append at tail
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void deleteNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }

    private void appendNode(ListNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private static class ListNode {
        private int val;
        private final int key;
        private ListNode next;
        private ListNode prev;

        private ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}
