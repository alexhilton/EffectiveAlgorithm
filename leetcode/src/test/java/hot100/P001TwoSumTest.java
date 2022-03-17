package hot100;

import org.junit.jupiter.api.Test;

import static hot100.P001TwoSum.bruteForce;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P001TwoSumTest {
    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] {0, 1}, bruteForce(new int[] {3, 3}, 6));
        assertArrayEquals(new int[] {1, 2}, bruteForce(new int[] {3, 2, 4}, 6));
        assertArrayEquals(new int[] {0, 1}, bruteForce(new int[] {2, 7, 11, 15}, 9));
    }
}
