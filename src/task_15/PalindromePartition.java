package task_15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.02.2026)
 */
public class PalindromePartition {
    public static List<String> minPalindromePartition(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        // 1 We pre-mark all palindromes
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        // 2 DP: minimum number of palindromes for s[0..i]
        int[] dp = new int[n];
        int[] cutIndex = new int[n]; // to restore palindromes

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    if (j == 0) {
                        dp[i] = 1;
                        cutIndex[i] = -1; // the beginning of the line
                    } else if (dp[j - 1] + 1 < dp[i]) {
                        dp[i] = dp[j - 1] + 1;
                        cutIndex[i] = j - 1;
                    }
                }
            }
        }

        // 3 Restoring substrings
        List<String> result = new ArrayList<>();
        int idx = n - 1;
        while (idx >= 0) {
            int start = cutIndex[idx] + 1;
            result.add(0, s.substring(start, idx + 1));
            idx = cutIndex[idx];
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "racecarannakayak";
        String s2 = "abc";

        System.out.println(minPalindromePartition(s1)); // [racecar, anna, kayak]
        System.out.println(minPalindromePartition(s2)); // [a, b, c]
    }
}
