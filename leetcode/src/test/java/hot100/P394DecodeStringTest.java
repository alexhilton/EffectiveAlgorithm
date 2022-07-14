package hot100;

import org.junit.jupiter.api.Test;

import static hot100.P394DecodeString.decodeString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P394DecodeStringTest {
    @Test
    public void testBasics() {
        assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
        assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", decodeString("abc3[cd]xyz"));
    }

    @Test
    public void testRecursive() {
        assertEquals("accaccacc", decodeString("3[a2[c]]"));
        assertEquals("accdaccdaccd", decodeString("3[a2[c]d]"));
        assertEquals("abcdgfdgfcdgfdgfbcdgfdgfcdgfdgf", decodeString("a2[b2[c2[d1[gf]]]]"));
        assertEquals("abceeeeeeeeg", decodeString("abc2[2[2[e]]]g"));
        assertEquals("abceeeeeeeeghij", decodeString("abc2[2[2[e]]]g1[hij]"));
        assertEquals("abcexyzexyzexyzexyzexyzexyzexyzexyzghij", decodeString("abc2[2[2[e1[xyz]]]]g1[hij]"));
    }

    @Test
    public void testMore() {
        assertEquals("abcabcabcabcabcabcabcabcabcabc", decodeString("10[abc]"));
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode",
                decodeString("100[leetcode]"));
    }

    @Test
    public void testMuchMore() {
        assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef",
                decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
