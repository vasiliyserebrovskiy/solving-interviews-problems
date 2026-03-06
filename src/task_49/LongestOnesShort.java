package task_49;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.03.2026)
 */
public class LongestOnesShort {

    public static int longestRun(int n) {

        int count = 0;

        while (n != 0) {
            n = n & (n << 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(156)); // 3
    }

}
