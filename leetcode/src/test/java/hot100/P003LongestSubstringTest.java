package hot100;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P003LongestSubstringTest {
    @Test
    public void testLongestSubstring() {
        Function<String, Integer> action = P003LongestSubstring::bruteForce;
        assertEquals(0, action.apply(""));
        assertEquals(1, action.apply("a"));
        assertEquals(2, action.apply("ab"));
        assertEquals(3, action.apply("abc"));
        assertEquals(3, action.apply("abcabcbb"));
        assertEquals(1, action.apply("bbbbb"));
        assertEquals(3, action.apply("pwwkew"));
    }
}
