package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseListTest {
    @Test
    public void testFindMedianInList() {
        Function<int[], Double> action = a -> ReverseList.findMedianInList(ListNode.fromArray(a));

        assertEquals(0, action.apply(new int[] {0}));
        assertEquals(1, action.apply(new int[] {1}));
        assertEquals(1.5, action.apply(new int[] {1, 2}));
        assertEquals(2, action.apply(new int[] {1, 2, 3}));

        assertEquals(2.5, action.apply(new int[] {1, 2, 3, 4}));
        assertEquals(3, action.apply(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void testCheckPalindromeList() {
        Function<int[], Boolean> action = a -> ReverseList.isPalindromeList(ListNode.fromArray(a));

        assertTrue(action.apply(new int[] {}));
        assertTrue(action.apply(new int[] {1}));
        assertTrue(action.apply(new int[] {1, 1}));
        assertTrue(action.apply(new int[] {1, 2, 1}));
        assertTrue(action.apply(new int[] {1, 2, 3, 3, 2, 1}));
        assertTrue(action.apply(new int[] {1, 2, 3, 4, 3, 2, 1}));

        assertFalse(action.apply(new int[] {1, 2}));
        assertFalse(action.apply(new int[] {1, 2, 3}));
        assertFalse(action.apply(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void testReorderList() {
        Function<int[], int[]> action = a -> {
            ListNode result = ReverseList.reorderList(ListNode.fromArray(a));
            return ListNode.toArray(result);
        };

        assertArrayEquals(new int[] {}, action.apply(new int[] {}));
        assertArrayEquals(new int[] {1}, action.apply(new int[] {1}));
        assertArrayEquals(new int[] {1, 2}, action.apply(new int[] {1, 2}));
        assertArrayEquals(new int[] {1, 3, 2}, action.apply(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {1, 5, 2, 4, 3}, action.apply(new int[] {1, 2, 3, 4, 5}));
        assertArrayEquals(new int[] {1, 6, 2, 5, 3, 4}, action.apply(new int[] {1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testAddTwoNumbers() {
        BiFunction<int[], int[], int[]> action = (a, b) -> {
            ListNode result = ReverseList.addTwoNumbersAgain(ListNode.fromArray(a), ListNode.fromArray(b));
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
