package task_87;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (14.04.2026)
 */
public class EgyptianFraction {

    public static void main(String[] args) {
        int a = 4;
        int b = 13;

        List<String> result = toEgyptianFraction(a, b);

        System.out.println("Egyptian Fraction:");
        System.out.println(String.join(" + ", result));
    }

    public static List<String> toEgyptianFraction(int a, int b) {
        List<String> result = new ArrayList<>();

        while (a != 0) {
            // Find ceiling of b / a
            int x = (b + a - 1) / a;

            result.add("1/" + x);

            // Update fraction: a/b - 1/x
            a = a * x - b;
            b = b * x;

            // Simplify fraction using GCD
            int gcd = gcd(a, b);
            a /= gcd;
            b /= gcd;
        }

        return result;
    }

    // Euclidean algorithm for GCD
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
