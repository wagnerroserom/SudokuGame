package sudokuGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SudokuGame extends JFrame {

    private JTextField[][] fields;

    public SudokuGame() {
        setTitle("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(new GridLayout(9, 9));

        fields = new JTextField[9][9];

        // Generar un tablero de Sudoku aleatorio
        int[][] board = generateRandomSudoku();

        // Crear campos de texto para cada celda del tablero
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fields[i][j] = new JTextField();
                fields[i][j].setHorizontalAlignment(JTextField.CENTER);
                if (board[i][j] != 0) {
                    fields[i][j].setText(Integer.toString(board[i][j]));
                    fields[i][j].setEditable(false);
                }
                sudokuPanel.add(fields[i][j]);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para resolver el Sudoku (puedes implementarla aquí)
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sudokuPanel, BorderLayout.CENTER);
        getContentPane().add(solveButton, BorderLayout.SOUTH);
    }

    private int[][] generateRandomSudoku() {
        int[][] board = new int[9][9];
        fillSudoku(board);
        return board;
    }

    private boolean fillSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (fillSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar fila y columna
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Verificar subcuadrícula 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SudokuGame sudokuGame = new SudokuGame();
                sudokuGame.setVisible(true);
            }
        });
    }
}




