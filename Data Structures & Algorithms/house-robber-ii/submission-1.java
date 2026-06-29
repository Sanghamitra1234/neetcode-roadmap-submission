class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int [] dp1 = new int [nums.length + 1];
        int [] dp2 = new int [nums.length + 1];
        return Math.max(robUtil(nums, 0, dp1, true), robUtil(nums, 1, dp2, false));
    }

    public int robUtil(int[] nums, int index, int [] dp, boolean isFirstHouseStolen) {
        if (index >= nums.length || isFirstHouseStolen && index == nums.length - 1) {
            return 0;
        }

        if (dp[index] > 0) {
            return dp[index];
        }
        dp[index] = Math.max((nums[index] + robUtil(nums, index + 2, dp, isFirstHouseStolen)), robUtil(nums, index + 1, dp, isFirstHouseStolen));
        return dp[index];
    }
}
