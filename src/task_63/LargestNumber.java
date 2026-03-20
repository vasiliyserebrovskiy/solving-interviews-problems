package task_63;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (20.03.2026)
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] arr = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // edge case: если все нули
        if (arr[0].equals("0")) return "0";

        return String.join("", arr);
    }

    public static void main(String[] args) {
        int[] nums = {10, 7, 76, 415};
        System.out.println(largestNumber(nums)); // 77641510
    }

}
