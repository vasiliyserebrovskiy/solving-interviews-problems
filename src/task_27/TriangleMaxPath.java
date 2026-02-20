package task_27;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (20.02.2026)
 */
public class TriangleMaxPath {

    public static void main(String[] args) {

        int[][] triangle = {
                {1},
                {2, 3},
                {1, 5, 1}//,
                //{6, 1, 2, 4}
        };

        System.out.println(maxPathSum(triangle)); // 9
    }

    public static int maxPathSum(int[][] triangle) {

        int[] dp = triangle[triangle.length - 1].clone();

        for (int row = triangle.length - 2; row >= 0; row--) {

            for (int col = 0; col < triangle[row].length; col++) {

                dp[col] = triangle[row][col] +
                        Math.max(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }
}
