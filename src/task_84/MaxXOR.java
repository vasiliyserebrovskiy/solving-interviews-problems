package task_84;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.04.2026)
 */
public class MaxXOR {

    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        // Step 1: build Trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }

                node = node.children[bit];
            }
        }

        int max = 0;

        // Step 2: find best XOR
        for (int num : nums) {
            TrieNode node = root;
            int currentXor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = bit ^ 1;

                // Try to go opposite direction for max XOR
                if (node.children[opposite] != null) {
                    currentXor |= (1 << i);
                    node = node.children[opposite];
                } else {
                    node = node.children[bit];
                }
            }

            max = Math.max(max, currentXor);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums)); // 28
    }
}
