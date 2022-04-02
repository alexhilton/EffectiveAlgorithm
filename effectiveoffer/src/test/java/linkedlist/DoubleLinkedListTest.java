package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoubleLinkedListTest {
    @Test
    public void testInsertInCircle() {
        BiFunction<int[], Integer, int[]> action = (a, v) -> {
            ListNode head = ListNode.fromArray(a);
            ListNode result = DoubleLinkedList.insertInCircle(ListNode.forgeCircle(head), v);
            assertTrue(ListNode.isCircle(result));
            return ListNode.toArray(ListNode.breakCircle(result));
        };

        assertArrayEquals(new int[] {1}, action.apply(new int[] {}, 1));
        assertArrayEquals(new int[] {1, 2}, action.apply(new int[] {1}, 2));
        assertArrayEquals(new int[] {1, 2, 3}, action.apply(new int[] {1, 3}, 2));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 7}, action.apply(new int[] {1, 3, 4, 5, 7}, 2));
        assertArrayEquals(new int[] {1, 3, 4, 5, 7}, action.apply(new int[] {1, 3, 4, 5}, 7));
    }

    @Test
    public void testAppend() {
        BiFunction<int[], Integer, int[]> action = (a, v) -> Node.toArray(DoubleLinkedList.append(Node.fromArray(a), v));

        assertArrayEquals(new int[] {1}, action.apply(new int[] {}, 1));
        assertArrayEquals(new int[] {1, 2}, action.apply(new int[] {1}, 2));
        assertArrayEquals(new int[] {1, 2, 3}, action.apply(new int[] {1, 2}, 3));
    }
}
