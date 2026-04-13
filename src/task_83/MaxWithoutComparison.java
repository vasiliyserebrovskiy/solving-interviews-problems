package task_83;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.04.2026)
 */
public class MaxWithoutComparison {

    // Returns 1 if x >= 0, else 0
    private static int sign(int x) {
        return (x >> 31) & 1;
    }

    public static int max(int a, int b) {
        int sa = sign(a);        // sign of a
        int sb = sign(b);        // sign of b
        int diff = a - b;
        int sd = sign(diff);     // sign of a - b

        int useSignOfA = sa ^ sb;     // 1 if signs differ
        int useSignOfDiff = useSignOfA ^ 1; // 1 if signs same

        int k = useSignOfA * sa + useSignOfDiff * sd;

        // If k = 0 → return a
        // If k = 1 → return b
        return a * (1 - k) + b * k;
    }

    public static void main(String[] args) {
        System.out.println(max(5, 10));     // 10
        System.out.println(max(10, 5));     // 10
        System.out.println(max(-5, -10));   // -5
        System.out.println(max(-10, 5));    // 5
    }
}

