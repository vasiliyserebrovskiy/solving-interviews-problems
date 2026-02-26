package task_40;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (26.02.2026)
 */
public class SolutionApp {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

        rotate2(matrix);

        System.out.println("\nRotated matrix (90° clockwise):");
        printMatrix(matrix);
    }

    // Example 1: in-place
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {

            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {

                int offset = i - first;

                int top = matrix[first][i];

                // left → top
                matrix[first][i] = matrix[last - offset][first];

                // bottom → left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right → bottom
                matrix[last][last - offset] = matrix[i][last];

                // top → right
                matrix[i][last] = top;
            }
        }
    }

    // Example 2: transpose + reverse
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num); // красивое выравнивание
            }
            System.out.println();
        }
    }
}
