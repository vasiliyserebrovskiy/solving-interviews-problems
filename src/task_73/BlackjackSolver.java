package task_73;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (30.03.2026)
 */
public class BlackjackSolver {

    static int[] deck;
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        deck = new int[]{10, 6, 7, 5, 9, 10, 2, 3, 8, 4, 10, 1};

        System.out.println("Max score: " + solve(0));
    }

    static int solve(int i) {
        if (i >= deck.length) return 0;

        if (memo.containsKey(i)) return memo.get(i);

        int maxScore = Integer.MIN_VALUE;

        // You need at least 4 cards (2 player + 2 dealer)
        if (i + 3 >= deck.length) return 0;

        int player = deck[i] + deck[i + 1];
        int dealer = deck[i + 2] + deck[i + 3];

        // Going through all the "hit" options
        for (int hits = 0; i + 4 + hits <= deck.length; hits++) {
            int currPlayer = player;
            int nextIndex = i + 4;

            // getting the cards to the player
            for (int h = 0; h < hits; h++) {
                currPlayer += deck[nextIndex++];
                if (currPlayer > 21) break;
            }

            // if too much → loss
            int result;
            if (currPlayer > 21) {
                result = -1;
            } else {
                // The dealer is playing
                int currDealer = dealer;
                int dealerIndex = i + 4 + hits;

                while (currDealer <= 16 && dealerIndex < deck.length) {
                    currDealer += deck[dealerIndex++];
                }

                if (currDealer > 21 || currPlayer > currDealer) {
                    result = 1;
                } else if (currPlayer == currDealer) {
                    result = 0;
                } else {
                    result = -1;
                }

                nextIndex = dealerIndex;
            }

            int totalScore = result + solve(nextIndex);
            maxScore = Math.max(maxScore, totalScore);
        }

        memo.put(i, maxScore);
        return maxScore;
    }

}
