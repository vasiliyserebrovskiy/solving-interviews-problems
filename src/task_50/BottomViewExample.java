package task_50;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (06.03.2026)
 */
public class BottomViewExample {
    public static List<Integer> bottomView(Node root) {

        if (root == null) return new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            // перезаписываем значение — сохраняется самый нижний узел
            map.put(hd, node.value);

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        /*
                 5
              /     \
            3         7
          /  \      /   \
        1     4    6     9
       /                /
      0                8
        */

        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(9);

        root.left.left.left = new Node(0);

        root.right.right.left = new Node(8);

        List<Integer> result = bottomView(root);

        System.out.println(result);
    }
}
