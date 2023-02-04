package daily;

import java.util.*;
import java.util.stream.IntStream;

public class P1129 {
    private static final int RED = 0;
    private static final int BLUE = 1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Step 1: build graph
        List<Integer>[][] graph = new List[2][n];
        for (int i = 0; i < n; i++) {
            graph[RED][i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            graph[BLUE][i] = new ArrayList<>();
        }

        for (int[] e : redEdges) {
            graph[RED][e[0]].add(e[1]);
        }
        for (int[] e : blueEdges) {
            graph[BLUE][e[0]].add(e[1]);
        }

        int[][] path = new int[2][n];
        Arrays.fill(path[RED], Integer.MAX_VALUE);
        Arrays.fill(path[BLUE], Integer.MAX_VALUE);
        path[RED][0] = 0;
        path[BLUE][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, RED});
        queue.offer(new int[] {0, BLUE});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            // current vertex X
            int vertex = p[0];
            // the edge color ends with X
            int color = p[1];
            // only to find different color edges next vertices
            for (int nv : graph[1 - color][vertex]) {
                if (path[1 - color][nv] != Integer.MAX_VALUE) {
                    // visited already
                    continue;
                }
                path[1 - color][nv] = path[color][vertex] + 1;
                queue.offer(new int[] {nv, 1 - color});
            }
        }
        return IntStream.range(0, n)
                .map(i -> {
                    int dist = Math.min(path[RED][i], path[BLUE][i]);
                    return dist == Integer.MAX_VALUE ? -1 : dist;
                }).toArray();
    }
}
