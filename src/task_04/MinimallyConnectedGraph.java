package task_04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (03.02.2026)
 */
public class MinimallyConnectedGraph {
    // Checking for minimal connectivity
    public static boolean isMinimallyConnected(int n, List<List<Integer>> graph, int edgeCount) {
        // Step 1: Check the number of edges
        if (edgeCount != n - 1) {
            return false;
        }

        // Step 2: Check connectivity via DFS (DFS - Depth-First Search)
        boolean[] visited = new boolean[n];
        dfs(0, graph, visited);

        // If there is at least one unvisited vertex → disconnected graph
        for (boolean v : visited) {
            if (!v) return false;
        }

        // Everything is checked → minimally connected
        return true;
    }

    // DFS bypass
    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // number of vertices
        int edgeCount = 4; // number of edges
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Example of a graph (tree)
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        System.out.println("Is minimally connected? " + isMinimallyConnected(n, graph, edgeCount));
    }
}
