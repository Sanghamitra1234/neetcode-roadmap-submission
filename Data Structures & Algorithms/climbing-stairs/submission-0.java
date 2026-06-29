class Solution {
    public int climbStairs(int n) {
        int [] dp = new int [n + 1];
        return climbStairsUtil(n, dp);
    }

    public int climbStairsUtil(int n, int [] dp) {
        
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = climbStairsUtil(n - 1, dp) + climbStairsUtil(n - 2, dp);
        return dp[n];
        
    }
}
