package task_14;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.02.2026)
 */
// (O(n²))
public class LineIntersectionsNaive {
    public static int countIntersections(int[] p, int[] q) {
        int n = p.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((p[i] - p[j]) * (q[i] - q[j]) < 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 4};
        int[] q = {4, 3, 2, 1};

        System.out.println(countIntersections(p, q)); // 6
    }
}
