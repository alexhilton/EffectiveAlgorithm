package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P031NextPermuteTest {
    private P031NextPermute instance;

    @BeforeEach
    public void setup() {
        instance = new P031NextPermute();
    }

    @Test
    public void testDemos() {
        doTest(new int[] {1,3,2}, new int[] {1,2,3});
        doTest(new int[] {1,2,3}, new int[] {3,2,1});
        doTest(new int[] {1,5,1}, new int[] {1,1,5});
    }

    private void doTest(int[] expected, int[] data) {
        instance.nextPermutation(data);
        assertArrayEquals(expected, data);
    }

    @Test
    public void testBasics() {
        doTest(new int[] {1}, new int[] {1});
        doTest(new int[] {2, 1}, new int[] {1, 2});
    }

    @Test
    public void testCase153() {
        doTest(new int[] {2, 1, 3}, new int[] {1,3,2});
    }

    @Test
    public void testCase154() {
        doTest(new int[] {3,1,2}, new int[] {2,3,1});
    }

    @Test
    public void testCase156() {
        doTest(new int[] {5,5,2,3,4,7}, new int[] {5,4,7,5,3,2});
    }
}
