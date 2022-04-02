package linkedlist;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
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

    @Test
    public void testInsertAt() {
        assertArrayEquals(new int[] {1}, Node.toArray(DoubleLinkedList.insertAt(Node.fromArray(new int[] {}), 1, 0)));
        assertArrayEquals(new int[] {1, 2}, Node.toArray(DoubleLinkedList.insertAt(Node.fromArray(new int[] {1}), 2, 1)));
        assertArrayEquals(new int[] {3, 1}, Node.toArray(DoubleLinkedList.insertAt(Node.fromArray(new int[] {1}), 3, 0)));
        assertArrayEquals(new int[] {1, 2, 3}, Node.toArray(DoubleLinkedList.insertAt(Node.fromArray(new int[] {1, 3}), 2, 1)));
        assertArrayEquals(new int[] {1, 2, 3}, Node.toArray(DoubleLinkedList.insertAt(Node.fromArray(new int[] {2, 3}), 1, 0)));
        assertArrayEquals(new int[] {1, 2, 3}, Node.toArray(DoubleLinkedList.insertAt(Node.fromArray(new int[] {1, 2}), 3, 2)));
    }

    @Test
    public void testDeleteValue() {
        BiFunction<int[], Integer, int[]> action = (a, v) -> Node.toArray(DoubleLinkedList.deleteValue(Node.fromArray(a), v));

        assertArrayEquals(new int[] {}, action.apply(new int[] {}, 2));
        assertArrayEquals(new int[] {}, action.apply(new int[] {1}, 1));

        assertArrayEquals(new int[] {2}, action.apply(new int[] {1, 2}, 1));
        assertArrayEquals(new int[] {1}, action.apply(new int[] {1, 2}, 2));
        assertArrayEquals(new int[] {2, 3}, action.apply(new int[] {1, 2, 3}, 1));
        assertArrayEquals(new int[] {1, 3}, action.apply(new int[] {1, 2, 3}, 2));
        assertArrayEquals(new int[] {1, 2}, action.apply(new int[] {1, 2, 3}, 3));

        assertArrayEquals(new int[] {1, 2, 3}, action.apply(new int[] {1, 2, 3}, 6));
    }
}
