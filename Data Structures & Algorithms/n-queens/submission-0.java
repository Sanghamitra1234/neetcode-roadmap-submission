class Solution {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(0, board, res);
        return res;
    }

    public void backtrack(int r, char[][] board, List<List<String>> res) {
        if ( r == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(canPlace(board, r, i)) {
                board[r][i] = 'Q';
                backtrack(r + 1, board, res);
                board[r][i] = '.';
            }
        }
    }
    public boolean canPlace(char [][] board, int r, int c) {

        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
