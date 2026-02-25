package task_36;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (25.02.2026)
 */
public class Solution1App {
    public static <T> T[] applyPermutation(T[] arr, int[] P) {

        if (arr.length != P.length) {
            throw new IllegalArgumentException("Lengths must match");
        }

        T[] result = arr.clone();

        for (int i = 0; i < arr.length; i++) {
            result[P[i]] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {

        String[] arr = {"a", "b", "c"};
        int[] P = {2, 1, 0};

        String[] result = applyPermutation(arr, P);

        System.out.println(Arrays.toString(result));
    }
}
