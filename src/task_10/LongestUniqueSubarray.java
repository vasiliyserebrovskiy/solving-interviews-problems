package task_10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (11.02.2026)
 */
public class LongestUniqueSubarray {
    public static int longestDistinctSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // If the current element is already there, move the left border.
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            }

            // Adding the current element to the Set
            set.add(nums[right]);

            // Updating the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 5, 2, 3, 4, 1};
        System.out.println("Longest distinct subarray length: " + longestDistinctSubarray(arr));
    }
}
