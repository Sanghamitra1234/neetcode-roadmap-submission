class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int answer = 1;
        int [][] dp = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int res = 1 + longestIncreasingPathUtil(matrix, i, j, dp);
                answer = Math.max(answer, res);
            }
        }
        return answer;
    }

    public int longestIncreasingPathUtil(int[][] matrix, int i, int j, int [][] dp) {
        if (i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0) return 0;
        int down = 0, right = 0, top = 0, left = 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            down = 1 + longestIncreasingPathUtil(matrix, i + 1, j, dp);
        }
        if (i >= 1 && matrix[i - 1][j] > matrix[i][j]) {
            top = 1 + longestIncreasingPathUtil(matrix, i - 1, j, dp);
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            right = 1 + longestIncreasingPathUtil(matrix, i, j + 1, dp);
        }
        if (j >= 1 && matrix[i][j - 1] > matrix[i][j]) {
            left = 1 + longestIncreasingPathUtil(matrix, i, j - 1, dp);
        }
        return dp[i][j]  = Math.max(down, Math.max(right, Math.max(top, left)));
    }
}
