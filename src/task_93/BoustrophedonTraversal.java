package task_93;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (21.04.2026)
 */
public class BoustrophedonTraversal {

    public static List<Integer> zigzag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            result.addAll(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        /*
               1
            /     \
          2         3
         / \       / \
        4   5     6   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = zigzag(root);

        System.out.println(result);
    }

}
