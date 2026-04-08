package task_80;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (08.04.2026)
 */
public class JumpGame {

    public static int minJumps(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 4, 0, 5, 1, 1, 4, 2, 9};
        System.out.println(minJumps(nums)); // 2
    }

}
