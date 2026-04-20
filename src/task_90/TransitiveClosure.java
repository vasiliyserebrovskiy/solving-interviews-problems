package task_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (20.04.2026)
 */
public class TransitiveClosure {

    public static int[][] transitiveClosure(List<List<Integer>> graph) {
        int n = graph.size();
        int[][] result = new int[n][n];

        // Run DFS from every node
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(graph, i, visited);

            // Fill result matrix
            for (int j = 0; j < n; j++) {
                result[i][j] = visited[j] ? 1 : 0;
            }
        }

        return result;
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        // Mark current node as visited
        visited[node] = true;

        // Visit all neighbors
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    // Helper method to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(Arrays.asList(0, 1, 3));
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(2));
        graph.add(Arrays.asList(3));

        int[][] closure = transitiveClosure(graph);
        printMatrix(closure);
    }

}
