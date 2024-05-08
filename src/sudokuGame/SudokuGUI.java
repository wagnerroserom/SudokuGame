package sudokuGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI {
    private SudokuBoard board;
    private JFrame frame;

    public SudokuGUI(SudokuBoard board) {
        this.board = board;
    }

    public void createAndShowGUI() {
        frame = new JFrame("Sudoku Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = createBoardPanel();
        frame.add(boardPanel, BorderLayout.CENTER);

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para resolver el Sudoku (puedes implementar esto)
                // Actualiza el tablero y vuelve a pintar la GUI.
            }
        });

        frame.add(solveButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createBoardPanel() {
        JPanel panel = new JPanel(new GridLayout(9, 9));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField textField = new JTextField();
                textField.setHorizontalAlignment(JTextField.CENTER);
                textField.setFont(new Font("Arial", Font.PLAIN, 20));
                textField.setEditable(false);
                textField.setText(String.valueOf(board.getCellValue(i, j)));

                panel.add(textField);
            }
        }

        return panel;
    }
}
