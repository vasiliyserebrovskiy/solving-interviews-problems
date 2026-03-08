package task_52;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (08.03.2026)
 */
public class FindNextSparse {
    public static void main(String[] args) {
        int current = 22;

        System.out.printf("Next spare greater than %d is %d\n", current, nextSparse(current));
    }

    public static int nextSparse(int n) {

        int[] bits = new int[32];
        int size = 0;

        while (n > 0) {
            bits[size++] = n & 1;
            n >>= 1;
        }

        bits[size++] = 0;

        int lastFinal = 0;

        for (int i = 1; i < size - 1; i++) {

            if (bits[i] == 1 && bits[i - 1] == 1 && bits[i + 1] != 1) {

                bits[i + 1] = 1;

                for (int j = i; j >= lastFinal; j--) {
                    bits[j] = 0;
                }

                lastFinal = i + 1;
            }
        }

        int result = 0;

        for (int i = 0; i < size; i++) {
            result += bits[i] * (1 << i);
        }

        return result;
    }
}
