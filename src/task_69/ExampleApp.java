package task_69;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (27.03.2026)
 */
public class ExampleApp {
    public static void main(String[] args) {
        int n = 4; // number of vertices (A=0, B=1, C=2, D=3)

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4)); // A-B
        edges.add(new Edge(0, 2, 3)); // A-C
        edges.add(new Edge(1, 2, 2)); // B-C
        edges.add(new Edge(1, 3, 5)); // B-D
        edges.add(new Edge(2, 3, 7)); // C-D

        int result = maxSpanningTree(n, edges);

        System.out.println("Maximum Spanning Tree weight = " + result);
    }

    public static int maxSpanningTree(int n, List<Edge> edges) {
        // sort in descending order
        edges.sort((a, b) -> b.weight - a.weight);

        DSU dsu = new DSU(n);
        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge e : edges) {
            if (dsu.find(e.u) != dsu.find(e.v)) {
                dsu.union(e.u, e.v);
                totalWeight += e.weight;
                edgesUsed++;

                System.out.println("Added edge: " + e.u + " - " + e.v + " (weight " + e.weight + ")");
            }

            // stop when V-1 edge
            if (edgesUsed == n - 1) break;
        }

        return totalWeight;
    }
}
