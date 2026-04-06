package task_75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (02.04.2026)
 */
public class CouplesUnionFind {

    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        System.out.println("Minimum swaps: " + minSwapsCouples(row));
    }

    public static int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);

        // combining pairs
        for (int i = 0; i < row.length; i += 2) {
            int a = row[i] / 2;
            int b = row[i + 1] / 2;
            uf.union(a, b);
        }

        // counting the component sizes
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            count.put(root, count.getOrDefault(root, 0) + 1);
        }

        int swaps = 0;

        for (int size : count.values()) {
            swaps += size - 1;
        }

        return swaps;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return;

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

}
