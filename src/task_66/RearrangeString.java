package task_66;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.03.2026)
 */
public class RearrangeString {

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String rearrange(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> b.count - a.count
        );

        for (char c : freq.keySet()) {
            maxHeap.add(new Pair(c, freq.get(c)));
        }

        StringBuilder result = new StringBuilder();
        Pair prev = null;

        while (!maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            result.append(curr.ch);
            curr.count--;

            // we return the previous character back
            if (prev != null && prev.count > 0) {
                maxHeap.add(prev);
            }

            prev = curr;
        }

        if (result.length() != s.length()) {
            return null;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(rearrange("aaabbc")); // пример
    }

}
