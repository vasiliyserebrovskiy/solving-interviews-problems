package task_61;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.03.2026)
 */
public class SmallestMissingSum {

    public static int findSmallest(int[] arr) {
        int res = 1;

        for (int num : arr) {
            if (num > res) {
                break;
            }
            res += num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10};
        System.out.println(findSmallest(arr)); // 7
    }

}
