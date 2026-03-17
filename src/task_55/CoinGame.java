package task_55;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.03.2026)
 */
public class CoinGame {
    public static int maxCoins(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Fill in diagonally
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                // values outside the array are considered 0
                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;

                int takeLeft = arr[i] + Math.min(x, y);
                int takeRight = arr[j] + Math.min(y, z);

                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] coins = {8, 15, 3, 7};

        int result = maxCoins(coins);

        System.out.println("Maximum payoff: " + result);
    }
}
