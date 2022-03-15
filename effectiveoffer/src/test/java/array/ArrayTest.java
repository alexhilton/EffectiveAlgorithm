package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static array.ArrayQuestions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {
    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] {0, 1}, twosumHash(new int[] {1, 2}, 3));
        assertArrayEquals(new int[] {1, 3}, twosumHash(new int[] {1, 2, 4, 6, 10}, 8));
        assertArrayEquals(new int[] {0, 3}, twosumHash(new int[] {1, 2, 4, 6, 10}, 7));
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

    @Test
    public void testMinSubArray() {
        assertEquals(1, minSubArrayLen(0, new int[] {0}));
        assertEquals(0, minSubArrayLen(1, new int[] {0}));
        assertEquals(2, minSubArrayLen(7, new int[] {5, 1, 4, 3}));
        assertEquals(1, minSubArrayLen(100, new int[] {1, 2, 3, 4, 5, 6, 101}));
    }

    @Test
    public void testSubArrayProduct() {
        assertEquals(1, numSubArrayProductLessThanK(new int[] {1}, 2));
        assertEquals(0, numSubArrayProductLessThanK(new int[] {1}, 1));
        assertEquals(1, numSubArrayProductLessThanK(new int[] {1, 2}, 2));
        assertEquals(3, numSubArrayProductLessThanK(new int[] {1, 2}, 3));
        assertEquals(8, numSubArrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
    }

    @Test
    public void testSubArraySum() {
        assertEquals(1, subArraySum(new int[] {0}, 0));
        assertEquals(0, subArraySum(new int[] {0}, 1));
        assertEquals(2, subArraySum(new int[] {1, 1, 1}, 2));
        assertEquals(1, subArraySum(new int[] {1, 1}, 2));
        assertEquals(2, subArraySum(new int[] {1, 1}, 1));
        assertEquals(6, subArraySum(new int[] {0, 0, 0}, 0));
        assertEquals(0, subArraySum(new int[] {1, 2, 3}, 4));
        assertEquals(1, subArraySum(new int[] {1, 2, 3}, 5));;
        assertEquals(28, subArraySum(new int[] {1, 0, 0, 0, 0, 0, 0, 0, 2}, 0));
    }

    @Test
    public void testFindMaxLength() {
        assertEquals(0, findMaxLength(new int[] {0}));
        assertEquals(0, findMaxLength(new int[] {1}));
        assertEquals(2, findMaxLength(new int[] {0, 1}));
        assertEquals(2, findMaxLength(new int[] {0, 1, 1}));
        assertEquals(2, findMaxLength(new int[] {0, 1, 0}));
        assertEquals(4, findMaxLength(new int[] {0, 1, 1, 0}));
        assertEquals(6, findMaxLength(new int[] {0, 1, 1, 0, 1, 0, 0}));
    }

    @Test
    public void testPivotIndex() {
        assertEquals(-1, pivotIndex(new int[] {}));
        assertEquals(0, pivotIndex(new int[] {0}));
        assertEquals(0, pivotIndex(new int[] {1}));
        assertEquals(1, pivotIndex(new int[] {0, 1, 0}));
        assertEquals(3, pivotIndex(new int[] {1, 7, 3, 6, 2, 9}));
        assertEquals(2, pivotIndex(new int[] {-1, 1, 0, -1, 1, 0, -1, 1}));
        assertEquals(-1, pivotIndex(new int[] {1, 1, -1, -2, -3, 5, 100}));
    }

    @Test
    public void testSumRegion() {
        int[][] a0 = {{0}};
        prepareSums(a0);
        assertEquals(0, sumRegion(0, 0, 0, 0));
        int[][] a = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        prepareSums(a);
        assertEquals(3, sumRegion(0, 0, 0, 0));
        assertEquals(14, sumRegion(0, 0, 1, 1));
        assertEquals(8, sumRegion(2, 1, 4, 3));
        assertEquals(58, sumRegion(0, 0, 4, 4));
    }
}
