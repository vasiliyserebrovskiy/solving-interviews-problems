package task_16;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (15.02.2026)
 */
public class Task16App {
    public static void main(String[] args) {

        // Create Tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);

        // Create main object
        Solution solution = new Solution();

        // Run solution
        int[] result = solution.findFrequentTreeSum(root);

        // Print result
        System.out.println(Arrays.toString(result));

    }
}
