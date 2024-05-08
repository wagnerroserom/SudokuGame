package sudokuGame;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
        initializeBoard();
    }

    public int[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        int[][] initialBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = initialBoard[i][j];
            }
        }
    }

    public int getCellValue(int row, int col) {
        return board[row][col];
    }
}

