public class BattleshipFieldValidator {
    public static boolean fieldValidator(int[][] field) {
        int[] ships = new int[5];
        boolean[][] visited = new boolean[10][10];

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (field[row][col] == 0 || visited[row][col]) {
                    continue;
                }

                // каждый корабль обрабатываем только один раз из его верхней левой клетки
                if (row > 0 && field[row - 1][col] == 1 || col > 0 && field[row][col - 1] == 1) {
                    continue;
                }

                int length = 1;
                visited[row][col] = true;

                boolean horizontal = col < 9 && field[row][col + 1] == 1;
                boolean vertical = row < 9 && field[row + 1][col] == 1;

                if (horizontal && vertical) {
                    return false;
                }

                if (horizontal) {
                    for (int c = col + 1; c < 10 && field[row][c] == 1; c++) {
                        if ((row > 0 && field[row - 1][c] == 1)
                                || (row < 9 && field[row + 1][c] == 1)) {
                            return false;
                        }
                        visited[row][c] = true;
                        length++;
                    }
                } else if (vertical) {
                    for (int r = row + 1; r < 10 && field[r][col] == 1; r++) {
                        if ((col > 0 && field[r][col - 1] == 1)
                                || (col < 9 && field[r][col + 1] == 1)) {
                            return false;
                        }
                        visited[r][col] = true;
                        length++;
                    }
                }

                if (length > 4) {
                    return false;
                }

                // проверка отсутствия диагональных касаний
                for (int r = row; r < Math.min(row + (vertical ? length : 1), 10); r++) {
                    for (int c = col; c < Math.min(col + (horizontal ? length : 1), 10); c++) {
                        if ((r > 0 && c > 0 && field[r - 1][c - 1] == 1)
                                || (r > 0 && c < 9 && field[r - 1][c + 1] == 1)
                                || (r < 9 && c > 0 && field[r + 1][c - 1] == 1)
                                || (r < 9 && c < 9 && field[r + 1][c + 1] == 1)) {
                            return false;
                        }
                    }
                }
                ships[length]++;
            }
        }

        return ships[1] == 4
                && ships[2] == 3
                && ships[3] == 2
                && ships[4] == 1;
    }

}