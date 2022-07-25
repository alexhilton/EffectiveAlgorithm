package hot100;

import org.junit.jupiter.api.Test;

import static hot100.P309SellStock.maxProfit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P309SellStockTest {
    @Test
    public void testBasics() {
        assertEquals(0, maxProfit(new int[] {1}));
        assertEquals(0, maxProfit(new int[] {100}));
        assertEquals(0, maxProfit(new int[] {2, 1}));
        assertEquals(0, maxProfit(new int[] {1, 1}));
        assertEquals(0, maxProfit(new int[] {1, 1, 1}));
        assertEquals(0, maxProfit(new int[] {7, 6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void testDemos() {
        assertEquals(3, maxProfit(new int[] {1, 2, 3, 0, 2}));
        assertEquals(0, maxProfit(new int[] {1}));
    }

    @Test
    public void testCase27() {
        assertEquals(3, maxProfit(new int[] {2, 1, 4}));
    }
}
