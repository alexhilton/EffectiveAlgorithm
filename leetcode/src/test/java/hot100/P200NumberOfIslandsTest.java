package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P200NumberOfIslandsTest {
    private P200NumberOfIslands instance;

    @BeforeEach
    public void setup() {
        instance = new P200NumberOfIslands();
    }

    @Test
    public void testDemos() {
        assertEquals(1, instance.numIslands(new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
        assertEquals(3, instance.numIslands(new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }

    @Test
    public void testCase33() {
        assertEquals(1, instance.numIslands(new char[][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        }));
    }
}
