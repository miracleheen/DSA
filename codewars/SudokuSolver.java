public class SudokuSolver {
    public static int[][] sudoku(int[][] puzzle) {
        solve(puzzle);
        return puzzle;
    }

    private static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != 0) continue;

                for (int value = 1; value <= 9; value++) {
                    if (isValid(board, row, col, value)) {
                        board[row][col] = value;

                        if (solve(board)) {
                            return true;
                        }

                        board[row][col] = 0;
                    }
                }

                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int value) {
        int boxRow = row / 3 * 3;
        int boxCol = col / 3 * 3;

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value
                    || board[i][col] == value
                    || board[boxRow + i / 3][boxCol + i % 3] == value) {
                return false;
            }
        }

        return true;
    }

}