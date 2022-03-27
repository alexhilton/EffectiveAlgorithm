package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P438FindAnagramsTest {
    BiFunction<String, String, int[]> action;

    @BeforeEach
    public void setup() {
        action = (s, p) -> {
            List<Integer> result = P438FindAnagrams.findAnagrams(s, p);
            int[] array = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                array[i] = result.get(i);
            }
            return array;
        };
    }

    @Test
    public void testFindAnagrams() {
        assertArrayEquals(new int[] {}, action.apply("a", "bc"));
        assertArrayEquals(new int[] {0, 6}, action.apply("cbaebabacd", "abc"));
        assertArrayEquals(new int[] {0, 1, 2}, action.apply("abab", "ab"));

        assertArrayEquals(new int[] {1}, action.apply("baa", "aa"));
    }
}
