package task_76;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (02.04.2026)
 */
public class HIndex {

    public static void main(String[] args) {
        int[] citations = {4, 3, 0, 1, 5};
        System.out.println("H-index: " + hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations); // ascending order

        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papersWithAtLeastThisMany = n - i;

            if (citations[i] >= papersWithAtLeastThisMany) {
                h = papersWithAtLeastThisMany;
                break;
            }
        }

        return h;
    }

}
