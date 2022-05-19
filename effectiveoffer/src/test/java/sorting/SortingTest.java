package sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingTest {
    private Function<int[], int[]> action;

    @BeforeEach
    public void setup() {
        action = Sorting::mergeSort;
    }

    @Test
    public void testSort() {
        assertArrayEquals(new int[] {1, 2}, action.apply(new int[] {2, 1}));
        assertArrayEquals(new int[] {1, 1}, action.apply(new int[] {1, 1}));
    }
}
