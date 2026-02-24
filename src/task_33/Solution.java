package task_33;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (24.02.2026)
 */
public class Solution {

    public static void main(String[] args) {
        int myInt = 48975;
        System.out.println("Next permutation for " + myInt + " is: " + nextPermutation(myInt));
    }

    public static int nextPermutation(int num) {

        char[] digits = String.valueOf(num).toCharArray();

        // 1. Find pivot
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If the pivot is not found - > there is no next permutation
        if (i < 0) {
            return -1;
        }

        // 2. Find next greater element
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // 3. Swap
        swap(digits, i, j);

        // 4. Reverse suffix
        reverse(digits, i + 1, digits.length - 1);

        return Integer.parseInt(new String(digits));
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
}
