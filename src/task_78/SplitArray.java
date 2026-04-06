package task_78;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (06.04.2026)
 */
public class SplitArray {

    public static int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        for (int num : nums) {
            left = Math.max(left, num); // max element
            right += num;              // total sum
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;

                if (count > k) return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 7, 3, 4};
        int k = 3;

        System.out.println(splitArray(nums, k)); // 8
    }

}
