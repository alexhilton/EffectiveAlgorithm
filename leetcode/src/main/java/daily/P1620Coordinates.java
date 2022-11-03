package daily;

import java.util.Arrays;

public class P1620Coordinates {
    public int[] bestCoordinate(int[][] towers, int radius) {
        final int n = towers.length;
        int[] signals = new int[n];
        Arrays.sort(towers, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                signals[i] += getSignal(towers[i], towers[j], radius);
            }
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            if (signals[max] < signals[i]) {
                max = i;
            }
        }
        if (towers[max][2] == 0) {
            return new int[] {0, 0};
        }
        return new int[] {towers[max][0], towers[max][1]};
    }

    private int getSignal(int[] a, int[] b, int radius) {
        int d = (int) Math.floor(Math.sqrt((a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1])));
        if (b[2] == 0 || d > radius) {
            return 0;
        }
        return (int) Math.floor((float) b[2] / (1.0 + d));
    }
}
