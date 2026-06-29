class Solution {
    int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int [][] vis;
    public void solve(char[][] board) {
        vis = new int [board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board,board.length - 1, i);
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'L') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X') {
            return;
        }
        if (vis[x][y] == 1) return;
        vis[x][y] = 1;
        board[x][y] = 'L';
        for (int i = 0; i < dir.length; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];

            dfs(board, dx, dy);
        }
        
    }
}
