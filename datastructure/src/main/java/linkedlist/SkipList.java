package linkedlist;

import java.util.Arrays;
import java.util.Random;

public class SkipList {
    private static final int INF = 1000;
    private static final int MAX_LEVEL = 32;
    private static final double P_FACTOR = 0.25;
    private final Node head;
    private int level;
    private final Random random;

    public SkipList() {
        head = new Node(-INF, MAX_LEVEL);
        level = 0;
        random = new Random();
    }

    private int randomLevel() {
        int lv = 1;
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }

    public boolean search(int target) {
        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].value < target) {
                curr = curr.next[i];
            }
        }

        if (curr.next[0] != null && curr.next[0].value == target) {
            return true;
        }

        return false;
    }

    public void insert(int value) {
        Node[] updates = new Node[MAX_LEVEL];
        Arrays.fill(updates, head);

        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].value < value) {
                curr = curr.next[i];
            }
            updates[i] = curr;
        }

        final int nodeLevel = randomLevel();
        level = Math.max(level, nodeLevel);
        Node newNode = new Node(value, nodeLevel);

        for (int i = 0; i < nodeLevel; i++) {
            newNode.next[i] = updates[i].next[i];
            updates[i].next[i] = newNode;
        }
    }

    public boolean delete(int target) {
        Node[] updates = new Node[level];

        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].value < target) {
                curr = curr.next[i];
            }
            updates[i] = curr;
        }
        curr = curr.next[0];
        if (curr == null || curr.value != target) {
            // target not exist
            return false;
        }

        for (int i = 0; i < level; i++) {
            if (updates[i].next[i] != curr) {
                break;
            }
            updates[i].next[i] = curr.next[i];
        }
        while (level > 1 && head.next[level - 1] == null) {
            level--;
        }
        return true;
    }

    public void dump() {
        for (int i = level - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("L #%3d [ ", i));
            Node curr = head;
            Node bottomCurr = head;
            while (bottomCurr != null) {
                if (curr != null && curr.value == bottomCurr.value) {
                    if (curr == head) {
                        sb.append("-Inf -> ");
                    } else {
                        sb.append(String.format("%5d -> ", curr.value));
                    }
                    curr = curr.next[i];
                } else {
                    sb.append("         ");
                }
                bottomCurr = bottomCurr.next[0];
            }
            sb.append(" null ]");
            System.out.println(sb);
        }
    }

    private static final class Node {
        final int value;
        final Node[] next;

        Node(int value, int level) {
            this.value = value;
            next = new Node[level];
        }
    }

    public static void main(String[] args) {
        SkipList sl = new SkipList();
        int n = 100;
        Random rand = new Random();
        int[] values = new int[7];
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(n);
            sl.insert(values[i]);
        }
        System.out.println("After insertion.");
        sl.dump();
        for (int i = 0; i < 3; i++) {
            int target = values[i * 2];
            System.out.println("Searching (true) " + target + " -> " + sl.search(target));
        }
        System.out.println("Delete some.");
        for (int i = 0; i < 3; i++) {
            int target = values[i * 2];
            System.out.println("Deleting (true) " + target + " -> " + sl.delete(target));
        }
        int target = rand.nextInt(n);
        System.out.println("Deleting " + target + " -> " + sl.delete(target));
        target = rand.nextInt(n);
        System.out.println("Deleting " + target + " -> " + sl.delete(target));
        sl.dump();
        System.out.println("Insert some more.");
        for (int i = 0; i < 4; i++) {
            sl.insert(rand.nextInt(n));
        }
        sl.dump();
    }
}
