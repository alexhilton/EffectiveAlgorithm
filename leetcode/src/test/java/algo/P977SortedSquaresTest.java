package algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P977SortedSquaresTest {
    private P977SortedSquares instance;

    @BeforeEach
    public void setup() {
        instance = new P977SortedSquares();
    }

    @Test
    public void testDemos() {
        assertArrayEquals(new int[] {0,1,9,16,100}, instance.sortedSquares(new int[] {-4,-1,0,3,10}));
        assertArrayEquals(new int[] {4,9,9,49,121}, instance.sortedSquares(new int[] {-7,-3,2,3,11}));
    }

    @Test
    public void testBasics() {
        assertArrayEquals(new int[] {1}, instance.sortedSquares(new int[] {1}));
        assertArrayEquals(new int[] {0}, instance.sortedSquares(new int[] {0}));
        assertArrayEquals(new int[] {0, 1}, instance.sortedSquares(new int[] {0, 1}));

        assertArrayEquals(new int[] {0, 1}, instance.sortedSquares(new int[] {-1, 0}));
    }

    @Test
    public void testMore() {
        assertArrayEquals(new int[] {1, 4, 9, 16, 25}, instance.sortedSquares(new int[] {1, 2, 3, 4, 5}));
        assertArrayEquals(new int[] {1, 4, 9, 16, 25}, instance.sortedSquares(new int[] {-5, -4, -3, -2, -1}));
        assertArrayEquals(new int[] {1, 4, 9, 16, 25}, instance.sortedSquares(new int[] {-5, 1, 2, 3, 4}));
        assertArrayEquals(new int[] {1, 4, 9, 16, 25}, instance.sortedSquares(new int[] {-4, -3, -2, -1, 5}));
    }
}
