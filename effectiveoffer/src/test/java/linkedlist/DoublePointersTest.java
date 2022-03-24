package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DoublePointersTest {
    @Test
    public void testDelete() {
        BiFunction<int[], Integer, int[]> action = (nums, k) -> {
            ListNode head = ListNode.fromArray(nums);
            ListNode result = DoublePointers.deleteRearKth(head, k);
            return ListNode.toArray(result);
        };

        assertArrayEquals(new int[] {}, action.apply(new int[] {}, 0));
        assertArrayEquals(new int[] {}, action.apply(new int[] {1}, 1));
        assertArrayEquals(new int[] {1}, action.apply(new int[] {1, 2}, 1));
        assertArrayEquals(new int[] {2}, action.apply(new int[] {1, 2}, 2));

        assertArrayEquals(new int[] {1, 2, 3, 4, 6}, action.apply(new int[] {1, 2, 3, 4, 5, 6}, 2));
    }
}
