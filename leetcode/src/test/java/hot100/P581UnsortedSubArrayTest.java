package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P581UnsortedSubArrayTest {
    private P581UnsortedSubArray instance;

    @BeforeEach
    public void setup() {
        instance = new P581UnsortedSubArray();
    }

    @Test
    public void testBasics() {
        assertEquals(0, instance.findUnsortedSubarray(new int[] {1}));
        assertEquals(0, instance.findUnsortedSubarray(new int[] {100}));
        assertEquals(0, instance.findUnsortedSubarray(new int[] {1, 2}));
        assertEquals(2, instance.findUnsortedSubarray(new int[] {2, 1}));
        assertEquals(2, instance.findUnsortedSubarray(new int[] {1, 2, 1}));
        assertEquals(0, instance.findUnsortedSubarray(new int[] {1, 1}));
        assertEquals(0, instance.findUnsortedSubarray(new int[] {2, 2}));
    }

    @Test
    public void testDemos() {
        assertEquals(5, instance.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15}));
        assertEquals(0, instance.findUnsortedSubarray(new int[] {1, 2, 3, 4}));
        assertEquals(0, instance.findUnsortedSubarray(new int[] {1}));
    }

    @Test
    public void testMore() {
        assertEquals(2, instance.findUnsortedSubarray(new int[] {2, 1, 5, 6, 7, 8, 9}));
        assertEquals(5, instance.findUnsortedSubarray(new int[] {1, 2, 8, 3, 5, 10, 9, 30, 40}));
    }
}
