package daily;

import java.util.Arrays;

public class P1620Coordinates {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xmin = towers[0][0];
        int ymin = towers[0][1];
        int xmax = towers[0][0];
        int ymax = towers[0][1];
        for (int[] t : towers) {
            xmin = Math.min(xmin, t[0]);
            xmax = Math.max(xmax, t[0]);
            ymin = Math.min(ymin, t[1]);
            ymax = Math.max(ymax, t[1]);
        }

        int[] max = {0, 0, 0};
        for (int x = xmin; x <= xmax; x++) {
            for (int y = ymin; y <= ymax; y++) {
                int signal = getSignal(towers, x, y, radius);
                if (max[2] < signal) {
                    max[0] = x;
                    max[1] = y;
                    max[2] = signal;
                }
            }
        }

        return new int[] {max[0], max[1]};
    }

    private int getSignal(int[][] towers, int x, int y, int r) {
        int s = 0;
        for (int[] t : towers) {
            s += doSignal(t, x, y, r);
        }

        return s;
    }

    private int doSignal(int[] t, int x, int y, int radius) {
        if (t[2] == 0) {
            return 0;
        }
        float d = (float) Math.sqrt((t[0]-x)*(t[0]-x) + (t[1]-y)*(t[1]-y));
        if (d > radius) {
            return 0;
        }
        return (int) Math.floor((float) t[2] / (1.0 + d));
    }
}
