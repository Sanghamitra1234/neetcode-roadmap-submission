class Solution {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length + 1];
        return robUtil(nums, 0, dp);
    }

    public int robUtil(int[] nums, int index, int [] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] > 0) {
            return dp[index];
        }

        dp[index] = Math.max((nums[index] + robUtil(nums, index + 2, dp)), robUtil(nums, index + 1, dp));
        return dp[index];
        
    }
}
