package task_58;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.03.2026)
 */
public class MorrisTraversal {

    public static void inorderMorris(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // if there is no left → output and go to the right
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                // looking for a predecessor
                TreeNode pred = current.left;
                while (pred.right != null && pred.right != current) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // creating a temporary link to current
                    pred.right = current;
                    current = current.left;
                } else {
                    // the left subtree has already been processed
                    pred.right = null; // remove link
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        // create a test tree
        //        4
        //      /   \
        //     2     5
        //    / \
        //   1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("In-order traversal using Morris Traversal:");
        inorderMorris(root);  // Output: 1 2 3 4 5
    }

}
