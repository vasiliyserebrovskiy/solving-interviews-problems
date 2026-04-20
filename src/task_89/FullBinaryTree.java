package task_89;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (20.04.2026)
 */
public class FullBinaryTree {

    public static TreeNode convertToFull(TreeNode root) {
        // 1. Basic case
        if (root == null) {
            return null;
        }

        // 2. Recursively processing children
        root.left = convertToFull(root.left);
        root.right = convertToFull(root.right);

        // 3. If it's a sheet, leave it
        if (root.left == null && root.right == null) {
            return root;
        }

        // 4. If one child is missing, delete the node.
        if (root.left == null) {
            return root.right;
        }

        if (root.right == null) {
            return root.left;
        }

        // 5. If both are there, we leave them
        return root;
    }

    // For Test
    public static void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        /*
             0
          /     \
        1         2
       /            \
      3              4
       \           /   \
        5         6     7
        */

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(5);

        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        root = convertToFull(root);

        printPreorder(root); // ожидаем: 0 5 4 6 7
    }

}
