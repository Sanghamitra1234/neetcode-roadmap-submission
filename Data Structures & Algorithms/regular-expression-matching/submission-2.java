class Solution {
    public boolean isMatch(String s, String p) {
        Boolean [][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatches(s, p, 0, 0, dp);
    }

    public boolean isMatches(String s, String p, int i, int j, Boolean[][] dp) {
        if(j == p.length()) return i == s.length();
       // if(i >= s.length() || j >= p.length()) return false;
        if (dp[i][j] != null) return dp[i][j];
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            boolean a = false;
            if (match) {
                a = isMatches(s, p, i + 1, j, dp);
            }
            a = a || isMatches(s, p, i, j + 2, dp);
            return  dp[i][j] = a;
        }
        if (match) {
            return dp[i][j] = isMatches(s, p, i + 1, j + 1, dp);
        }
        return dp[i][j] = false;
    }
}
