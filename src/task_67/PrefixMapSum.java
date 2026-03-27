package task_67;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (25.03.2026)
 */
public class PrefixMapSum {

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int sum = 0;
    }

    private TrieNode root;
    private Map<String, Integer> map;

    public PrefixMapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int value) {
        int delta = value - map.getOrDefault(key, 0);
        map.put(key, value);

        TrieNode node = root;

        for (char c : key.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.sum += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return 0;
            }
            node = node.children.get(c);
        }

        return node.sum;
    }

}
