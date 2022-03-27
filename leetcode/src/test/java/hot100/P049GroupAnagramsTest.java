package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P049GroupAnagramsTest {
    Function<String[], String[][]> action;

    @BeforeEach
    public void setup() {
        action = strs -> {
            List<List<String>> result = P049GroupAnagrams.groupAnagrams(strs);
            String[][] arrays = new String[result.size()][];
            for (int i = 0; i < result.size(); i++) {
                arrays[i] = result.get(i).toArray(new String[0]);
            }
            return arrays;
        };
    }

    @Test
    public void testGroupAnagrams() {
        assertArrayEquals(new String[][] {{}}, action.apply(new String[] {}));

        assertArrayEquals(new String[][] {{"a"}}, action.apply(new String[] {"a"}));

        assertArrayEquals(new String[][] {{"bat"}, {"nat","tan"}, {"ate","eat","tea"}}, action.apply(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
