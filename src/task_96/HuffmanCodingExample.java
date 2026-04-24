package task_96;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (24.04.2026)
 */
public class HuffmanCodingExample {

    // Node of Huffman Tree
    static class Node {
        char ch;        // character (only for leaf nodes)
        int freq;       // frequency
        Node left;
        Node right;

        // Constructor for leaf node
        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        // Constructor for internal node
        Node(int freq, Node left, Node right) {
            this.ch = '\0'; // no character
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        // Step 1: Input frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('a', 5);
        freqMap.put('b', 2);
        freqMap.put('c', 1);
        freqMap.put('d', 1);

        // Step 2: Build Huffman Tree
        Node root = buildHuffmanTree(freqMap);

        // Step 3: Generate codes
        Map<Character, String> codes = new HashMap<>();
        buildCodes(root, "", codes);

        // Step 4: Print results
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Build Huffman Tree using Min Heap
    private static Node buildHuffmanTree(Map<Character, Integer> freqMap) {

        // PriorityQueue = Min Heap based on frequency
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.freq - b.freq
        );

        // Step 1: Add all characters as leaf nodes
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Step 2: Build the tree
        while (pq.size() > 1) {

            // Take two nodes with smallest frequency
            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new internal node with combined frequency
            Node parent = new Node(
                    left.freq + right.freq,
                    left,
                    right
            );

            // Add back to the queue
            pq.add(parent);
        }

        // Root of the tree
        return pq.poll();
    }

    // Traverse the tree and assign binary codes
    private static void buildCodes(Node node, String code, Map<Character, String> result) {

        if (node == null) return;

        // If leaf node → store the code
        if (node.left == null && node.right == null) {

            // Edge case: single character
            if (code.length() == 0) {
                result.put(node.ch, "0");
            } else {
                result.put(node.ch, code);
            }
            return;
        }

        // Traverse left → add '0'
        buildCodes(node.left, code + "0", result);

        // Traverse right → add '1'
        buildCodes(node.right, code + "1", result);
    }

}
