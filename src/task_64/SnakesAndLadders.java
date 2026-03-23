package task_64;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.03.2026)
 */
public class SnakesAndLadders {

    public static int minTurns(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        queue.offer(new int[]{1, 0}); // position, moves
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int turns = current[1];

            if (pos == 100) return turns;

            for (int dice = 1; dice <= 6; dice++) {
                int next = pos + dice;
                if (next > 100) continue;

                // We check the snakes and ladders
                if (snakes.containsKey(next)) {
                    next = snakes.get(next);
                } else if (ladders.containsKey(next)) {
                    next = ladders.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, turns + 1});
                }
            }
        }

        return -1; // if it is suddenly impossible (theoretically not)
    }

    public static void main(String[] args) {
        Map<Integer, Integer> snakes = Map.of(
                16, 6, 48, 26, 49, 11, 56, 53,
                62, 19, 64, 60, 87, 24, 93, 73,
                95, 75, 98, 78
        );

        Map<Integer, Integer> ladders = Map.of(
                1, 38, 4, 14, 9, 31, 21, 42,
                28, 84, 36, 44, 51, 67, 71, 91,
                80, 100
        );

        System.out.println(minTurns(snakes, ladders));
    }

}
