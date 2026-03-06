package task_49;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.03.2026)
 */
public class LongestOnes {

    public static int longestRun(int n) {

        int maxRun = 0;
        int currentRun = 0;

        while (n > 0) {

            if ((n & 1) == 1) {
                currentRun++;
                maxRun = Math.max(maxRun, currentRun);
            } else {
                currentRun = 0;
            }

            n = n >> 1;
        }

        return maxRun;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(156)); // 3
    }

}
