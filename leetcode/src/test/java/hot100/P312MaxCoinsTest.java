package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P312MaxCoinsTest {
    private P312MaxCoins instance;

    @BeforeEach
    public void setup() {
        instance = new P312MaxCoins();
    }

    @Test
    public void testDemos() {
        assertEquals(167, instance.maxCoins(new int[] {3,1,5,8}));
        assertEquals(10, instance.maxCoins(new int[] {1,5}));
    }

    @Test
    public void testBasics() {
        assertEquals(0, instance.maxCoins(new int[]{0}));
        assertEquals(1, instance.maxCoins(new int[]{1}));
        assertEquals(0, instance.maxCoins(new int[]{0, 0}));
        assertEquals(1, instance.maxCoins(new int[]{0, 1}));
        assertEquals(3, instance.maxCoins(new int[]{1, 1, 1}));
        assertEquals(6, instance.maxCoins(new int[]{1, 2, 1}));
    }

    @Test
    public void testMore() {
        assertEquals(33, instance.maxCoins(new int[]{2, 4, 3}));
        assertEquals(39, instance.maxCoins(new int[] {1,2,4,3,1}));
    }
}
