package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseListTest {
    @Test
    public void testAddTwoNumbers() {
        BiFunction<int[], int[], int[]> action = (a, b) -> {
            ListNode result = ReverseList.addTwoNumbers(ListNode.fromArray(a), ListNode.fromArray(b));
            return ListNode.toArray(result);
        };

        assertArrayEquals(new int[] {}, action.apply(new int[] {}, new int[] {}));
        assertArrayEquals(new int[] {1}, action.apply(new int[] {1}, new int[] {0}));
        assertArrayEquals(new int[] {1}, action.apply(new int[] {0}, new int[] {1}));

        assertArrayEquals(new int[] {2}, action.apply(new int[] {1}, new int[] {1}));
        assertArrayEquals(new int[] {1, 0}, action.apply(new int[] {2}, new int[] {8}));

        assertArrayEquals(new int[] {5, 7, 9}, action.apply(new int[] {1, 2, 3}, new int[] {4, 5, 6}));
        assertArrayEquals(new int[] {1, 2, 4, 0, 0}, action.apply(new int[] {1, 2, 3, 5, 4}, new int[] {4, 6}));

        assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0}, action.apply(new int[] {9, 9, 9, 9, 9}, new int[] {1}));
    }
}
