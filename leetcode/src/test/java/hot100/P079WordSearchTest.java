package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class P079WordSearchTest {
    private P079WordSearch instance;

    @BeforeEach
    public void setup() {
        instance = new P079WordSearch();
    }

    @Test
    public void testDemos() {
        assertTrue(instance.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        assertTrue(instance.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        assertFalse(instance.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    @Test
    public void testBasics() {
        assertTrue(instance.exist(new char[][] {{'a'}}, "a"));
        assertFalse(instance.exist(new char[][] {{'a'}}, "b"));
        assertTrue(instance.exist(new char[][] {{'a', 'b'}}, "ab"));
        assertTrue(instance.exist(new char[][] {{'a', 'b'}}, "ba"));
    }

    @Test
    public void testCase64() {
        assertTrue(instance.exist(new char[][] {{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB"));
    }
}
