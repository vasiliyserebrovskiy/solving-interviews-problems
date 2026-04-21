package task_95;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (21.04.2026)
 */
public class ReconstructSequence {

    public static int[] reconstruct(String[] signs) {
        int n = signs.length;
        int[] result = new int[n];

        // Fill with 0..n-1
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }

        int i = 0;

        while (i < n) {
            if (signs[i] == null || signs[i].equals("+")) {
                i++;
                continue;
            }

            // Start of '-' sequence
            int start = i - 1;

            while (i < n && signs[i].equals("-")) {
                i++;
            }

            int end = i - 1;

            // Reverse subarray
            reverse(result, start, end);
        }

        return result;
    }

    private static void reverse(int[] arr, int l, int r) {
        // standard two-pointer reverse
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String[] signs = {null, "+", "+", "-", "+"};

        int[] result = reconstruct(signs);

        System.out.println(Arrays.toString(result));
    }

}
