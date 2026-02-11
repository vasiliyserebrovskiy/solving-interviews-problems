package task_09;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (11.02.2026)
 */
public class JumpGame {
    public static boolean canReachEnd(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // If the current position is out of reach, that's it, you're stuck.
            if (i > maxReach) {
                return false;
            }

            // Updating the maximum achievable position
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can already reach the end, we can immediately return true.
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 1, 2, 0, 1};
        int[] arr2 = {1, 2, 1, 0, 0};

        System.out.println(canReachEnd(arr1)); // true
        System.out.println(canReachEnd(arr2)); // false
    }
}
