package task_53;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (09.03.2026)
 */
public class ReverseGraph {

    public static Map<String, List<String>> reverseGraph(Map<String, List<String>> graph) {

        Map<String, List<String>> reversed = new HashMap<>();

        // creating vertexes
        for (String node : graph.keySet()) {
            reversed.put(node, new ArrayList<>());
        }

        // unfolding the edges
        for (String u : graph.keySet()) {
            for (String v : graph.get(u)) {
                reversed.get(v).add(u);
            }
        }

        return reversed;
    }

    public static void main(String[] args) {

        Map<String, List<String>> graph = new HashMap<>();

        graph.put("A", Arrays.asList("B"));
        graph.put("B", Arrays.asList("C"));
        graph.put("C", new ArrayList<>());

        Map<String, List<String>> reversed = reverseGraph(graph);

        System.out.println(reversed);
    }

}
