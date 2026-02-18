package task_22;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.02.2026)
 */
public class ReconstructBSTOptimized {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int index;

    public static void main(String[] args) {

        int[] postorder = {2, 4, 3, 8, 7, 5};

        TreeNode root = buildTree(postorder);

        System.out.println("Inorder traversal (should be sorted):");
        printInorder(root);

        System.out.println("\n\nPostorder traversal (should match input):");
        printPostorder(root);
    }

    public static TreeNode buildTree(int[] postorder) {
        index = postorder.length - 1;
        return build(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode build(int[] postorder, int min, int max) {

        if (index < 0) {
            return null;
        }

        int value = postorder[index];

        // If the value is outside the acceptable range, we don't build it.
        if (value < min || value > max) {
            return null;
        }

        // Creating a node
        TreeNode root = new TreeNode(value);
        index--;

        // First, we build the right subtree
        root.right = build(postorder, value, max);

        // Then the left one
        root.left = build(postorder, min, value);

        return root;
    }

    // ===== Check =====
    // ===== Inorder =====
    public static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // ===== Postorder =====
    public static void printPostorder(TreeNode root) {
        if (root == null) return;

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

}
