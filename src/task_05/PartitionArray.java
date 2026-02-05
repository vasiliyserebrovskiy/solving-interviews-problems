package task_05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.02.2026)
 */
public class PartitionArray {
    public static void main(String[] args) {
        int[] nums = {5, 10, 15, 20, 25};
        partition(nums);
    }

    static void partition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: the sum of 0 is always achievable
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Filling in the DP
        for (int i = 1; i <= n; i++) {
            int current = nums[i - 1];
            for (int s = 1; s <= target; s++) {
                dp[i][s] = dp[i - 1][s]; // не берём элемент

                if (s >= current) {
                    dp[i][s] = dp[i][s] || dp[i - 1][s - current];
                }
            }
        }

        // Looking for the best amount in target
        int best = 0;
        for (int s = target; s >= 0; s--) {
            if (dp[n][s]) {
                best = s;
                break;
            }
        }

        // Restoring a subset
        List<Integer> subset1 = new ArrayList<>();
        boolean[] used = new boolean[n];

        int s = best;
        for (int i = n; i > 0 && s > 0; i--) {
            if (!dp[i - 1][s]) {
                subset1.add(nums[i - 1]);
                used[i - 1] = true;
                s -= nums[i - 1];
            }
        }

        List<Integer> subset2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                subset2.add(nums[i]);
            }
        }

        System.out.println("Subset 1: " + subset1);
        System.out.println("Subset 2: " + subset2);
        System.out.println("Difference: " +
                Math.abs((totalSum - best) - best));
    }
}
