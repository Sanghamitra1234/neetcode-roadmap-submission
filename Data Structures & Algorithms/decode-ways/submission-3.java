class Solution {
    int count = 0;
    public int numDecodings(String s) {
        int [] dp = new int [s.length() + 2];
        dp[s.length() + 1] = 0;
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
               dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i < s.length() - 1) {
                    int t = Integer.parseInt(s.substring(i, i + 2));
                    if (t >= 10 && t <= 26) {
                        dp[i] +=  dp[i + 2];
                    }
                }
            }
        }

        return dp[0];
    }

    public int numDecodingsUtil(String s, int index, int [] dp) {
        if (index >= s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (dp[index] > 0) return dp[index];
        
        int result  = 0;
        result += numDecodingsUtil(s, index + 1, dp);
        
        if (index < s.length() - 1) {
            int t = Integer.parseInt(s.substring(index, index + 2));
            if (t >= 10 && t <= 26) {
                result += numDecodingsUtil(s, index + 2, dp);
            }
        }
        dp[index] = result;
        return dp[index];
    }

}
