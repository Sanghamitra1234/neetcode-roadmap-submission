class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet <Integer> hset = new HashSet<>();

        // check for rows
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    if (hset.contains(val)) {
                        return false;
                    } else {
                        hset.add(val);
                    }
                }
            }
            hset.clear();
        }

        // check for columns
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    int val = board[j][i] - '0';
                    if (hset.contains(val)) {
                        return false;
                    } else {
                        hset.add(val);
                    }
                }
            }
            hset.clear();
        }

        // check for 3 * 3
        int [] rowStart = {0,0,0,3,3,3,6,6,6};
        int [] colStart = {0,3,6,0,3,6,0,3,6};
        
        for (int i = 0; i < rowStart.length; i++) {
            if (!checkGrid(rowStart[i],colStart[i], board)) return false;
        }
        return true;
        
    }

    public boolean checkGrid (int r, int c, char[][] board) {
        HashSet <Integer> hset = new HashSet<>();
        for (int i = r ; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[j][i] != '.') {
                    int val = board[j][i] - '0';
                    if (hset.contains(val)) {
                        return false;
                    } else {
                        hset.add(val);
                    }
                }
            }
        }
        return true;
    }
}
