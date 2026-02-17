package task_18;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.02.2026)
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 2;

        solution(arr, k);

    }

    private static void solution(int[] arr, int k) {
        System.out.println("Our initial array: " + Arrays.toString(arr));
        // Step 1: revers our array
        reverse(arr, 0, arr.length - 1);
        //System.out.println("Reverse array: " + Arrays.toString(arr));

        // Step 2: revers first k elements back
        reverse(arr, 0, k);
        //System.out.println("Reverse first k element to normal: " + Arrays.toString(arr));

        // Step 3: revers other element after k to normal
        reverse(arr, k+1, arr.length - 1);
        //System.out.println("Reverse second k element to normal: " + Arrays.toString(arr));
        System.out.println("===============");
        System.out.println("Final result array: " + Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }

    }
}
