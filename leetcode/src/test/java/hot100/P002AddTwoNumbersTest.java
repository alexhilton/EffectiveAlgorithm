package hot100;

import linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static hot100.P002AddTwoNumbers.iterateList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P002AddTwoNumbersTest {
    @Test
    public void testAddTwoNumbers() {
        BiFunction<int[], int[], int[]> action = (l1, l2) -> ListNode.toArray(iterateList(ListNode.fromArray(l1), ListNode.fromArray(l2)));

        assertArrayEquals(new int[] {0}, action.apply(new int[] {0}, new int[] {0}));
        assertArrayEquals(new int[] {7, 0, 8}, action.apply(new int[] {2, 4, 3}, new int[] {5, 6, 4}));
        assertArrayEquals(new int[] {8, 9, 9, 9, 0, 0, 0, 1}, action.apply(new int[] {9, 9, 9, 9, 9, 9, 9}, new int[] {9, 9, 9, 9}));
    }
}
