package task_45;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (02.03.2026)
 */
public class PatternSearch {

    public static List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        if (text == null || pattern == null || pattern.length() > text.length()) {
            return result;
        }

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j = 0;

            while (j < pattern.length() &&
                    text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == pattern.length()) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "abracadabra";
        String pattern = "abr";

        System.out.println(findOccurrences(text, pattern));
    }

}
