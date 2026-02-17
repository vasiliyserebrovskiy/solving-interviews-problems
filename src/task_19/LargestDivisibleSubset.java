package task_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.02.2026)
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 10, 20, 21};
        int[] arr2 = {1, 3, 6, 24};

        System.out.println("Initial array: " + Arrays.toString(arr1));
        System.out.println("Result: " + largestDivisibleSubset(arr1));
        System.out.println("=====");
        System.out.println("Initial array: " + Arrays.toString(arr2));
        System.out.println("Result: " + largestDivisibleSubset(arr2));
    }

    public static List<Integer> largestDivisibleSubset(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        int n = arr.length;
        Arrays.sort(arr);   // We must sort our array first.

        int[] dp = new int[n];      // Create array for saving length of our subset
        int[] prev = new int[n];    // to restore the path

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int maxIndex = 0;

        // build DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] % arr[j] == 0) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        // restoring the result
        List<Integer> result = new ArrayList<>();

        while (maxIndex != -1) {
            result.add(arr[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(result); // Because we are coming from the end

        return result;
    }
}
