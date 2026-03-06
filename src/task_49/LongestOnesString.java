package task_49;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.03.2026)
 */
public class LongestOnesString {

    public static int longestRun(int n) {

        String binary = Integer.toBinaryString(n);

        int maxRun = 0;
        int currentRun = 0;

        for (char c : binary.toCharArray()) {

            if (c == '1') {
                currentRun++;
                maxRun = Math.max(maxRun, currentRun);
            } else {
                currentRun = 0;
            }

        }

        return maxRun;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(156)); // 3
    }

}
