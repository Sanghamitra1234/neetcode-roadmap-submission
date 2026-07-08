class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean [][] memo = new Boolean [s1.length() + 1][s2.length() + 1];
        return isInterleaveUtil(s1, s2, s3, 0, 0, 0, memo);
    }
    public boolean isInterleaveUtil(String s1, String s2, String s3, int i, int j , int k, Boolean [][] memo) {
        if (k >= s3.length() && i >= s1.length() && j >= s2.length()) return true;
        if (k >= s3.length()) return false;
        if (memo[i][j] != null) return memo[i][j];
        boolean first = false, second = false;
        if ( i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            first = isInterleaveUtil(s1, s2, s3, i + 1, j , k + 1, memo);
        }

        if ( j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            second = isInterleaveUtil(s1, s2, s3, i, j + 1 , k + 1, memo);
        }
        return memo[i][j] = first || second;
    }
}
