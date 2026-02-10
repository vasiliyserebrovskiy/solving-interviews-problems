package task_07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.02.2026)
 */
public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sorting by the right edge of the interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = intervals[0][1];
        int count = 1; // we leave the first interval exactly

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // the interval does not overlap
                end = intervals[i][1];
                count++;
            }
            // otherwise, the interval will overlap, skip (delete)
        }

        // number of deleted intervals = total - left
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = { {7, 9}, {2, 4}, {5, 8}};
        System.out.println("Intervals to remove: " + eraseOverlapIntervals(intervals));
    }
}
