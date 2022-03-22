package strings;

import org.junit.jupiter.api.Test;

import javax.crypto.AEADBadTagException;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class StringQuestionsTests {
    @Test
    public void testFindAnagrams() {
        BiFunction<String, String, int[]> action = (s1, s2) -> {
            List<Integer> result = DoublePointer.findAnagrams(s1, s2);
            int[] array = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                array[i] = result.get(i);
            }
            return array;
        };

        assertArrayEquals(new int[] {-1}, action.apply("ab", "dgcaf"));
        assertArrayEquals(new int[] {-1}, action.apply("ac", "dgcaf"));
        assertArrayEquals(new int[] {0, 5}, action.apply("cbadabacg", "abc"));
    }

    @Test
    public void testCheckInclusion() {
        BiFunction<String, String, Boolean> action = DoublePointer::checkInclusion;

        assertFalse(action.apply("abcdef", "abcd"));

        assertTrue(action.apply("ac", "dgcaf"));
        assertFalse(action.apply("ab", "dgcaf"));
    }
}
