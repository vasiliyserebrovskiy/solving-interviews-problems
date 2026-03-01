package task_44;

import java.util.HashMap;
import java.util.Map;

public class CollatzWithCash {

    private static Map<Long, Integer> cache = new HashMap<>();

    public static int collatzLength(long n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long original = n;
        int length = 1;

        while (n != 1) {

            if (cache.containsKey(n)) {
                length += cache.get(n) - 1;
                break;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }

            length++;
        }

        cache.put(original, length);
        return length;
    }

    public static void main(String[] args) {

        cache.put(1L, 1);

        int maxLength = 0;
        int numberWithMax = 0;

        for (int i = 1; i <= 1_000_000; i++) {
            int length = collatzLength(i);

            if (length > maxLength) {
                maxLength = length;
                numberWithMax = i;
            }
        }

        System.out.println("Max length: " + maxLength);
        System.out.println("Number: " + numberWithMax);
    }

}
