class Solution {
    public int maxProfit(int[] prices) {
        int [][] memo = new int [prices.length + 2][2];
        memo[prices.length][0] = 0;
        memo[prices.length][1] = 0;
        int bought = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) {
                    int sold = prices[i] + memo[i + 2][0];
                    int notSold = 0 + memo[i + 1][1]; 
                    memo[i][j] = Math.max(sold, notSold);
                } else {
                    int buy = -prices[i] + memo[i + 1][1];
                    int notBuy = 0 + memo[i + 1][0];
                    memo[i][j] = Math.max(buy, notBuy);
                }
            } 
        }
        return memo[0][0];
       // return maxProf(prices, 0, 0, memo);
    }

    public int maxProf(int [] prices, int index, int bought, int [][] memo) {
        if (index >= prices.length) return 0;
        if (memo[index][bought] != 0) return memo[index][bought];
        if (bought == 1) {
            int sold = prices[index] + maxProf(prices, index + 2, 0, memo);
            int notSold = 0 + maxProf(prices, index + 1, 1, memo);
            return memo[index][bought] = Math.max(sold, notSold);
        }

        int buy = -prices[index] + maxProf(prices, index + 1, 1, memo);
        int notBuy = 0 + maxProf(prices, index + 1, 0, memo);
        return memo[index][bought] = Math.max(buy, notBuy);
    }
}
