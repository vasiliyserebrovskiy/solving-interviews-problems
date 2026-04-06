package task_77;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (06.04.2026)
 */
public class Subscribers {
    private int[] tree;
    private int size;

    public Subscribers(int n) {
        this.size = n;
        this.tree = new int[n + 1]; // 1-based indexing
    }

    // update(hour, value)
    public void update(int index, int value) {
        index++; // convert to 1-based index

        while (index <= size) {
            tree[index] += value;
            index += index & (-index);
        }
    }

    // prefix sum [0..index]
    private int queryPrefix(int index) {
        index++; // convert to 1-based index
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }

        return sum;
    }

    // query(start, end)
    public int query(int start, int end) {
        return queryPrefix(end) - queryPrefix(start - 1);
    }

    // test
    public static void main(String[] args) {
        Subscribers subs = new Subscribers(24);

        subs.update(1, 5);  // hour 1 += 5
        subs.update(3, 10); // hour 3 += 10
        subs.update(5, 7);  // hour 5 += 7

        System.out.println(subs.query(1, 5)); // 22
        System.out.println(subs.query(3, 3)); // 10
    }
}
