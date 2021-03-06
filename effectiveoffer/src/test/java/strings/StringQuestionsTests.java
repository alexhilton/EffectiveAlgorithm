package strings;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
import static strings.DoublePointer.maxUniqueSubstring;
import static strings.DoublePointer.minSubstring;

public class StringQuestionsTests {
    @Test
    public void testMinSubstring() {
        assertEquals("", minSubstring("", ""));
        assertEquals("", minSubstring("", "abcd"));
        assertEquals("", minSubstring("abcd", ""));

        assertEquals("a", minSubstring("a", "a"));
        assertEquals("a", minSubstring("abcd", "a"));
        assertEquals("a", minSubstring("aaaa", "a"));

        assertEquals("BANC", minSubstring("ADDBANCAD", "ABC"));
    }

    @Test
    public void testMaxSubstring() {
        assertEquals(0, maxUniqueSubstring(""));
        assertEquals(1, maxUniqueSubstring("a"));
        assertEquals(3, maxUniqueSubstring("babcca"));
        assertEquals(5, maxUniqueSubstring("abcde"));
        assertEquals(1, maxUniqueSubstring("aaaaa"));
    }

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
