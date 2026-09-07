class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] col = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                else {
                    int val = board[i][j] - '1';
                    // col check
                    if (col[j][val])
                        return false;
                    else
                        col[j][val] = true;
                    // row check
                    if (row[i][val])
                        return false;
                    else
                        row[i][val] = true;
                    // box check
                    // find the box;
                    int boxRow = i / 3;
                    int boxCol = j / 3;
                    // now we need to map this box into a 1D array from this 2d
                    // cordinates of the box
                    // mapping 2d->1d formula is i(currRowIndex) * totalCols + j(currColIndex)
                    int boxIndex = boxRow * 3 + boxCol; // totalCols is 3 because mapping 3 in 1
                    if (box[boxIndex][val])
                        return false;
                    else
                        box[boxIndex][val] = true;
                }
            }
        }
        return true;
    }
}
