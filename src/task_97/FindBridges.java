package task_97;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (24.04.2026)
 */
public class FindBridges {

    private int time = 0;

    public static void main(String[] args) {

        int n = 5; // number of nodes

        // Graph as adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 0);
        addEdge(graph, 1, 3);
        addEdge(graph, 3, 4);

        FindBridges solver = new FindBridges();
        List<List<Integer>> bridges = solver.findBridges(graph, n);

        System.out.println("Bridges:");
        for (List<Integer> edge : bridges) {
            System.out.println(edge.get(0) + " - " + edge.get(1));
        }
    }

    // Add undirected edge
    private static void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public List<List<Integer>> findBridges(List<List<Integer>> graph, int n) {

        int[] disc = new int[n]; // discovery time
        int[] low = new int[n];  // low-link values
        boolean[] visited = new boolean[n];

        List<List<Integer>> result = new ArrayList<>();

        // Run DFS from every node (in case graph is not connected)
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, graph, visited, disc, low, result);
            }
        }

        return result;
    }

    private void dfs(int u, int parent,
                     List<List<Integer>> graph,
                     boolean[] visited,
                     int[] disc,
                     int[] low,
                     List<List<Integer>> result) {

        visited[u] = true;

        // Set discovery time and low value
        disc[u] = low[u] = time++;

        for (int v : graph.get(u)) {

            // Skip the edge to parent
            if (v == parent) continue;

            if (!visited[v]) {

                dfs(v, u, graph, visited, disc, low, result);

                // Update low[u] using child
                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }

            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

}
