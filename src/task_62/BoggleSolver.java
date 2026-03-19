package task_62;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.03.2026)
 */
public class BoggleSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'B', 'O', 'G', 'G'},
                {'L', 'E', 'A', 'R'},
                {'T', 'E', 'S', 'T'},
                {'X', 'Y', 'Z', 'W'}
        };

        String[] words = {"BOGGLE", "TEST", "BOG", "LEARN"};

        BoggleSolver solver = new BoggleSolver();
        List<String> result = solver.findWords(board, words);

        System.out.println("Found words:");
        for (String word : result) {
            System.out.println(word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        Set<String> result = new HashSet<>();

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, visited, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node,
                     boolean[][] visited, Set<String> result) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        if (visited[i][j]) return;

        char c = board[i][j];
        if (!node.children.containsKey(c)) return;

        node = node.children.get(c);

        if (node.word != null) {
            result.add(node.word);
        }

        visited[i][j] = true;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    dfs(board, i + dx, j + dy, node, visited, result);
                }
            }
        }

        visited[i][j] = false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.word = word;
        }

        return root;
    }

}
