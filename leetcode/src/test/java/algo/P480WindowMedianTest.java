package algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P480WindowMedianTest {
    private P480WindowMedian instance;

    @BeforeEach
    public void setup() {
        instance = new P480WindowMedian();
    }

    @Test
    public void testDemos() {
        assertArrayEquals(new double[] {1,-1,-1,3,5,6}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3));
        assertArrayEquals(new double[] {2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000}, instance.medianSlidingWindow(new int[] {1,2,3,4,2,3,1,4,2}, 3));
    }

    @Test
    public void testBasics() {
        assertArrayEquals(new double[] {1.00000,3.00000,-1.00000,-3.00000,5.00000,3.00000,6.00000,7.00000}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 1));
        assertArrayEquals(new double[] {2.00000,1.00000,-2.00000,1.00000,4.00000,4.50000,6.50000}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 2));
        assertArrayEquals(new double[] {0.00000,1.00000,1.00000,4.00000,5.50000}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 4));
        assertArrayEquals(new double[] {1.00000,3.00000,3.00000,5.00000}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 5));
        assertArrayEquals(new double[] {2.00000,3.00000,4.00000}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 6));
        assertArrayEquals(new double[] {3.00000,3.00000}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 7));
        assertArrayEquals(new double[] {3}, instance.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 8));
    }

    @Test
    public void testDeletion() {
        assertArrayEquals(new double[] {3.00000,4.00000,4.00000,1.00000}, instance.medianSlidingWindow(new int[] {2,3,4,5,1,0}, 3));
        assertArrayEquals(new double[] {3.50000,3.50000,2.50000}, instance.medianSlidingWindow(new int[] {2,3,4,5,1,0}, 4));
    }

    @Test
    public void testBoundaries() {
        assertArrayEquals(new double[] {1}, instance.medianSlidingWindow(new int[] {1}, 1));
        assertArrayEquals(new double[] {-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,-2147483648.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,-2147483648.00000}, instance.medianSlidingWindow(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3));
    }

    @Test
    @Disabled
    public void testTimeLimit() {
        final String file = "l480.txt";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(file);
        try {
            assert is != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    String stuff = line.substring(1, line.length() - 1);
                    String[] parts = stuff.split(",");
                    int[] array = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        array[i] = Integer.parseInt(parts[i]);
                    }
                    String ks = br.readLine();
                    int k = Integer.parseInt(ks);
                    String es = br.readLine();
                    stuff = es.substring(1, es.length() - 1);
                    parts = stuff.split(",");
                    double[] ans = new double[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        ans[i] = Double.parseDouble(parts[i]);
                    }

                    assertArrayEquals(ans, instance.medianSlidingWindow(array, k));
                }
            }
        } catch (IOException ignored) {}
    }
}
