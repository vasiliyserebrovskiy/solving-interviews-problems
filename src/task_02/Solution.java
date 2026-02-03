package task_02;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (03.02.2026)
 */
public class Solution {
    // GCD — Greatest Common Divisor

    //use Euclid's algorithm for two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // Go through array using gcd
    public static int gcdArray(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {42, 56, 14};
        System.out.println("GCD: " + gcdArray(numbers)); // GCD: 14
    }
}
