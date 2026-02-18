package task_22;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.02.2026)
 */
public class ReconstructBSTFromPostorder {
    // ====== Node definition ======
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ====== Build tree (O(n^2) version) ======
    public static TreeNode buildTree(int[] postorder) {
        return build(postorder, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] postorder, int start, int end) {

        if (start > end) {
            return null;
        }

        int rootValue = postorder[end];
        TreeNode root = new TreeNode(rootValue);

        if (start == end) {
            return root;
        }

        // Find the border: where the elements > root
        int splitIndex = start;

        while (splitIndex < end && postorder[splitIndex] < rootValue) {
            splitIndex++;
        }

        root.left = build(postorder, start, splitIndex - 1);
        root.right = build(postorder, splitIndex, end - 1);

        return root;
    }

    // ====== Inorder print (should be sorted for BST) ======
    public static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // ====== Postorder print (should match original) ======
    public static void printPostorder(TreeNode root) {
        if (root == null) return;

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    // ====== Main method ======
    public static void main(String[] args) {

        int[] postorder = {2, 4, 3, 8, 7, 5};

        TreeNode root = buildTree(postorder);

        System.out.println("Inorder traversal (should be sorted):");
        printInorder(root);

        System.out.println("\n\nPostorder traversal (should match input):");
        printPostorder(root);
    }
}
