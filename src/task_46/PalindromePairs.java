package task_46;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (02.03.2026)
 */
public class PalindromePairs {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // filling map
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {

                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                // Case 1
                if (isPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix)
                            .reverse().toString();

                    if (map.containsKey(reversedSuffix)
                            && map.get(reversedSuffix) != i) {
                        result.add(Arrays.asList(map.get(reversedSuffix), i));
                    }
                }

                // Case 2
                if (j != word.length() && isPalindrome(suffix)) {
                    String reversedPrefix = new StringBuilder(prefix)
                            .reverse().toString();

                    if (map.containsKey(reversedPrefix)
                            && map.get(reversedPrefix) != i) {
                        result.add(Arrays.asList(i, map.get(reversedPrefix)));
                    }
                }
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"code", "edoc", "da", "d"};

        System.out.println(palindromePairs(words));
    }

}
