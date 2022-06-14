package hot100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P048RotateMatrixTest {
    @Test
    public void testRotateMatrix1() {
        int[][] m = {{123}};
        int[][] expected = {{123}};
        P048RotateMatrix.rotate(m);
        assertArrayEquals(expected, m);
    }

    @Test
    public void testRotateMatrix2() {
        int[][] m = {{1, 2}, {3, 4}};
        int[][] expected = {{3, 1}, {4, 2}};
        P048RotateMatrix.rotate(m);
        assertArrayEquals(expected, m);
    }

    @Test
    public void testRotateMatrix3() {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        P048RotateMatrix.rotate(m);
        assertArrayEquals(expected, m);
    }

    @Test
    public void testRotateMatrix4() {
        int[][] m = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] expected = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        P048RotateMatrix.rotate(m);
        assertArrayEquals(expected, m);
    }

    @Test
    public void testRotateMatrix5() {
        int[][] m = {
                {5, 1, 9, 11, 17},
                {2, 4, 8, 10, 18},
                {13, 3, 6, 7, 19},
                {15, 14, 12, 16, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] expected = {
                {21, 15, 13, 2, 5},
                {22, 14, 3, 4, 1},
                {23, 12, 6, 8, 9},
                {24, 16, 7, 10, 11},
                {25, 20, 19, 18, 17}
        };
        P048RotateMatrix.rotate(m);
        assertArrayEquals(expected, m);
    }
}
