package task_85;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.04.2026)
 */
public class Cryptarithmetic {

    public static boolean solve(String w1, String w2, String w3) {
        Set<Character> set = new HashSet<>();

        for (char c : (w1 + w2 + w3).toCharArray()) {
            set.add(c);
        }

        if (set.size() > 10) return false;

        List<Character> letters = new ArrayList<>(set);
        Map<Character, Integer> map = new HashMap<>();
        boolean[] used = new boolean[10];

        return backtrack(letters, map, used, 0, w1, w2, w3);
    }

    private static boolean backtrack(List<Character> letters,
                                     Map<Character, Integer> map,
                                     boolean[] used,
                                     int index,
                                     String w1,
                                     String w2,
                                     String w3) {

        if (index == letters.size()) {
            return isValid(map, w1, w2, w3);
        }

        char ch = letters.get(index);

        for (int digit = 0; digit <= 9; digit++) {
            if (used[digit]) continue;

            map.put(ch, digit);
            used[digit] = true;

            if (backtrack(letters, map, used, index + 1, w1, w2, w3)) {
                return true;
            }

            map.remove(ch);
            used[digit] = false;
        }

        return false;
    }

    private static boolean isValid(Map<Character, Integer> map,
                                   String w1,
                                   String w2,
                                   String w3) {

        // Leading zero check
        if (map.get(w1.charAt(0)) == 0 ||
                map.get(w2.charAt(0)) == 0 ||
                map.get(w3.charAt(0)) == 0) {
            return false;
        }

        int num1 = toNumber(w1, map);
        int num2 = toNumber(w2, map);
        int num3 = toNumber(w3, map);

        return num1 + num2 == num3;
    }

    private static int toNumber(String word, Map<Character, Integer> map) {
        int num = 0;

        for (char c : word.toCharArray()) {
            num = num * 10 + map.get(c);
        }

        return num;
    }

    public static void main(String[] args) {
        String w1 = "SEND";
        String w2 = "MORE";
        String w3 = "MONEY";

        boolean result = solve(w1, w2, w3);
        System.out.println("Solution exists: " + result);
    }
}
