package task_37;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (25.02.2026)
 */
public class SolutionApp {
    public static List<String> shortestTransformation(
            String start,
            String end,
            Set<String> dictionary) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (current.equals(end)) {
                return buildPath(parent, start, end);
            }

            for (String neighbour : getNeighbours(current, dictionary)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                    parent.put(neighbour, current);
                }
            }
        }

        return null;
    }

    private static List<String> buildPath(
            Map<String, String> parent,
            String start,
            String end) {

        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    private static List<String> getNeighbours(
            String word,
            Set<String> dict) {

        List<String> neighbours = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {

                if (c == original) continue;

                chars[i] = c;
                String newWord = new String(chars);

                if (dict.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }

            chars[i] = original;
        }

        return neighbours;
    }

    public static void main(String[] args) {

        Set<String> dict = new HashSet<>(
                Arrays.asList("dot", "dop", "dat", "cat"));

        List<String> result =
                shortestTransformation("dog", "cat", dict);

        System.out.println(result);
        System.out.println("=====");

        Set<String> dict2 = new HashSet<>(
                Arrays.asList("dot", "tod", "dat", "dar"));

        List<String> result2 =
                shortestTransformation("dog", "cat", dict2);

        System.out.println(result2);
    }
}
