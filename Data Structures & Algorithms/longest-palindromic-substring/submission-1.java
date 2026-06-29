class Solution {
    int maxLength = 0;
    String maxString = "";
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int start = i, end = j;
                while (start < end && s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                }

                if (start >= end && maxLength < (j - i + 1)) {
                    maxLength = j - i + 1;
                    maxString = s.substring(i, j + 1);
                }
            }
        }
        return maxString;
        // int [][] dp = new int[s.length() + 1][s.length() + 1];
        // maxLength = 0;
        // maxString = "";
        // longestPalindromeUtil(s, 0, 0, "", dp);
        // return maxString;
    }

    public void longestPalindromeUtil(String s, int start, int end, String p, int [][] dp) {
        if (dp[start][end] > maxLength) {
            maxLength = p.length();
            maxString = p;
        }
        if (p.equals(new StringBuffer(p).reverse().toString())) {
            dp[start][end] = end - start + 1;
            if (p.length() > maxLength) {
                maxLength = p.length();
                maxString = p;
            }
        }
        if (end >= s.length()) return;
        longestPalindromeUtil(s, end + 1, end + 1, "", dp);
        longestPalindromeUtil(s, start, end + 1, p + s.charAt(end)+"", dp);
        return;
    }
}
