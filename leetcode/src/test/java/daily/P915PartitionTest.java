package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P915PartitionTest {
    private P915Partition instance;

    @BeforeEach
    public void setup() {
        instance = new P915Partition();
    }

    @Test
    public void testDemos() {
        assertEquals(3, instance.partitionDisjoint(new int[] {5, 0, 3, 8, 6}));
        assertEquals(4, instance.partitionDisjoint(new int[] {1, 1, 1, 0, 6, 12}));
    }

    @Test
    public void testBasics() {
        assertEquals(1, instance.partitionDisjoint(new int[] {1, 1}));
        assertEquals(1, instance.partitionDisjoint(new int[] {1, 3}));
    }

    @Test
    public void testCase17() {
        assertEquals(1, instance.partitionDisjoint(new int[] {26,51,40,58,42,76,30,48,79,91}));
    }
}
