package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P1620CoordinatesTest {
    private P1620Coordinates instance;

    @BeforeEach
    public void setup() {
        instance = new P1620Coordinates();
    }

    @Test
    public void testDemos() {
        assertArrayEquals(new int[] {2,1}, instance.bestCoordinate(new int[][] {{1,2,5},{2,1,7},{3,1,9}}, 2));
        assertArrayEquals(new int[] {23,11}, instance.bestCoordinate(new int[][] {{23,11,21}}, 9));
        assertArrayEquals(new int[] {1,2}, instance.bestCoordinate(new int[][] {{1,2,13},{2,1,7},{0,1,9}}, 2));
    }

    @Test
    public void testCase88() {
        assertArrayEquals(new int[] {0, 0}, instance.bestCoordinate(new int[][] {{42, 0, 0}}, 7));
    }

    @Test
    public void testCase90() {
        assertArrayEquals(new int[] {1, 1}, instance.bestCoordinate(
                new int[][] {{0,1,2},{2,1,2},{1,0,2},{1,2,2}}, 1));
    }
}
