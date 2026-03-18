package task_60;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.03.2026)
 */
public class Josephus {

    public static int findSurvivor(int n, int k) {
        int result = 0; // f(1, k) = 0

        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }

        return result + 1; // transfer to 1-based
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(findSurvivor(n, k)); // 3
    }

}
