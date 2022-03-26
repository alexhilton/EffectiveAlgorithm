package hot100;

import linkedlist.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static hot100.P206ReverseList.reverseList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P206ReverseListTest {
    Function<int[], int[]> action;

    @BeforeEach
    public void setup() {
        action = list -> ListNode.toArray(reverseList(ListNode.fromArray(list)));
    }

    @Test
    public void testReverseList() {
        assertArrayEquals(new int[] {}, action.apply(new int[] {}));

        assertArrayEquals(new int[] {1}, action.apply(new int[] {1}));
        assertArrayEquals(new int[] {2, 1}, action.apply(new int[] {1, 2}));
        assertArrayEquals(new int[] {3, 2, 1}, action.apply(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, action.apply(new int[] {1, 2, 3, 4, 5}));
    }
}
