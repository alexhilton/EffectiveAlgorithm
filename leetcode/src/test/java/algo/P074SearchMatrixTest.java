package algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class P074SearchMatrixTest {
    private P074SearchMatrix instance;

    @BeforeEach
    public void setup() {
        instance = new P074SearchMatrix();
    }

    @Test
    public void testDemos() {
        assertTrue(instance.searchMatrix(new int[][] {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 3));

        assertFalse(instance.searchMatrix(new int[][] {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 13));
    }

    @Test
    public void testBasics() {
        assertTrue(instance.searchMatrix(new int[][] {{1}}, 1));
        assertFalse(instance.searchMatrix(new int[][] {{1}}, 0));
    }

    @Test
    public void testMore() {
        assertFalse(instance.searchMatrix(new int[][] {{1, 1}}, 2));
        assertFalse(instance.searchMatrix(new int[][] {{1}, {1}}, 2));
    }
}
