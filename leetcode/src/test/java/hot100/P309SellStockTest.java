package hot100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P309SellStockTest {
    @Test
    public void testBasics() {
        assertEquals(0, P309SellStock.maxProfit(new int[] {1}));
        assertEquals(0, P309SellStock.maxProfit(new int[] {100}));
        assertEquals(0, P309SellStock.maxProfit(new int[] {2, 1}));
    }

    @Test
    public void testDemos() {
        assertEquals(3, P309SellStock.maxProfit(new int[] {1, 2, 3, 0, 2}));
        assertEquals(0, P309SellStock.maxProfit(new int[] {1}));
    }

    @Test
    public void testCase27() {
        assertEquals(3, P309SellStock.maxProfit(new int[] {2, 1, 4}));
    }
}
