package task_65;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.03.2026)
 */
public class EggDrop {

    public static int eggDrop(int N, int K) {
        int[][] dp = new int[N + 1][K + 1];

        // basic cases
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 0; // 0 floors
            dp[i][1] = 1; // 1st floor
        }

        for (int j = 1; j <= K; j++) {
            dp[1][j] = j; // 1 egg → linear search
        }

        // filling in the table
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x <= j; x++) {
                    int worst = 1 + Math.max(
                            dp[i - 1][x - 1],  // crashed
                            dp[i][j - x]       // didn't crashed
                    );

                    dp[i][j] = Math.min(dp[i][j], worst);
                }
            }
        }

        return dp[N][K];
    }

    public static void main(String[] args) {
        System.out.println(eggDrop(2, 10)); // example
    }

}
