import java.util.Arrays;
import java.util.stream.IntStream;

public class DijkstraAlgorithm {
    public static int[] dijkstra(int[][] graph, int start) {
        final int n = graph.length;
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distance[start] = 0;
        int current = start;
        while (current != -1) {
            // Mark as current node as visited
            visited[current] = true;

            // Update the shortest distance for the nodes adjacent with current node
            final int base = distance[current];
            int[] neighbors = graph[current];
            for (int i = 0; i < n; i++) {
                if (neighbors[i] == -1) {
                    // Skip not adjacent node
                    continue;
                }
                if (base + neighbors[i] < distance[i]) {
                    distance[i] = base + neighbors[i];
                }
            }

            // Pick next current node
            int min = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (min == -1 || distance[min] > distance[i])) {
                    min = i;
                }
            }

            current = min;
        }

        return distance;
    }

    public static void main(String[] args) {
        String[] cities = {"Atlanta", "Boston", "Chicago", "Denver", "El Paso"};
        int[][] graph = {
                {0, 100, -1, 160, -1},
                {-1, 0, 120, 180, -1},
                {-1, -1, 0, -1, 80},
                {-1, -1, 40, 0, 140},
                {-1, 100, -1, -1, 0},
        };
        int start = 0;
        int[] shortestPath = dijkstra(graph, start);
        IntStream.range(start + 1, graph.length)
                .mapToObj(i -> "Shortest distance from " + cities[start] + " to " + cities[i] + ": " + shortestPath[i])
                .forEach(System.out::println);
    }
}
