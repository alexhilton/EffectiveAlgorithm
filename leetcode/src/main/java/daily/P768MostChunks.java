package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P768MostChunks {
    public int maxChunksToSorted(int[] arr) {
        final int n = arr.length;
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int b = sorted[i];
            if (a == b && map.isEmpty()) {
                result++;
                continue;
            }
            int count = map.getOrDefault(a, 0) + 1;
            if (count == 0) {
                map.remove(a);
            } else {
                map.put(a, count);
            }

            count = map.getOrDefault(b, 0) - 1;
            if (count == 0) {
                map.remove(b);
            } else {
                map.put(b, count);
            }
            if (map.isEmpty()) {
                result++;
            }
        }

        return result;
    }
}
