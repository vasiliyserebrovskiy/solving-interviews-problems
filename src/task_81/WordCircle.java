package task_81;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.04.2026)
 */
public class WordCircle {

    static final int ALPHABET_SIZE = 26;

    public static boolean canFormCircle(String[] words) {
        int[] inDegree = new int[ALPHABET_SIZE];
        int[] outDegree = new int[ALPHABET_SIZE];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            graph.add(new ArrayList<>());
        }

        // Building a graph
        for (String word : words) {
            int first = word.charAt(0) - 'a';
            int last = word.charAt(word.length() - 1) - 'a';

            outDegree[first]++;
            inDegree[last]++;

            graph.get(first).add(last);
        }

        // Checking degrees
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (inDegree[i] != outDegree[i]) {
                return false;
            }
        }

        // Checking connectivity
        return isConnected(graph, words);
    }

    private static boolean isConnected(List<List<Integer>> graph, String[] words) {
        boolean[] visited = new boolean[ALPHABET_SIZE];

        // Find the starting point
        int start = -1;
        for (String word : words) {
            start = word.charAt(0) - 'a';
            break;
        }

        dfs(graph, start, visited);

        // Checking whether all vertices with edges have been visited
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (!graph.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;

        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"chair", "height", "racket", "touch", "tunic"};

        System.out.println(canFormCircle(words)); // true
    }

}
