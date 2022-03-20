package hot100;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P004FindMedianTest {
    @Test
    public void testMedian() {
        BiFunction<int[], int[], Double> action = P004FindMedian::bruteForce;

        assertEquals(0, action.apply(new int[] {0}, new int[] {0}));
        assertEquals(2, action.apply(new int[] {1, 3}, new int[] {2}));
        assertEquals(2.5, action.apply(new int[] {1, 2}, new int[] {3, 4}));
    }
}
