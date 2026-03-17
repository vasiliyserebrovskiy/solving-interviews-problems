package task_54_game;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.03.2026)
 */
public class Connect4 {
    private final int ROWS = 6;
    private final int COLS = 7;
    private char[][] board;

    public Connect4() {
        board = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }
    }

    public boolean makeMove(int col, char player) {
        if (col < 0 || col >= COLS) return false;

        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == '.') {
                board[row][col] = player;
                return checkWin(row, col, player);
            }
        }
        return false; // the column is full
    }

    private boolean checkWin(int row, int col, char player) {
        return checkDirection(row, col, player, 1, 0)   // vertical
                || checkDirection(row, col, player, 0, 1)   // horizontal
                || checkDirection(row, col, player, 1, 1)   // the diagonal ↘
                || checkDirection(row, col, player, 1, -1); // the diagonal ↗
    }

    private boolean checkDirection(int row, int col, char player, int dr, int dc) {
        int count = 1;

        count += countDiscs(row, col, player, dr, dc);
        count += countDiscs(row, col, player, -dr, -dc);

        return count >= 4;
    }

    private int countDiscs(int row, int col, char player, int dr, int dc) {
        int count = 0;
        int r = row + dr;
        int c = col + dc;

        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && board[r][c] == player) {
            count++;
            r += dr;
            c += dc;
        }
        return count;
    }

    public char[][] getBoard() {
        return board;
    }
}
