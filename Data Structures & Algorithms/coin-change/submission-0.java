class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int answer = coinChangeUtil(coins, amount, coins.length - 1);
        return answer == 100000000 ? -1 : answer;
    }

    public int coinChangeUtil(int[] coins, int amount, int index) {
        if (amount <= 0) return 0;
        if (index < 0) return 100000000;
        int pick = 100000000;
        if (coins[index] <= amount) {
            pick =  1 + coinChangeUtil(coins, amount - coins[index], index);
        }
        int notPick = coinChangeUtil(coins, amount ,index - 1);
        return Math.min(notPick, pick);
    }
}
