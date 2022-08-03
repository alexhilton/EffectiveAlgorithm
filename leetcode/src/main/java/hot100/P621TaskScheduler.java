package hot100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        if (tasks.length == 1) {
            return 1;
        }
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(counts)
                .filter(a -> a > 0)
                .forEach(a -> heap.add(a));

        int pk = heap.poll();
        if (pk == 1) {
            return tasks.length;
        }
        int spaces = n * (pk - 1);
        int m = tasks.length - pk;
        int duration = (pk - 1) * n + pk;
        while (heap.size() > 0) {
            int k = heap.poll();
            if (k == 1) {
                if (spaces > 0) {
                    if (m > spaces) {
                        duration += m - spaces;
                    }
                } else {
                    duration += m;
                }
                break;
            }
            if (spaces > 0) {
                if (k == pk) {
                    duration++;
                    k--;
                    m--;
                }
                int nk = k - (pk - 1);
                spaces -= (pk - 1);
                m -= (pk - 1);
                if (nk > 0) {
                    heap.add(nk);
                }
            } else {
                pk = k;
                spaces = (k - 1) * n;
                duration += (k - 1) * n + k;
                m -= k;
            }
        }
        return duration;
    }
}
