package daily;

import java.util.*;
import java.util.stream.IntStream;

public class P1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redGraph = buildGraph(n, redEdges);
        List<List<Integer>> blueGraph = buildGraph(n, blueEdges);

        int[] redAnswer = bfs(n, redGraph, blueGraph, 0);
        int[] blueAnswer = bfs(n, redGraph, blueGraph, 1);

        return IntStream.range(0, n).map(i -> {
            if (redAnswer[i] >= 0 && blueAnswer[i] >= 0) {
                return Math.min(redAnswer[i], blueAnswer[i]);
            } else if (redAnswer[i] == -1) {
                return blueAnswer[i];
            } else {
                return redAnswer[i];
            }
        }).toArray();
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }

        return graph;
    }

    private int[] bfs(int n, List<List<Integer>> redGraph, List<List<Integer>> blueGraph, int startColor) {
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        answer[0] = 0;
        visited[0] = true;
        int color = startColor;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<List<Integer>> graph = color == 0 ? redGraph : blueGraph;
            for (int nb : graph.get(v)) {
                if (!visited[nb] && v != nb) {
                    queue.offer(nb);
                    answer[nb] = answer[v] + 1;
                    visited[nb] = true;
                    color = 1 - color;
                }
            }
        }
        return answer;
    }
}
