class Solution {
    int m = 0;
    int n = 0;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        int [][] dp = new int [m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][n] = m - i;
        for (int i = 0; i <= n; i++) dp[m][i] = n - i;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                 if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int insert = 1 + dp[i][j + 1];
                    int delete = 1 + dp[i + 1][j];
                    int replace = 1 + dp[i + 1][j + 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[0][0];
        // minDistanceUtil(word1, word2, 0, 0, dp);
    }

    public int minDistanceUtil(String word1, String word2, int i, int j, int [][] dp) {
        if (j >= n) return m - i;
        if (i >= m) return n - j;

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = minDistanceUtil(word1, word2, i + 1, j + 1, dp);
        } else {
            int insert = 1 + minDistanceUtil(word1, word2, i, j + 1, dp);
            int delete = 1 + minDistanceUtil(word1, word2, i + 1, j, dp);
            int replace = 1 + minDistanceUtil(word1, word2, i + 1, j + 1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
        
    }

}