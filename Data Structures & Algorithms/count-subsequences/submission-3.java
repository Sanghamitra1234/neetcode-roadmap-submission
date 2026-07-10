class Solution {
    int m = 0;
    int n = 0;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        if (m < n) return 0;
        int [][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
           dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int take = 0, notTake = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    take = numDistinctUtil(s, t, i + 1, j + 1, dp);
                } 
                notTake = numDistinctUtil(s, t, i + 1, j, dp);
                dp[i][j] = take + notTake;
            }
        }
        return dp[0][0];
        //numDistinctUtil(s, t, 0, 0, dp);
    }

    public int numDistinctUtil(String s, String t, int i, int j, int [][] dp) {
        if (j >= n) return 1;
        if (i >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int take = 0, notTake = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = numDistinctUtil(s, t, i + 1, j + 1, dp);
        } 
        notTake = numDistinctUtil(s, t, i + 1, j, dp);
        return dp[i][j] = take + notTake;
    }
}
