class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
        }
        if (sum1 % 2 != 0) return false;
        sum1 = sum1/2;
        boolean [][] memo = new boolean [nums.length + 1][sum1 + 1];
        for (int i = 0; i <= nums.length; i++) {
            memo[i][0] = true;
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                int index = i;
                int sum = j;
                boolean pick = false, notPick = false;
                if (nums[index - 1] <= sum) {
                    pick = memo[index - 1][sum - nums[index - 1]];
                }
                //canPartitionUtil(nums, sum - nums[index], index + 1, memo);
                if (index + 1 < memo.length) {
                    notPick = memo[index - 1][sum];
                }
                //canPartitionUtil(nums, sum, index + 1, memo);
                memo[index][sum] = pick || notPick;;

            }
        }
        return memo[nums.length][sum1];
        //canPartitionUtil (nums, sum, 0, memo);
    }

    public boolean canPartitionUtil(int[] nums, int sum, int index, boolean [][] memo) {
        if (index >= nums.length || sum < 0) return false;
        if (sum == 0) return true;
        if (memo[index][sum]) return memo[index][sum];

        boolean pick = canPartitionUtil(nums, sum - nums[index], index + 1, memo);
        boolean notPick = canPartitionUtil(nums, sum, index + 1, memo);
        memo[index][sum] = pick || notPick;;
        return memo[index][sum];
    }
}

// 1, 2, 3, 4

// sum = 10
