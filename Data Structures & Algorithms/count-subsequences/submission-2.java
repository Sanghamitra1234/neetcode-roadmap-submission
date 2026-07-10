class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int [][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return numDistinctUtil(s, t, 0, 0, dp);
    }

    public int numDistinctUtil(String s, String t, int i, int j, int [][] dp) {
        if (j >= t.length()) return 1;
        if (i >= s.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int take = 0, notTake = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = numDistinctUtil(s, t, i + 1, j + 1, dp);
        } 
        notTake = numDistinctUtil(s, t, i + 1, j, dp);
        return dp[i][j] = take + notTake;
    }
}
