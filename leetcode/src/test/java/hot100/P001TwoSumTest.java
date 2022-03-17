package hot100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P001TwoSumTest {
    @Test
    public void testTwoSum() {
        // The result has no order
        // So, we sort it for the sake of comparing.
        BiFunction<int[], Integer, int[]> action = (nums, target) -> {
            int[] result = P001TwoSum.binaryMap(nums, target);
            Arrays.sort(result);
            return result;
        };

        assertArrayEquals(new int[] {0, 1}, action.apply(new int[] {3, 3}, 6));
        assertArrayEquals(new int[] {1, 2}, action.apply(new int[] {3, 2, 4}, 6));
        assertArrayEquals(new int[] {0, 1}, action.apply(new int[] {2, 7, 11, 15}, 9));
    }
}
