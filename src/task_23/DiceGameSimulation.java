package task_23;

import java.util.Random;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.02.2026)
 */
public class DiceGameSimulation {
    static Random rand = new Random();

    public static void main(String[] args) {
        int trials = 1_000_000;
        long totalFiveSix = 0;
        long totalFiveFive = 0;

        for (int i = 0; i < trials; i++) {
            totalFiveSix += playFiveSix();
            totalFiveFive += playFiveFive();
        }

        double expectedFiveSix = (double) totalFiveSix / trials;
        double expectedFiveFive = (double) totalFiveFive / trials;

        System.out.println("Expected rolls for 5->6: " + expectedFiveSix);
        System.out.println("Expected rolls for 5->5: " + expectedFiveFive);
    }



    // Simulation for game "5 -> 6"
    public static int playFiveSix() {
        int rolls = 0;
        boolean prevFive = false;

        while (true) {
            rolls++;
            int roll = rand.nextInt(6) + 1; // 1..6

            if (prevFive && roll == 6) {
                break; // success
            }

            prevFive = (roll == 5);
        }

        return rolls;
    }

    // Simulation for game "5 -> 5"
    public static int playFiveFive() {
        int rolls = 0;
        boolean prevFive = false;

        while (true) {
            rolls++;
            int roll = rand.nextInt(6) + 1;

            if (prevFive && roll == 5) {
                break; // success
            }

            prevFive = (roll == 5);
        }

        return rolls;
    }
}
