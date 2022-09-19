package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class P200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet dset = new DisjointSet(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int key = i * n + j;
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        dset.union(key, key + n);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        dset.union(key, key + 1);
                    }
                }
            }
        }

        return dset.getCount();
    }

    static class DisjointSet {
        private Map<Integer, Integer> fathers;
        private Map<Integer, Integer> rank;

        public DisjointSet(char[][] data) {
            final int m = data.length;
            final int n = data[0].length;
            fathers = new HashMap<>();
            rank = new HashMap<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == '1') {
                        int key = i * n + j;
                        fathers.put(key, key);
                    }
                }
            }
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
            int ru = rank.getOrDefault(fu, 0);
            int rv = rank.getOrDefault(fv, 0);
            if (ru < rv) {
                fathers.put(fu, fv);
            } else if (ru > rv) {
                fathers.put(fv, fu);
            } else {
                fathers.put(fv, fu);
                rank.put(fu, ru + 1);
            }
        }

        public int getCount() {
            return (int) fathers.entrySet().stream()
                    .filter(ent -> Objects.equals(ent.getKey(), ent.getValue()))
                    .count();
        }
    }
}
