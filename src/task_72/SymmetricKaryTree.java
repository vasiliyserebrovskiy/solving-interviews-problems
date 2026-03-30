package task_72;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (30.03.2026)
 */
public class SymmetricKaryTree {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        /*
                4
              / | \
            3   5   3
          /           \
         9             9
        */

        Node root = new Node(4);

        Node left = new Node(3);
        Node middle = new Node(5);
        Node right = new Node(3);

        root.children = Arrays.asList(left, middle, right);

        left.children = Arrays.asList(new Node(9));
        middle.children = new ArrayList<>();
        right.children = Arrays.asList(new Node(9));

        System.out.println(isSymmetric(root)); // true
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isMirror(root.children);
    }

    private static boolean isMirror(List<Node> children) {
        int left = 0;
        int right = children.size() - 1;

        while (left <= right) {
            Node a = children.get(left);
            Node b = children.get(right);

            if (!isMirrorNodes(a, b)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isMirrorNodes(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        if (a.children.size() != b.children.size()) return false;

        int left = 0;
        int right = a.children.size() - 1;

        while (left <= right) {
            if (!isMirrorNodes(a.children.get(left), b.children.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
