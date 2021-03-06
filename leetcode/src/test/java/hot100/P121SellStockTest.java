package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P121SellStockTest {
    Function<int[], Integer> action;

    @BeforeEach
    public void setup() {
        action = P121SellStock::doublePointer;
    }

    @Test
    public void testSellStock() {
        assertEquals(0, action.apply(new int[] {}));

        assertEquals(0, action.apply(new int[] {1}));
        assertEquals(0, action.apply(new int[] {2, 1}));
        assertEquals(0, action.apply(new int[] {1, 1}));
        assertEquals(0, action.apply(new int[] {6, 5, 4, 3, 2, 1}));

        assertEquals(1, action.apply(new int[] {1, 2}));
        assertEquals(1, action.apply(new int[] {1, 2, 1}));
        assertEquals(5, action.apply(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(0, action.apply(new int[] {7, 6, 4, 3, 1}));

        assertEquals(6, action.apply(new int[] {6, 1, 3, 2, 4, 7}));

        assertEquals(3, action.apply(new int[] {2, 1, 4}));

        assertEquals(7, action.apply(new int[] {9, 2, 4, 6, 8, 1, 8}));
    }
}
