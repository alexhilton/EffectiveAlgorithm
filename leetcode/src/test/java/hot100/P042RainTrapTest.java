package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P042RainTrapTest {
    private P042RainTrap instance;

    @BeforeEach
    public void setup() {
        instance = new P042RainTrap();
    }

    @Test
    public void testDemos() {
        assertEquals(6, instance.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9, instance.trap(new int[] {4,2,0,3,2,5}));
    }

    @Test
    public void testBasics() {
        assertEquals(0, instance.trap(new int[] {0}));
        assertEquals(0, instance.trap(new int[] {0,0}));
        assertEquals(0, instance.trap(new int[] {1}));
        assertEquals(0, instance.trap(new int[] {0, 1}));
        assertEquals(0, instance.trap(new int[] {1, 3}));
        assertEquals(0, instance.trap(new int[] {0, 0, 0}));
        assertEquals(0, instance.trap(new int[] {1, 1, 1}));
        assertEquals(0, instance.trap(new int[] {1, 4, 2}));
        assertEquals(0, instance.trap(new int[] {1, 2, 4}));
        assertEquals(0, instance.trap(new int[] {1, 3, 5, 7, 9}));
        assertEquals(0, instance.trap(new int[] {9,7,5,3,1}));
    }

    @Test
    public void testMore() {
        assertEquals(1, instance.trap(new int[] {1, 0, 1}));
        assertEquals(1, instance.trap(new int[] {1, 0, 3}));
        assertEquals(1, instance.trap(new int[] {3, 0, 1}));
        assertEquals(3, instance.trap(new int[] {1, 0, 0, 0, 1}));
        assertEquals(3, instance.trap(new int[] {1, 0, 0, 0, 4}));
        assertEquals(3, instance.trap(new int[] {4, 0, 0, 0, 1}));
        assertEquals(6, instance.trap(new int[] {2, 0, 0, 0, 2}));
        assertEquals(6, instance.trap(new int[] {2, 0, 0, 0, 5}));
        assertEquals(6, instance.trap(new int[] {5, 0, 0, 0, 2}));
    }

    @Test
    public void testAdvanced() {
        assertEquals(6, instance.trap(new int[] {1, 0, 0, 2, 0, 0, 3}));
        assertEquals(6, instance.trap(new int[] {3, 0, 0, 2, 0, 0, 1}));
    }

    @Test
    public void testPeak() {
        assertEquals(9, instance.trap(new int[] {1, 0, 2, 0, 3, 0, 3, 0, 2, 0, 1}));
    }

    @Test
    public void testValley() {
        assertEquals(16, instance.trap(new int[] {3, 0, 2,0,1,0,2,0,3}));
        assertEquals(9, instance.trap(new int[] {3, 0, 2,0,1,0,2,0,2}));
        assertEquals(9, instance.trap(new int[] {2, 0, 2,0,1,0,2,0,3}));
        assertEquals(9, instance.trap(new int[] {2, 0, 2,0,1,0,2,0,2}));
    }
}
