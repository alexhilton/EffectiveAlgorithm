package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class P049GroupAnagramsTest {
    Function<String[], String[][]> action;

    @BeforeEach
    public void setup() {
        action = strs -> {
            List<List<String>> result = P049GroupAnagrams.groupAnagrams(strs);
            Collections.sort(result, Comparator.comparingInt(List::size));
            String[][] arrays = new String[result.size()][];
            for (int i = 0; i < result.size(); i++) {
                Collections.sort(result.get(i));
                arrays[i] = result.get(i).toArray(new String[0]);
            }
            return arrays;
        };
    }

    @Test
    public void testGroupAnagrams() {
        assertTrue(Arrays.deepEquals(new String[] {}, action.apply(new String[] {})));

        assertTrue(Arrays.deepEquals(new String[][] {{"a"}}, action.apply(new String[] {"a"})));

        assertTrue(Arrays.deepEquals(new String[][] {{"bat"}, {"nat","tan"}, {"ate","eat","tea"}}, action.apply(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})));
    }
}
