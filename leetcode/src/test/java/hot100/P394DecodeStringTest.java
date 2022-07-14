package hot100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P394DecodeStringTest {
    @Test
    public void testBasics() {
        assertEquals("aaabcbc", P394DecodeString.decodeString("3[a]2[bc]"));
        assertEquals("abcabccdcdcdef", P394DecodeString.decodeString("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", P394DecodeString.decodeString("abc3[cd]xyz"));
    }

    @Test
    public void testRecursive() {
        assertEquals("accaccacc", P394DecodeString.decodeString("3[a2[c]]"));
        assertEquals("accdaccdaccd", P394DecodeString.decodeString("3[a2[c]d]"));
    }

    @Test
    public void testMore() {
        assertEquals("abcabcabcabcabcabcabcabcabcabc", P394DecodeString.decodeString("10[abc]"));
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode",
                P394DecodeString.decodeString("100[leetcode]"));
    }
}
