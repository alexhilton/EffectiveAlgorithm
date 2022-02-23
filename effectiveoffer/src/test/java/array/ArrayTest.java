package array;

import org.junit.jupiter.api.Test;

import static array.ArrayQuestions.twoSum;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayTest {
    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] {0, 1}, twoSum(new int[] {1, 2}, 3));
        assertArrayEquals(new int[] {1, 3}, twoSum(new int[] {1, 2, 4, 6, 10}, 8));
    }
}
