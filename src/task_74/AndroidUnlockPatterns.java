package task_74;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (02.04.2026)
 */
public class AndroidUnlockPatterns {

    private static int[][] skip = new int[10][10];
    private static boolean[] visited = new boolean[10];

    public static void main(String[] args) {
        int N = 4; // can be changed from 1 to 9
        System.out.println("Total patterns of length " + N + ": " + numberOfPatterns(N));
    }

    public static int numberOfPatterns(int n) {
        // filling skip's
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;

        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
        skip[4][6] = skip[6][4] = 5;
        skip[2][8] = skip[8][2] = 5;

        int result = 0;

        result += dfs(1, 1, n) * 4; // 1,3,7,9
        result += dfs(2, 1, n) * 4; // 2,4,6,8
        result += dfs(5, 1, n);     // 5

        return result;
    }

    private static int dfs(int current, int length, int targetLength) {
        if (length == targetLength) {
            return 1;
        }

        visited[current] = true;
        int count = 0;

        for (int next = 1; next <= 9; next++) {
            if (!visited[next] &&
                    (skip[current][next] == 0 || visited[skip[current][next]])) {

                count += dfs(next, length + 1, targetLength);
            }
        }

        visited[current] = false; // backtrack
        return count;
    }

}
