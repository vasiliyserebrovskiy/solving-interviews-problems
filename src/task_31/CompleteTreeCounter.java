package task_31;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.02.2026)
 */
public class CompleteTreeCounter {
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // If the heights are equal, this is a perfect tree.
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        // otherwise, we go recursively
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private static int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
