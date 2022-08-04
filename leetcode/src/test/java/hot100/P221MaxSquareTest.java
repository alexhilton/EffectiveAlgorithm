package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P221MaxSquareTest {
    private P221MaxSquare instance;

    @BeforeEach
    public void setup() {
        instance = new P221MaxSquare();
    }

    @Test
    public void testDemos() {
        assertEquals(4, instance.maximalSquare(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        assertEquals(1, instance.maximalSquare(new char[][] {{'0','1'},{'1','0'}}));
        assertEquals(0, instance.maximalSquare(new char[][] {{'0'}}));
        assertEquals(1, instance.maximalSquare(new char[][] {{'1'}}));
    }

    @Test
    public void testBoundaries() {
        assertEquals(1, instance.maximalSquare(new char[][] {{'1', '1', '1', '1'}}));
        assertEquals(1, instance.maximalSquare(new char[][] {{'1'}, {'1'}, {'1'}, {'1'}}));
        assertEquals(0, instance.maximalSquare(new char[][] {{'0', '0', '0', '0'}}));
        assertEquals(0, instance.maximalSquare(new char[][] {{'0'}, {'0'}, {'0'}, {'0'}}));

        assertEquals(1, instance.maximalSquare(new char[][] {{'0', '0', '1', '0'}}));
        assertEquals(1, instance.maximalSquare(new char[][] {{'0'}, {'0'}, {'0'}, {'1'}}));
    }

    @Test
    public void testCase63() {
        assertEquals(1, instance.maximalSquare(new char[][] {{'1','0'},{'0','0'}}));
    }

    @Test
    public void testCase65() {
        assertEquals(16, instance.maximalSquare(new char[][] {{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}}));
    }
}
