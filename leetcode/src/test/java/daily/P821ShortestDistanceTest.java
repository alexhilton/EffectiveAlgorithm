package daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P821ShortestDistanceTest {
    @Test
    public void testShortestDistance() {
        assertArrayEquals(new int[] {1, 0, 0, 1}, P821ShortestDistance.shortestToChar("abba", 'b'));
        assertArrayEquals(new int[] {2, 1, 0, 1}, P821ShortestDistance.shortestToChar("aaba", 'b'));
        assertArrayEquals(new int[] {3, 2, 1, 0}, P821ShortestDistance.shortestToChar("aaab", 'b'));
        assertArrayEquals(new int[] {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, P821ShortestDistance.shortestToChar("loveleetcode", 'e'));
    }
}
