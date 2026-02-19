package task_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.02.2026)
 */
public class Solution {
    public static void main(String[] args) {

        int[][] intervals = {
                {1, 4},
                {4, 5},
                {7, 9},
                {9, 12}//,
                //{15,20}
        };

        List<Integer> result = stabIntervals(intervals);

        System.out.println("Minimum stabbing points: " + result);
    }

    public static List<Integer> stabIntervals(int[][] intervals) {

        List<Integer> points = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return points;
        }

        // Sort intervals by right endpoint
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // Pick the end of the first interval
        int lastPoint = intervals[0][1];
        points.add(lastPoint);

        // Traverse the rest
        for (int i = 1; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            // If last chosen point doesn't cover current interval
            if (lastPoint < start) {
                lastPoint = end;
                points.add(lastPoint);
            }
        }

        return points;
    }
}
