package task_75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (02.04.2026)
 */
public class CouplesHoldingHands {

    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        System.out.println("Minimum swaps: " + minSwapsCouples(row));
    }

    public static int minSwapsCouples(int[] row) {
        int swaps = 0;

        // value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }

        for (int i = 0; i < row.length; i += 2) {
            int first = row[i];
            int partner = first ^ 1;

            if (row[i + 1] != partner) {
                swaps++;

                int partnerIndex = map.get(partner);

                // swap row[i+1] and partner
                int temp = row[i + 1];
                row[i + 1] = row[partnerIndex];
                row[partnerIndex] = temp;

                // updating map
                map.put(temp, partnerIndex);
                map.put(partner, i + 1);
            }
        }

        return swaps;
    }

}
