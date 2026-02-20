package task_26;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.02.2026)
 */
public class Task26App {
    public static void main(String[] args) {
        System.out.println(canMap("abc", "bcd")); // true
        System.out.println(canMap("foo", "bar")); // false
        System.out.println(canMap("ab", "aa"));   // false
        System.out.println(canMap("paper", "title")); // true
    }

    public static boolean canMap(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> usedValues = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (mapping.containsKey(c1)) {
                // Checking the consistency of the existing mapping
                if (mapping.get(c1) != c2) return false;
            } else {
                // Checking that c2 has not yet been assigned to another letter.
                if (usedValues.contains(c2)) return false;

                mapping.put(c1, c2);
                usedValues.add(c2);
            }
        }

        return true;
    }
}
