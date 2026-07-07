class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
               if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
               } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
               }
            }
        }
        return dp[m][n];
       // return lcs(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    public int lcs(String text1, String text2, int index1, int index2, int [][] dp) {
        if (index1 < 0 || index2 < 0) return 0;
        if (dp[index1][index2] != 0) return dp[index1][index2];
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + lcs(text1, text2, index1 - 1, index2 - 1, dp);
        }
        return Math.max(lcs(text1, text2, index1 - 1, index2, dp),
        lcs(text1, text2, index1, index2 - 1, dp));
    }
}
