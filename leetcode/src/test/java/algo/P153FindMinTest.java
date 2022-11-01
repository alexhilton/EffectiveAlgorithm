package algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P153FindMinTest {
    private P153FindMin instance;

    @BeforeEach
    public void setup() {
        instance = new P153FindMin();
    }

    @Test
    public void testDemos() {
        assertEquals(1, instance.findMin(new int[] {3, 4, 5, 1, 2}));
        assertEquals(0, instance.findMin(new int[] {4,5,6,7,0,1,2}));
        assertEquals(11, instance.findMin(new int[] {11,13,15,17}));
    }

    @Test
    public void testBasics() {
        assertEquals(1, instance.findMin(new int[] {1}));
        assertEquals(1, instance.findMin(new int[] {1, 2}));
        assertEquals(1, instance.findMin(new int[] {2, 1}));
    }

    @Test
    public void testMore() {
        assertEquals(0, instance.findMin(new int[] {0, 1, 2}));
        assertEquals(0, instance.findMin(new int[] {2, 0, 1}));
        assertEquals(0, instance.findMin(new int[] {1, 2, 0}));
    }

    @Test
    public void testCase84() {
        assertEquals(1, instance.findMin(new int[] {2,3,4,5,1}));
    }
}
