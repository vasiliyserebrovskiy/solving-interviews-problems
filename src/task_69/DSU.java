package task_69;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (27.03.2026)
 */
public class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}
