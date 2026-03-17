package task_54_game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.03.2026)
 */
public class Connect4UI {
    private Connect4 game;
    private JButton[][] buttons;
    private char currentPlayer = 'R';
    private JLabel statusLabel;

    public Connect4UI() {
        game = new Connect4();
        buttons = new JButton[6][7];

        JFrame frame = new JFrame("Connect 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout());

        // Статус (чей ход)
        statusLabel = new JLabel("🔴 Red turn");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // The playing field
        JPanel panel = new JPanel(new GridLayout(6, 7));

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                JButton btn = new JButton();

                btn.setBackground(Color.WHITE);
                btn.setOpaque(true);
                btn.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                int c = col;

                btn.addActionListener(e -> handleMove(c));

                buttons[row][col] = btn;
                panel.add(btn);
            }
        }

        frame.add(statusLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void handleMove(int col) {
        boolean win = game.makeMove(col, currentPlayer);
        updateBoard();

        if (win) {
            JOptionPane.showMessageDialog(null,
                    (currentPlayer == 'R' ? "🔴 Red wins!" : "⚫ Black wins!"));
            System.exit(0);
        }

        // player change
        currentPlayer = (currentPlayer == 'R') ? 'B' : 'R';

        // updating the text
        if (currentPlayer == 'R') {
            statusLabel.setText("🔴 Red turn");
        } else {
            statusLabel.setText("⚫ Black turn");
        }
    }

    private void updateBoard() {
        char[][] board = game.getBoard();

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == 'R') {
                    buttons[row][col].setBackground(Color.RED);
                } else if (board[row][col] == 'B') {
                    buttons[row][col].setBackground(Color.BLACK);
                } else {
                    buttons[row][col].setBackground(Color.WHITE);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Connect4UI();
    }
}
