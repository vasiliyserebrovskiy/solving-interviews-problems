package task_17;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (15.02.2026)
 */
public class MatrixCounter {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 7, 10, 15, 20},
                {2, 6, 9, 14, 22, 25},
                {3, 8, 10, 15, 25, 30},
                {10,11,12,23,30,35},
                {20,25,30,35,40,45}
        };

        int i1 = 1, j1 = 1; // low
        int i2 = 3, j2 = 3; // high

        int result = countSmallerOrLarger(matrix, i1, j1, i2, j2);
        System.out.println(result); // Result 14
    }

    public static int countSmallerOrLarger(int[][] matrix, int i1, int j1, int i2, int j2) {
        int N = matrix.length;
        int M = matrix[0].length;

        int low = matrix[i1][j1];
        int high = matrix[i2][j2];

        int countLess = countLessThan(matrix, low);
        int countGreater = countGreaterThan(matrix, high);

        return countLess + countGreater;
    }

    // Element < X
    private static int countLessThan(int[][] matrix, int X) {
        int N = matrix.length;
        int M = matrix[0].length;

        int count = 0;
        int row = N - 1;
        int col = 0;

        while (row >= 0 && col < M) {
            if (matrix[row][col] < X) {
                count += row + 1; // all elements upper + this element included
                col++;
            } else {
                row--;
            }
        }

        return count;
    }

    // Elements > Y
    private static int countGreaterThan(int[][] matrix, int Y) {
        int N = matrix.length;
        int M = matrix[0].length;

        int count = 0;
        int row = 0;
        int col = M - 1;

        while (row < N && col >= 0) {
            if (matrix[row][col] > Y) {
                count += N - row; // all elements down + this element included
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}
