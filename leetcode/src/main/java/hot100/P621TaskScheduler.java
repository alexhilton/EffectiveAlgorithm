package hot100;

import java.util.Arrays;

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
        Arrays.sort(counts);
        System.out.println(Arrays.toString(counts));
        if (counts[25] == 1) {
            return tasks.length;
        }
        int pk = counts[25];
        int spaces = n * (pk - 1);
        int m = tasks.length - pk;
        int duration = (pk - 1) * n + pk;
        for (int i = 24; counts[i] > 0; i--) {
            if (counts[i] == 1) {
                if (m > 0 && m > spaces) {
                    duration += m - spaces;
                }
                break;
            } else {
                int k;
                if (spaces > 0) {
                    k = counts[i] - (pk - 1);
                    spaces -= (pk - 1);
                } else {
                    k = counts[i];
                    spaces = (k - 1) * n;
                }
                duration += (k - 1) * n + k;
                pk = k;
                m -= k;
            }
        }
        return duration;
    }
}
