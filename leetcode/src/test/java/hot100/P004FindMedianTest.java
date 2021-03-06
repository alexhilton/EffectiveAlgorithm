package hot100;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P004FindMedianTest {
    @Test
    public void testMedian() {
        BiFunction<int[], int[], Double> action = P004FindMedian::doublePointer;

        assertEquals(0, action.apply(new int[] {0}, new int[] {0}));
        assertEquals(1, action.apply(new int[] {1}, new int[] {}));
        assertEquals(1, action.apply(new int[] {}, new int[] {1}));
        assertEquals(2.5, action.apply(new int[] {}, new int[] {2, 3}));
        assertEquals(2.5, action.apply(new int[] {2, 3}, new int[] {}));
        assertEquals(2, action.apply(new int[] {}, new int[] {1, 2, 3}));
        assertEquals(2, action.apply(new int[] {1, 2, 3}, new int[] {}));

        assertEquals(2, action.apply(new int[] {1, 3}, new int[] {2}));
        assertEquals(2, action.apply(new int[] {2}, new int[] {1, 3}));
        assertEquals(5, action.apply(new int[] {1, 18}, new int[] {5}));
        assertEquals(5, action.apply(new int[] {5}, new int[] {1, 18}));
        assertEquals(2.5, action.apply(new int[] {1, 2}, new int[] {3, 4}));
        assertEquals(2.5, action.apply(new int[] {3, 4}, new int[] {1, 2}));

        assertEquals(2.5, action.apply(new int[] {1, 3}, new int[] {2, 4}));
        assertEquals(5, action.apply(new int[] {1, 3, 5, 7}, new int[] {6}));
        assertEquals(3.5, action.apply(new int[] {1, 3, 5, 7}, new int[] {2, 4}));
        assertEquals(3.5, action.apply(new int[] {2, 4}, new int[] {1, 3, 5, 7}));
        assertEquals(4.5, action.apply(new int[] {1, 3, 5, 7}, new int[] {4, 6}));
        assertEquals(4.5, action.apply(new int[] {4, 6}, new int[] {1, 3, 5, 7}));

        assertEquals(1, action.apply(new int[] {1, 2}, new int[] {1, 1}));
        assertEquals(1, action.apply(new int[] {1, 1}, new int[] {1, 2}));

        assertEquals(3, action.apply(new int[] {2, 2, 4, 4}, new int[] {2, 2, 4, 4}));

        assertEquals(2.5, action.apply(new int[] {1, 2, 3}, new int[] {4}));
        assertEquals(2.5, action.apply(new int[] {4}, new int[] {1, 2, 3}));
    }
}
