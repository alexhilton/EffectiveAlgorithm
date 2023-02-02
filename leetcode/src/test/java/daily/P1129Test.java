package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P1129Test {
    private P1129 instance;

    @BeforeEach
    public void setup() {
        instance = new P1129();
    }

    @Test
    public void testDemos() {
        assertArrayEquals(
                new int[] {0,1,-1},
                instance.shortestAlternatingPaths(
                        3,
                        new int[][] {{0,1},{1,2}},
                        new int[][] {}
                )
        );

        assertArrayEquals(
                new int[] {0,1,-1},
                instance.shortestAlternatingPaths(
                        3,
                        new int[][] {{0,1}},
                        new int[][] {{2,1}}
                )
        );

        assertArrayEquals(
                new int[] {0,-1,-1},
                instance.shortestAlternatingPaths(
                        3,
                        new int[][] {{1,0}},
                        new int[][] {{2,1}}
                )
        );

        assertArrayEquals(
                new int[] {0,1,2},
                instance.shortestAlternatingPaths(
                        3,
                        new int[][] {{0,1}},
                        new int[][] {{1,2}}
                )
        );

        assertArrayEquals(
                new int[] {0,1,1},
                instance.shortestAlternatingPaths(
                        3,
                        new int[][] {{0,1},{0,2}},
                        new int[][] {{1,0}}
                )
        );
    }

    @Test
    public void testCase44() {
        assertArrayEquals(
                new int[] {0,1,2,3,7},
                instance.shortestAlternatingPaths(
                        5,
                        new int[][] {{0,1},{1,2},{2,3},{3,4}},
                        new int[][] {{1,2},{2,3},{3,1}}
                )
        );
    }
}
