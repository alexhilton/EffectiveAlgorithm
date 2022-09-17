package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class P200NumberOfIslands {
    private final static int[][] DIRS = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    private Map<Integer, Integer> fathers;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        fathers = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int key = i * m + j;
                    System.out.println(" i " + i + ", j " + j + ", key -> " + key);
                    if (!fathers.containsKey(key)) {
                        fathers.put(key, key);
                    }

                    int topX = i - 1;
                    boolean unionWithTop = topX >= 0 && grid[topX][j] == '1';
                    int leftY = j - 1;
                    boolean unionWithLeft = leftY >= 0 && grid[i][leftY] == '1';

                    if (unionWithLeft && unionWithTop) {
                        union(topX * m + j, key);
                        union(topX * m + j, i * m + leftY);
                    } else if (unionWithLeft) {
                        union(i * m + leftY, key);
                    } else if (unionWithTop) {
                        union(topX * m + j, key);
                    }
                }
            }
        }

        return (int) fathers.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getKey(), entry.getValue()))
                .count();
    }

    private int find(int key) {
        int f = fathers.get(key);
        if (f == key) {
            return f;
        }
        int ff = find(f);
        fathers.put(key, ff);
        return ff;
    }

    private void union(int u, int v) {
        int fu = find(u);
        int fv = find(v);
        if (fu == fv) {
            return;
        }
        fathers.put(v, fu);
    }
}
