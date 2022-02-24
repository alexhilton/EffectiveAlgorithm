package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static array.ArrayQuestions.threeSum;
import static array.ArrayQuestions.twoSum;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ArrayTest {
    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] {0, 1}, twoSum(new int[] {1, 2}, 3));
        assertArrayEquals(new int[] {1, 3}, twoSum(new int[] {1, 2, 4, 6, 10}, 8));
    }

    @Test
    public void testThreeSum() {
        // Pay attention to the order, numbers are sorted ascending.
        // And we use double pointer from both ends, so the tuple containing
        // Smaller item comes before the bigger one.
        assertIterableEquals(Arrays.asList(Arrays.asList(0, 0, 0)), threeSum(new int[] {0, 0, 0}));
        assertIterableEquals(
                Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(0, 0, 0)),
                threeSum(new int[] {0, -1, 1, 3, 0, 0})
        );
        assertIterableEquals(Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)),
                threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
