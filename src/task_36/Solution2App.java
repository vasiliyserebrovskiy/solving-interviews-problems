package task_36;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (25.02.2026)
 */
public class Solution2App {
    public static <T> void applyPermutationInPlace(T[] arr, int[] P) {

        for (int i = 0; i < arr.length; i++) {

            int next = i;

            while (P[next] != next) {

                int target = P[next];

                // swap arr[next] and arr[target]
                T temp = arr[next];
                arr[next] = arr[target];
                arr[target] = temp;

                // swap P[next] and P[target]
                int tempP = P[next];
                P[next] = P[target];
                P[target] = tempP;
            }
        }
    }

    public static void main(String[] args) {

        String[] arr = {"a", "b", "c"};
        int[] P = {2, 1, 0};

        applyPermutationInPlace(arr, P);

        System.out.println(Arrays.toString(arr));
    }
}
