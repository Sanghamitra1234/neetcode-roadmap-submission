class Solution {
    public int change(int amount, int[] coins) {
        // Arrays.sort(coins);
        int n = coins.length;
        int [][] memo = new int [amount + 1][n + 1];
        for (int i = 0; i <= amount; i++) memo[i][0] = 0;
        for (int i = 0; i <= n; i++) memo[0][i] = 1;

        for (int am = 1; am <= amount; am++) {
            for (int index = 1; index <= n; index++) {
                int take = 0;
                if (am - coins[index - 1] >= 0) {
                    take = memo[am - coins[index - 1]][index];
                }
                int notTake = memo[am][index - 1];
                memo[am][index] = take + notTake;
            }
        }
        return memo[amount][n];
        // changes(amount, coins, n - 1, memo);
    }

    public int changes(int amount, int[] coins, int index, int [][] memo) {
        if (amount == 0) return 1;
        if (amount < 0 || index < 0) return 0;
        if (memo[amount][index] != 0) return memo[amount][index];

        int take = changes(amount - coins[index], coins, index, memo);
        int notTake = changes(amount, coins, index - 1, memo);

        return memo[amount][index] = take + notTake;
    }
}
