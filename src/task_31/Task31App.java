package task_31;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.02.2026)
 */
public class Task31App {
    /* Example Tree
        1
      /   \
     2     3
    / \   /
   4   5 6
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        int result = CompleteTreeCounter.countNodes(root);

        System.out.println("Total nodes: " + result);
    }
}
