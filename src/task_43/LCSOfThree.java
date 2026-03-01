package task_43;

public class LCSOfThree {

    public static int lcs(String a, String b, String c) {

        int n = a.length();
        int m = b.length();
        int l = c.length();

        int[][][] dp = new int[n + 1][m + 1][l + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= l; k++) {

                    if (a.charAt(i - 1) == b.charAt(j - 1) &&
                            a.charAt(i - 1) == c.charAt(k - 1)) {

                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;

                    } else {

                        dp[i][j][k] = Math.max(
                                Math.max(dp[i - 1][j][k],
                                        dp[i][j - 1][k]),
                                dp[i][j][k - 1]
                        );
                    }
                }
            }
        }

        return dp[n][m][l];
    }

    public static void main(String[] args) {

        String s1 = "epidemiologist";
        String s2 = "refrigeration";
        String s3 = "supercalifragilisticexpialodocious";

        int result = lcs(s1, s2, s3);
        System.out.println("LCS length = " + result);
    }

}
