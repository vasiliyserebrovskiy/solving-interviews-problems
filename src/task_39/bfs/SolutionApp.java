package task_39.bfs;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (26.02.2026)
 */
public class SolutionApp {

    public static void main(String[] args) {

        List<List<Integer>> graphA = new ArrayList<>();

        graphA.add(Arrays.asList(1, 3)); // 0
        graphA.add(Arrays.asList(0, 2)); // 1
        graphA.add(Arrays.asList(1, 3)); // 2
        graphA.add(Arrays.asList(0, 2)); // 3

        System.out.println("Is graph A bipartite: " + isBipartite(graphA));
        System.out.println("=====");

        List<List<Integer>> graphB = new ArrayList<>();
        graphB.add(Arrays.asList(1, 2)); // 0
        graphB.add(Arrays.asList(0, 2)); // 1
        graphB.add(Arrays.asList(0, 1)); // 2

        System.out.println("Is graph B bipartite: " + isBipartite(graphB));
    }

    static boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();
        int[] color = new int[n];

        // -1 = did not color
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neighbor : graph.get(node)) {

                        if (color[neighbor] == -1) {
                            // we paint in the opposite color
                            color[neighbor] = 1 - color[node];
                            queue.add(neighbor);
                        }
                        else if (color[neighbor] == color[node]) {
                            return false; // conflict
                        }
                    }
                }
            }
        }

        return true;
    }
}
