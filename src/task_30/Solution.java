package task_30;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.02.2026)
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 7, 10, 3, 4};
        int[] arr2 = {5, 7, 2, 4};
        int[] arr3 = {5, 7, 1 };
        int[] arr4 = {5, 1, 2, 3, 4};


        System.out.println("We have an array: " + Arrays.toString(arr));
        System.out.println("Minimum element in arr: "+findMin(arr));
        System.out.println("We have an array: " + Arrays.toString(arr2));
        System.out.println("Minimum element in arr2: "+findMin(arr2));
        System.out.println("We have an array: " + Arrays.toString(arr3));
        System.out.println("Minimum element in arr3: "+findMin(arr3));
        System.out.println("We have an array: " + Arrays.toString(arr4));
        System.out.println("Minimum element in arr4: "+findMin(arr4));
    }

    static int findMin(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // min element is on the right from mid
                left = mid + 1;
            } else {
                // mid could be min
                right = mid;
            }
        }

        return arr[left];
    }
}
