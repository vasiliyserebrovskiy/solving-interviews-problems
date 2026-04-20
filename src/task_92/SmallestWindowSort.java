package task_92;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (20.04.2026)
 */
public class SmallestWindowSort {

    public static int[] findWindow(int[] arr) {
        int n = arr.length;

        // Step 1: find left boundary
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If already sorted
        if (left == n - 1) {
            return new int[]{-1, -1};
        }

        // Step 2: find right boundary
        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // Step 3: find min and max in window
        int windowMin = Integer.MAX_VALUE;
        int windowMax = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            windowMin = Math.min(windowMin, arr[i]);
            windowMax = Math.max(windowMax, arr[i]);
        }

        // Step 4: expand left boundary
        while (left > 0 && arr[left - 1] > windowMin) {
            left--;
        }

        // Step 5: expand right boundary
        while (right < n - 1 && arr[right + 1] < windowMax) {
            right++;
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 6, 9};

        int[] result = findWindow(arr);

        System.out.println("(" + result[0] + ", " + result[1] + ")");
        // Expected: (1, 3)
    }

}
