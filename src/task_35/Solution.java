package task_35;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (24.02.2026)
 */
public class Solution {

    public static void main(String[] args) {
        List<Event> events = Arrays.asList(
                new Event(10, 3, "enter"),
                new Event(15, 2, "enter"),
                new Event(20, 1, "exit"),
                new Event(25, 4, "exit")
        );

        int[] period = busiestPeriod(events);
        System.out.println("Busiest period: (" + period[0] + ", " + period[1] + ")");
    }

    public static int[] busiestPeriod(List<Event> events) {
        // Sort by timestamp
        events.sort(Comparator.comparingInt(e -> e.timestamp));

        int current = 0;
        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < events.size(); i++) {

            Event e = events.get(i);

            if (e.type.equals("enter"))
                current += e.count;
            else
                current -= e.count;

            if (current > max) {

                max = current;
                start = e.timestamp;

                if (i + 1 < events.size())
                    end = events.get(i + 1).timestamp;
            }
        }

        return new int[]{start, end};
    }
}
