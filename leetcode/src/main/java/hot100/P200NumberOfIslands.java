package hot100;

import javax.lang.model.type.UnionType;
import java.util.HashMap;
import java.util.Map;

public class P200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet dset = new DisjointSet(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int key = i * n + j;
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        dset.union(key, key + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        dset.union(key, key + n);
                    }
                }
            }
        }

        return dset.getCount();
    }

    static class DisjointSet {
        private int[] fathers;
        private int[] rank;
        private int count;

        public DisjointSet(char[][] data) {
            final int m = data.length;
            final int n = data[0].length;
            fathers = new int[m * n];
            rank = new int[m * n];
            count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == '1') {
                        int key = i * n + j;
                        fathers[key] = key;
                        rank[key] = 0;
                        count++;
                    }
                }
            }
        }

        private int find(int key) {
            int f = fathers[key];
            if (f == key) {
                return f;
            }
            int ff = find(f);
            fathers[key] = ff;
            return ff;
        }

        private void union(int u, int v) {
            int fu = find(u);
            int fv = find(v);
            if (fu == fv) {
                return;
            }
            if (rank[fu] < rank[fv]) {
                fathers[u] = fv;
            } else if (rank[fu] > rank[fv]) {
                fathers[v] = fu;
            } else {
                fathers[v] = fu;
                rank[fu]++;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
