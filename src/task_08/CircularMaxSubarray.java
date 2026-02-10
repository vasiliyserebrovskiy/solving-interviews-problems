package task_08;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.02.2026)
 */
public class CircularMaxSubarray {
    // Classic Kadane for maximum amount
    private static int kadaneMax(int[] arr) {
        int maxEndingHere = 0;
        int maxSoFar = 0; // since an empty subarray is allowed
        for (int num : arr) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Kadane for the minimum amount
    private static int kadaneMin(int[] arr) {
        int minEndingHere = 0;
        int minSoFar = 0;
        for (int num : arr) {
            minEndingHere = Math.min(num, minEndingHere + num);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return minSoFar;
    }

    public static int maxCircularSubarraySum(int[] arr) {
        int maxNormal = kadaneMax(arr);
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        int minSubarray = kadaneMin(arr);

        int maxWrap = totalSum - minSubarray;

        // if all the numbers are negative, it is better to choose an empty subarray.
        if (maxWrap == 0) return maxNormal;

        return Math.max(maxNormal, maxWrap);
    }

    public static void main(String[] args) {
        int[] arr1 = {8, -1, 3, 4};
        int[] arr2 = {-4, 5, 1, 0};

        System.out.println("Max circular sum (arr1): " + maxCircularSubarraySum(arr1)); // 15
        System.out.println("Max circular sum (arr2): " + maxCircularSubarraySum(arr2)); // 6
    }
}
