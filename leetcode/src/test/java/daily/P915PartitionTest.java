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

    @Test
    public void testCase65() {
        assertEquals(13, instance.partitionDisjoint(
                new int[] {
                        3,1,8,4,9,7,12,0,0,12,6,12,6,19,24,
                        90,87,54,92,60,31,59,75,90,20,38,52,
                        51,74,70,86,20,27,91,55,47,54,86,15,
                        16,74,32,68,27,19,54,13,22,34,74,76,
                        50,74,97,87,42,58,95,17,93,39,33,22,
                        87,96,90,71,22,48,46,37,18,17,65,54,
                        82,54,29,27,68,53,89,23,12,90,98,42,
                        87,91,23,72,35,14,58,62,79,30,67,44,48}));
    }
}
