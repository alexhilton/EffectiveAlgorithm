package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P904TotalFruitsTest {
    private P904TotalFruits instance;

    @BeforeEach
    public void setup() {
        instance = new P904TotalFruits();
    }

    @Test
    public void testDemos() {
        assertEquals(3, instance.totalFruit(new int[] {1, 2, 1}));
        assertEquals(3, instance.totalFruit(new int[] {0, 1, 2, 2}));
        assertEquals(4, instance.totalFruit(new int[] {1, 2, 3, 2, 2}));
        assertEquals(5, instance.totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    @Test
    public void testCase59() {
        assertEquals(5, instance.totalFruit(new int[] {0, 1, 6, 6, 4, 4, 6}));
    }

    @Test
    public void testCase62() {
        assertEquals(5, instance.totalFruit(new int[] {1,0,1,4,1,4,1,2,3}));
    }
}
