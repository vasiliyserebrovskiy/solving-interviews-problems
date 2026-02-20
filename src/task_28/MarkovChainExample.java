package task_28;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (20.02.2026)
 */
public class MarkovChainExample {
    static class Transition {
        String to;
        double probability;

        Transition(String to, double probability) {
            this.to = to;
            this.probability = probability;
        }
    }

    public static Map<String, Integer> runMarkov(
            String start,
            Map<String, List<Transition>> transitions,
            int steps) {

        Map<String, Integer> visits = new HashMap<>();
        Random random = new Random();

        String current = start;
        visits.put(current, 1);

        for (int i = 0; i < steps; i++) {

            double r = random.nextDouble();
            double cumulative = 0.0;

            for (Transition t : transitions.get(current)) {

                cumulative += t.probability;

                if (r <= cumulative) {
                    current = t.to;
                    break;
                }
            }

            visits.put(current,
                    visits.getOrDefault(current, 0) + 1);
        }

        return visits;
    }

    public static void main(String[] args) {

        Map<String, List<Transition>> transitions = new HashMap<>();

        transitions.put("a", Arrays.asList(
                new Transition("a", 0.9),
                new Transition("b", 0.075),
                new Transition("c", 0.025)
        ));

        transitions.put("b", Arrays.asList(
                new Transition("a", 0.15),
                new Transition("b", 0.8),
                new Transition("c", 0.05)
        ));

        transitions.put("c", Arrays.asList(
                new Transition("a", 0.25),
                new Transition("b", 0.25),
                new Transition("c", 0.5)
        ));

        String start = "a";
        int steps = 5000;

        Map<String, Integer> result =
                runMarkov(start, transitions, steps);

        System.out.println(result);
    }
}
