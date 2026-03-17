package task_56;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.03.2026)
 */
public class SevenishNumber {
    public static int getSevenish(int n) {
        int result = 0;
        int power = 1; // 7^0

        while (n > 0) {
            // if the last bit = 1
            if ((n & 1) == 1) {
                result += power;
            }

            // moving on to the next power of 7
            power *= 7;

            // shifting the bits
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " -> " + getSevenish(i));
        }
    }
}
