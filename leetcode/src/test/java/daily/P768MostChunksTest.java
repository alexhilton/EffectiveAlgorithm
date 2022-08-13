package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P768MostChunksTest {
    private P768MostChunks instance;

    @BeforeEach
    public void setup() {
        instance = new P768MostChunks();
    }

    @Test
    public void testDemos() {
        assertEquals(1, instance.maxChunksToSorted(new int[] {5,4,3,2,1}));
        assertEquals(4, instance.maxChunksToSorted(new int[] {2,1,3,4,4}));
    }

    @Test
    public void testBasics() {
        assertEquals(5, instance.maxChunksToSorted(new int[] {1, 2, 3, 4, 5}));
        assertEquals(1, instance.maxChunksToSorted(new int[] {1}));
        assertEquals(4, instance.maxChunksToSorted(new int[] {1, 1, 1, 1}));
        assertEquals(4, instance.maxChunksToSorted(new int[] {2, 1, 3, 4, 5}));
    }

    @Test
    public void testMore() {
        assertEquals(1, instance.maxChunksToSorted(new int[] {4, 1, 3}));
        assertEquals(1, instance.maxChunksToSorted(new int[] {4, 1, 2, 3}));
        assertEquals(2, instance.maxChunksToSorted(new int[] {4, 1, 2, 3, 9, 9, 6}));
        assertEquals(1, instance.maxChunksToSorted(new int[] {4, 1, 2, 3, 3, 3}));
        assertEquals(4, instance.maxChunksToSorted(new int[] {4, 1, 2, 3, 3, 3, 4, 4, 4}));
    }

    @Test
    public void testCase43() {
        assertEquals(2, instance.maxChunksToSorted(new int[] {0,3,0,3,2}));
    }
}
