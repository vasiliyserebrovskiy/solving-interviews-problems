package task_48;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (04.03.2026)
 */
public class GenerateIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int index, List<String> path, List<String> result) {

        // Check if we already have 4 parts
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try length 1, 2, 3
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            if (isValid(part)) {
                path.add(part);
                backtrack(s, index + len, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isValid(String part) {
        if (part.length() > 1 && part.startsWith("0")) return false;

        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        String input = "2542540123";
        List<String> result = restoreIpAddresses(input);

        for (String ip : result) {
            System.out.println(ip);
        }
    }

}
