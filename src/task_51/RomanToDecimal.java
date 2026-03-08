package task_51;

import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (08.03.2026)
 */
public class RomanToDecimal {

    public static int convert(String s) {

        Map<Character, Integer> values = Map.of(
                'M', 1000,
                'D', 500,
                'C', 100,
                'L', 50,
                'X', 10,
                'V', 5,
                'I', 1
        );

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = values.get(s.charAt(i));

            if (i < s.length() - 1) {
                int next = values.get(s.charAt(i + 1));

                if (current < next) {
                    sum -= current;
                } else {
                    sum += current;
                }
            } else {
                sum += current;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(convert("XIV")); // 14
    }

}
