package task_88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (14.04.2026)
 */
public class ZigZag {

    public static void main(String[] args) {
        printZigZag("thisisazigzag", 4);
    }

    public static void printZigZag(String s, int k) {
        int n = s.length();

        char[][] grid = new char[k][n];
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }

        int row = 0;
        boolean goingDown = true;

        for (int col = 0; col < n; col++) {
            char c = s.charAt(col);

            grid[row][col] = c;

            if (row == 0) {
                goingDown = true;
            } else if (row == k - 1) {
                goingDown = false;
            }

            row += goingDown ? 1 : -1;
        }

        // print with trimming
        for (char[] r : grid) {
            int end = r.length - 1;
            while (end >= 0 && r[end] == ' ') end--;
            System.out.println(new String(r, 0, end + 1));
        }
    }

}
