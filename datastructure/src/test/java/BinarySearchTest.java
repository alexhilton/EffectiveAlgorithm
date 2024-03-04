import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    private BinarySearch instance;

    @BeforeEach
    public void setup() {
        instance = new BinarySearch();
    }

    @Test
    public void testStandard() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int ans = instance.standardAsc(arr, 2);
        assertEquals(1, ans);
        ans = instance.standardAsc(arr, 5);
        assertEquals(4, ans);
        ans = instance.standardAsc(arr, 1);
        assertEquals(0, ans);
        ans = instance.standardAsc(arr, 7);
        assertEquals(6, ans);
        ans = instance.standardAsc(arr, 0);
        assertEquals(-1, ans);
        ans = instance.standardAsc(arr, 8);
        assertEquals(-1, ans);

        int[] arr2 = {2, 4, 4, 7, 7, 7, 9, 14, 14, 14, 18};
        ans = instance.standardAsc(arr2, 4);
        assertTrue(ans >= 1 && ans <= 2);
        ans = instance.standardAsc(arr2, 7);
        assertTrue(ans >= 3 && ans <= 5);
        ans = instance.standardAsc(arr2, 14);
        assertTrue(ans >= 7 && ans <= 9);
        ans = instance.standardAsc(arr2, 0);
        assertEquals(-1, ans);
        ans = instance.standardAsc(arr2, 3);
        assertEquals(-1, ans);
        ans = instance.standardAsc(arr2, 10);
        assertEquals(-1, ans);
        ans = instance.standardAsc(arr2, 20);
        assertEquals(-1, ans);
    }

    @Test
    public void testFirstBiggerV1() {
        doTest(instance::firstBiggerAscV1, false);
    }
    
    private void doTest(BiFunction<int[], Integer, Integer> func, boolean desc) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        if (desc) {
            reverse(arr);
        }
        int n = arr.length - 1;
        int ans = func.apply(arr, 3);
        assertEquals(desc ? n - 2 : 2, ans);
        ans = func.apply(arr, 6);
        assertEquals(desc ? n - 5 : 5, ans);

        ans = func.apply(arr, 0);
        assertEquals(desc ? n : 0, ans, "All answer");
        ans = func.apply(arr, 10);
        assertEquals(-1, ans, "No answer");

        int[] arr2 = {2, 4, 4, 7, 7, 7, 10, 14, 14, 14, 29, 29, 29};
        n = arr2.length - 1;
        if (desc) {
            reverse(arr2);
        }
        ans = func.apply(arr2, 7);
        assertEquals(desc ? n - 3: 3, ans);
        ans = func.apply(arr2, 10);
        assertEquals(desc ? n - 6 : 6, ans);
        ans = func.apply(arr2, 29);
        assertEquals(desc ? n - 10 : 10, ans);
        ans = func.apply(arr2, 0);
        assertEquals(desc ? n : 0, ans);
        ans = func.apply(arr2, 100);
        assertEquals(-1, ans);

        int[] arr3 = {1, 10, 10};
        n = arr3.length - 1;
        if (desc) {
            reverse(arr3);
        }
        ans = func.apply(arr3, 1);
        assertEquals(desc ? n : 0, ans);
        ans = func.apply(arr3, 2);
        assertEquals(desc ? n - 1 : 1, ans);
        ans = func.apply(arr3, 10);
        assertEquals(desc ? n - 1 : 1, ans);
        ans = func.apply(arr3, 30);
        assertEquals(-1, ans);
    }

    @Test
    public void testFirstBiggerV2() {
        doTest(instance::firstBiggerAscV2, false);
    }

    @Test
    public void testLastBiggerV1() {
        doTest(instance::lastBiggerDscV1, true);
    }

    private static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    @Test
    public void testLastBiggerV2() {
        doTest(instance::lastBiggerDscV2, true);
    }
}
