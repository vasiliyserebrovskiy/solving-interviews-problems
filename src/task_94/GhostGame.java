package task_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (21.04.2026)
 */
public class GhostGame {

    // Build Trie
    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }

        return root;
    }

    // Minimax DFS
    public static boolean isWinning(TrieNode node) {
        // If this node completes a word → losing position
        if (node.isWord) {
            return false;
        }

        // If no moves → losing position
        if (node.children.isEmpty()) {
            return false;
        }

        // Try all possible moves
        for (TrieNode child : node.children.values()) {
            // If opponent loses → we win
            if (!isWinning(child)) {
                return true;
            }
        }

        // All moves lead to opponent win → we lose
        return false;
    }

    public static List<Character> winningStarts(String[] words) {
        TrieNode root = buildTrie(words);
        List<Character> result = new ArrayList<>();

        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            char c = entry.getKey();
            TrieNode node = entry.getValue();

            if (isWinning(node)) {
                result.add(c);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] dictionary = {"cat", "calf", "dog", "bear"};

        List<Character> result = winningStarts(dictionary);

        System.out.println(result);
    }

}
