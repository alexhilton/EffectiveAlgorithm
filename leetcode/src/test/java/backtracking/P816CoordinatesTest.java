package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class P816CoordinatesTest {
    private P816Coordinates instance;

    @BeforeEach
    public void setup() {
        instance = new P816Coordinates();
    }

    @Test
    public void testDemos() {
        doTest(List.of(
                "(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"
        ), "(123)");
        doTest(List.of(
                "(0.001, 1)", "(0, 0.011)"
        ), "(00011)");
        doTest(List.of(
                "(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"
        ), "(0123)");
        doTest(List.of(
                "(10, 0)"
        ), "(100)");
    }

    @Test
    public void testCase200() {
        doTest(List.of(
                "(0, 1.01)","(0, 10.1)","(0, 101)","(0.1, 0.1)"
        ), "(0101)");
    }

    private void doTest(List<String> expected, String payload) {
        List<String> exp = new ArrayList<>(expected);
        exp.sort(this::compare);
        List<String> actual = instance.ambiguousCoordinates(payload);
        actual.sort(this::compare);
        assertIterableEquals(exp, actual);
    }

    private int compare(String a, String b) {
        int idxa = a.indexOf(", ");
        int idxb = b.indexOf(", ");
        int ret = compareC(a.substring(1, idxa), b.substring(1, idxb));
        if (ret == 0) {
            return compareC(a.substring(idxa + 2, a.length() - 1), b.substring(idxb + 2, b.length() - 1));
        }
        return ret;
    }

    private int compareC(String a, String b) {
        float ret = Float.valueOf(a) - Float.valueOf(b);
        if (ret == 0) {
            return a.compareTo(b);
        }
        if (ret > 0) {
            return 1;
        }
        return -1;
    }
}
