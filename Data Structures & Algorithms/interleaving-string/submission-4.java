class Solution {
    int m = 0;
    int n = 0;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        int k = 0;
        boolean [][] memo = new boolean [m + 1][n + 1];

        for (int i = 0; i <= m; i++) memo[i][n] = true;
        for (int i = 0; i <= n; i++) memo[m][i] = true;

        for (int i = m ; i >= 0; i--) {
            for (int j = n ; j >= 0; j--) {
                if ( i == m && j == n) continue;
                k = i + j;
                boolean first = false, second = false;
                if ( i < m && s1.charAt(i) == s3.charAt(k)) {
                    first = memo[i + 1][j];
                }

                if (j < n && s2.charAt(j) == s3.charAt(k)) {
                    second = memo[i][j + 1];
                }
                memo[i][j] = first || second;
            }
        }
        return memo[0][0];
        //isInterleaveUtil(s1, s2, s3, 0, 0, 0, memo);
    }
    public boolean isInterleaveUtil(String s1, String s2, String s3, int i, int j , int k, Boolean [][] memo) {
        if (k >= s3.length() && i >= m && j >= n) return true;
        if (k >= s3.length()) return false;
        if (memo[i][j] != null) return memo[i][j];
        boolean first = false, second = false;
        if ( i < m && s1.charAt(i) == s3.charAt(k)) {
            first = isInterleaveUtil(s1, s2, s3, i + 1, j , k + 1, memo);
        }

        if ( j < n && s2.charAt(j) == s3.charAt(k)) {
            second = isInterleaveUtil(s1, s2, s3, i, j + 1 , k + 1, memo);
        }
        return memo[i][j] = first || second;
    }
}
