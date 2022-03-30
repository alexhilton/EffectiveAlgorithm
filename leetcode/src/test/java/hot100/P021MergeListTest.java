package hot100;

import linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P021MergeListTest {
    @Test
    public void testMergeList() {
        BiFunction<int[], int[], int[]> action = (a, b) -> {
            ListNode result = P021MergeList.mergeTwoLists(ListNode.fromArray(a), ListNode.fromArray(b));
            return ListNode.toArray(result);
        };

        assertArrayEquals(new int[] {}, action.apply(new int[] {}, new int[] {}));
        assertArrayEquals(new int[] {1}, action.apply(new int[] {}, new int[] {1}));
        assertArrayEquals(new int[] {1}, action.apply(new int[] {1}, new int[] {}));

        assertArrayEquals(new int[] {1, 1}, action.apply(new int[] {1}, new int[] {1}));
        assertArrayEquals(new int[] {1, 1, 2}, action.apply(new int[] {1}, new int[] {1, 2}));
        assertArrayEquals(new int[] {1, 1, 2}, action.apply(new int[] {1, 2}, new int[] {1}));

        assertArrayEquals(new int[] {1, 1, 2, 2}, action.apply(new int[] {1, 2}, new int[] {1, 2}));

        assertArrayEquals(new int[] {1, 1, 2, 2, 4}, action.apply(new int[] {1, 2}, new int[] {1, 2, 4}));

        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, action.apply(new int[] {1, 3, 5}, new int[] {2, 4, 6}));
    }
}
