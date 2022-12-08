package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P052NQueensTest {
    private P052NQueens instance;

    @BeforeEach
    public void setup() {
        instance = new P052NQueens();
    }

    @Test
    public void testDemos() {
        assertEquals(2, instance.totalNQueens(4));
        assertEquals(1, instance.totalNQueens(1));
    }

    @Test
    public void testAll() {
        assertEquals(0, instance.totalNQueens(2));
        assertEquals(0, instance.totalNQueens(3));
        assertEquals(10, instance.totalNQueens(5));
        assertEquals(4, instance.totalNQueens(6));
        assertEquals(40, instance.totalNQueens(7));
        assertEquals(92, instance.totalNQueens(8));
        assertEquals(352, instance.totalNQueens(9));
    }
}
